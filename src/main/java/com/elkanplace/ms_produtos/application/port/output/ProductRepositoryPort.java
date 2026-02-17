package com.elkanplace.ms_produtos.application.port.output;

import com.elkanplace.ms_produtos.domain.model.Product;

public interface ProductRepositoryPort {

    Product save(Product product);
}
