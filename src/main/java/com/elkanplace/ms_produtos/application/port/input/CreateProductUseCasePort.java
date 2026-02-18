package com.elkanplace.ms_produtos.application.port.input;

import com.elkanplace.ms_produtos.application.command.CreateProductCommand;
import com.elkanplace.ms_produtos.domain.model.Product;

public interface CreateProductUseCasePort {

    Product execute(CreateProductCommand command);
}
