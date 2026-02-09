package com.inventory.inventory_api.dto;

import java.math.BigDecimal;

public record ProductoResponseDTO(

        Long id,
        String sku,
        String nombre,
        BigDecimal precio,
        Integer stockActual,
        String categoria
) {
}
