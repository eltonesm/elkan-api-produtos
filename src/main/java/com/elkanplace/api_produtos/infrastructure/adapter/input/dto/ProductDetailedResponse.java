package com.elkanplace.api_produtos.infrastructure.adapter.input.dto;

import java.math.BigDecimal;

public record ProductDetailedResponse(

        String id,
        String name,
        String description,
        BigDecimal price,
        Integer stock
) {}
