package com.inventory.inventory_api.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public record ProductoRequestDTO(

        @NotBlank
        String sku,

        @NotBlank
        String nombre,

        @NotNull
        @DecimalMin(value = "0.0", inclusive = false)
        BigDecimal precio,

        @NotNull
        @Min(0)
        Integer stockActual,

        @NotNull
        Long categoriaId
) {
}
