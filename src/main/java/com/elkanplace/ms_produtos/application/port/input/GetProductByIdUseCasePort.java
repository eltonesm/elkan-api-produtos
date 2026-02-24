package com.elkanplace.ms_produtos.application.port.input;

import com.elkanplace.ms_produtos.domain.model.Product;

public interface GetProductByIdUseCasePort {

    Product execute(String id);
}
