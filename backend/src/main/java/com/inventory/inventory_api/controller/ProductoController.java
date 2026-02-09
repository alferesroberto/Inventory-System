package com.inventory.inventory_api.controller;

import com.inventory.inventory_api.dto.ProductoRequestDTO;
import com.inventory.inventory_api.dto.ProductoResponseDTO;
import com.inventory.inventory_api.service.ProductoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/productos")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoService productoService;

    @PostMapping
    public ProductoResponseDTO crear(@Valid @RequestBody ProductoRequestDTO request) {
        return productoService.crear(request);
    }

    @GetMapping("/{id}")
    public ProductoResponseDTO obtener(@PathVariable Long id) {
        return productoService.obtenerPorId(id);
    }

    @GetMapping
    public Page<ProductoResponseDTO> listar(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return productoService.listar(page, size);
    }

    @PutMapping("/{id}")
    public ProductoResponseDTO actualizar(
            @PathVariable Long id,
            @Valid @RequestBody ProductoRequestDTO request
    ) {
        return productoService.actualizar(id, request);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        productoService.eliminar(id);
    }
}
