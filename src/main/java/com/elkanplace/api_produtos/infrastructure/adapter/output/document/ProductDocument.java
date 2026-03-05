package com.elkanplace.api_produtos.infrastructure.adapter.output.document;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.Instant;

@Document(collection = "products")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDocument {

    @Id
    private String id;

    @Indexed
    private String name;
    private String description;
    @Indexed
    private BigDecimal price;
    private Integer stock;

    private Instant createdAt;
    private Instant updatedAt;
}
