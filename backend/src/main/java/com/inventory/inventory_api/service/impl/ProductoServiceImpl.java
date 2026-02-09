package com.inventory.inventory_api.service.impl;

import com.inventory.inventory_api.dto.ProductoRequestDTO;
import com.inventory.inventory_api.dto.ProductoResponseDTO;
import com.inventory.inventory_api.entity.Categoria;
import com.inventory.inventory_api.entity.Producto;
import com.inventory.inventory_api.repository.CategoriaRepository;
import com.inventory.inventory_api.repository.ProductoRepository;
import com.inventory.inventory_api.service.ProductoService;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;
    private final CategoriaRepository categoriaRepository;

    @Override
    public ProductoResponseDTO crear(ProductoRequestDTO request) {

        Categoria categoria = categoriaRepository.findById(request.categoriaId())
                .orElseThrow(() -> new RuntimeException("Categoria no encontrada"));

        Producto producto = Producto.builder()
                .sku(request.sku())
                .nombre(request.nombre())
                .precio(request.precio())
                .stockActual(request.stockActual())
                .categoria(categoria)
                .build();

        Producto guardado = productoRepository.save(producto);

        return mapToDTO(guardado);
    }

    @Override
    public ProductoResponseDTO obtenerPorId(Long id) {

        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        return mapToDTO(producto);
    }

    @Override
    public Page<ProductoResponseDTO> listar(int page, int size) {

        Pageable pageable = PageRequest.of(page, size);

        return productoRepository.findAll(pageable)
                .map(this::mapToDTO);
    }

    @Override
    public ProductoResponseDTO actualizar(Long id, ProductoRequestDTO request) {

        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        Categoria categoria = categoriaRepository.findById(request.categoriaId())
                .orElseThrow(() -> new RuntimeException("Categoria no encontrada"));

        producto.setSku(request.sku());
        producto.setNombre(request.nombre());
        producto.setPrecio(request.precio());
        producto.setStockActual(request.stockActual());
        producto.setCategoria(categoria);

        return mapToDTO(productoRepository.save(producto));
    }

    @Override
    public void eliminar(Long id) {
        productoRepository.deleteById(id);
    }

    private ProductoResponseDTO mapToDTO(Producto producto) {
        return new ProductoResponseDTO(
                producto.getId(),
                producto.getSku(),
                producto.getNombre(),
                producto.getPrecio(),
                producto.getStockActual(),
                producto.getCategoria().getNombre()
        );
    }
}
