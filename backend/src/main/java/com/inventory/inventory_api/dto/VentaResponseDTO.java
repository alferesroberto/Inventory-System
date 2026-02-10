package com.inventory.inventory_api.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record VentaResponseDTO(

        Long id,
        LocalDateTime fechaVenta,
        BigDecimal total,
        List<VentaDetalleResponseDTO> detalles
) {
}
