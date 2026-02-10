package com.inventory.inventory_api.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record ItemVentaDTO(

        @NotNull
        Long productoId,

        @NotNull
        @Min(1)
        Integer cantidad
) {
}
