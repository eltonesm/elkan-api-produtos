package com.elkanplace.ms_produtos.application.port.input;

import com.elkanplace.ms_produtos.domain.model.Product;
import com.elkanplace.ms_produtos.infrastructure.adapter.input.dto.CreateProductRequest;

public interface CreateProductUseCasePort {

    Product execute(CreateProductRequest request);
}
