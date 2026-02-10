package com.inventory.inventory_api.dto;

import java.math.BigDecimal;

public record VentaDetalleResponseDTO(

        String producto,
        Integer cantidad,
        BigDecimal precioUnitario
) {
}
