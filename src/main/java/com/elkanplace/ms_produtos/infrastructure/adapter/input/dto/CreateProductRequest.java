package com.elkanplace.ms_produtos.infrastructure.adapter.input.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record CreateProductRequest(

        @NotBlank String name,

        String description,

        @NotNull BigDecimal price,

        @NotNull Integer stock

) {}
