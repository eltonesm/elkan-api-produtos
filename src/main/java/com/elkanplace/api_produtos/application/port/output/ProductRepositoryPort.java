package com.elkanplace.api_produtos.application.port.output;

import com.elkanplace.api_produtos.domain.model.Product;

import java.util.Optional;

public interface ProductRepositoryPort {

    Product save(Product product);

    Optional<Product> findById(String id);
}
