package com.elkanplace.api_produtos.application.command;

import java.math.BigDecimal;

public record CreateProductCommand(

        String name,
        String description,
        BigDecimal price,
        Integer stock
) {}
