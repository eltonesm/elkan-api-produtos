package com.elkanplace.api_produtos.application.port.input;

import com.elkanplace.api_produtos.application.command.CreateProductCommand;
import com.elkanplace.api_produtos.domain.model.Product;

public interface CreateProductUseCasePort {

    Product execute(CreateProductCommand command);
}
