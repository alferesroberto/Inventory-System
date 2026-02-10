package com.inventory.inventory_api.controller;

import com.inventory.inventory_api.dto.VentaRequestDTO;
import com.inventory.inventory_api.dto.VentaResponseDTO;
import com.inventory.inventory_api.service.VentaService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ventas")
@RequiredArgsConstructor
public class VentaController {

    private final VentaService ventaService;

    @PostMapping
    public VentaResponseDTO crear(@Valid @RequestBody VentaRequestDTO request) {
        return ventaService.procesarVenta(request);
    }
}
