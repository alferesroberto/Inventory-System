package com.inventory.inventory_api.service;

import com.inventory.inventory_api.dto.CategoriaRequestDTO;
import com.inventory.inventory_api.dto.CategoriaResponseDTO;

import java.util.List;

public interface CategoriaService {

    CategoriaResponseDTO crear(CategoriaRequestDTO request);

    List<CategoriaResponseDTO> listar();

    CategoriaResponseDTO obtener(Long id);

    CategoriaResponseDTO actualizar(Long id, CategoriaRequestDTO request);

    void eliminar(Long id);
}
