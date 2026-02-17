package com.elkanplace.ms_produtos.domain.model;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Builder
public class Product {

    private final String id;
    private final String name;
    private final String description;
    private final BigDecimal price;
    private final Integer stock;

    public static Product create(String name, String description, BigDecimal price, Integer stock) {
        return Product.builder()
                .id(UUID.randomUUID().toString())
                .name(name)
                .description(description)
                .price(price)
                .stock(stock)
                .build();
    }

    public Product decreaseStock(int quantity) {
        if (this.stock < quantity) {
            throw new IllegalArgumentException("Insufficient stock");
        }

        return Product.builder()
                .id(this.id)
                .name(this.name)
                .description(this.description)
                .price(this.price)
                .stock(this.stock - quantity)
                .build();
    }
}
