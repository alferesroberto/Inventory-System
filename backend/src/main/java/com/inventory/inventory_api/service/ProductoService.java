package com.inventory.inventory_api.service;

import com.inventory.inventory_api.dto.ProductoRequestDTO;
import com.inventory.inventory_api.dto.ProductoResponseDTO;

import org.springframework.data.domain.Page;

public interface ProductoService {

    ProductoResponseDTO crear(ProductoRequestDTO request);

    ProductoResponseDTO obtenerPorId(Long id);

    Page<ProductoResponseDTO> listar(int page, int size);

    ProductoResponseDTO actualizar(Long id, ProductoRequestDTO request);

    void eliminar(Long id);
}
