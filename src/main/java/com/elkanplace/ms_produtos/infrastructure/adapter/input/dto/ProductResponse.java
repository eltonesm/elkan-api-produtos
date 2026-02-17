package com.elkanplace.ms_produtos.infrastructure.adapter.input.dto;

import java.math.BigDecimal;

public record ProductResponse(
        String id,
        String name,
        String description,
        BigDecimal price,
        Integer stock
) {}
