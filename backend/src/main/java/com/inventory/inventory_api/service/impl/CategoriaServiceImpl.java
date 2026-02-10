package com.inventory.inventory_api.service.impl;

import com.inventory.inventory_api.dto.CategoriaRequestDTO;
import com.inventory.inventory_api.dto.CategoriaResponseDTO;
import com.inventory.inventory_api.entity.Categoria;
import com.inventory.inventory_api.repository.CategoriaRepository;
import com.inventory.inventory_api.service.CategoriaService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;

    @Override
    public CategoriaResponseDTO crear(CategoriaRequestDTO request) {

        Categoria categoria = Categoria.builder()
                .nombre(request.nombre())
                .descripcion(request.descripcion())
                .build();

        return mapToDTO(categoriaRepository.save(categoria));
    }

    @Override
    public List<CategoriaResponseDTO> listar() {
        return categoriaRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    @Override
    public CategoriaResponseDTO obtener(Long id) {

        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria no encontrada"));

        return mapToDTO(categoria);
    }

    @Override
    public CategoriaResponseDTO actualizar(Long id, CategoriaRequestDTO request) {

        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria no encontrada"));

        categoria.setNombre(request.nombre());
        categoria.setDescripcion(request.descripcion());

        return mapToDTO(categoriaRepository.save(categoria));
    }

    @Override
    public void eliminar(Long id) {
        categoriaRepository.deleteById(id);
    }

    private CategoriaResponseDTO mapToDTO(Categoria categoria) {
        return new CategoriaResponseDTO(
                categoria.getId(),
                categoria.getNombre(),
                categoria.getDescripcion()
        );
    }
}
