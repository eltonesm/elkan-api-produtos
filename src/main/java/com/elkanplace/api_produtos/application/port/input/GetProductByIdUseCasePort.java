package com.elkanplace.api_produtos.application.port.input;

import com.elkanplace.api_produtos.domain.model.Product;

public interface GetProductByIdUseCasePort {

    Product execute(String id);
}
