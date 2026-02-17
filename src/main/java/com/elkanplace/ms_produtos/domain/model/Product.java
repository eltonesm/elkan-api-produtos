package com.elkanplace.ms_produtos.domain.model;

import com.elkanplace.ms_produtos.infrastructure.adapter.input.dto.CreateProductRequest;
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

    public static Product create(CreateProductRequest request) {
        return Product.builder()
                .id(UUID.randomUUID().toString())
                .name(request.name())
                .description(request.description())
                .price(request.price())
                .stock(request.stock())
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
