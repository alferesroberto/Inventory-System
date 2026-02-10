package com.inventory.inventory_api.dto;

import jakarta.validation.constraints.NotBlank;

public record CategoriaRequestDTO(

        @NotBlank
        String nombre,

        String descripcion
) {
}
