package com.inventory.inventory_api.service;

import com.inventory.inventory_api.dto.VentaRequestDTO;
import com.inventory.inventory_api.dto.VentaResponseDTO;

public interface VentaService {

    VentaResponseDTO procesarVenta(VentaRequestDTO request);
}
