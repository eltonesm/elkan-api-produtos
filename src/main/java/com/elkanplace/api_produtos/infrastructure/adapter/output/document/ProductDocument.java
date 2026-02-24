package com.elkanplace.api_produtos.infrastructure.adapter.output.document;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(collection = "products")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDocument {

    @Id
    private String id;

    private String name;
    private String description;
    private BigDecimal price;
    private Integer stock;
}
