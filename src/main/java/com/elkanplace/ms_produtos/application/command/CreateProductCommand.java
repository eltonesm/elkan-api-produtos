package com.elkanplace.ms_produtos.application.command;

import java.math.BigDecimal;

public record CreateProductCommand(

        String name,
        String description,
        BigDecimal price,
        Integer stock
) {}
