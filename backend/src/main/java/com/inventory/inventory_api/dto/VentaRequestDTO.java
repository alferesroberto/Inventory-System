package com.inventory.inventory_api.dto;

import jakarta.validation.constraints.NotEmpty;
import java.util.List;

public record VentaRequestDTO(

        @NotEmpty
        List<ItemVentaDTO> items
) {
}
