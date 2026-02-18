package com.elkanplace.ms_produtos.application.usecase;

import com.elkanplace.ms_produtos.application.command.CreateProductCommand;
import com.elkanplace.ms_produtos.application.port.input.CreateProductUseCasePort;
import com.elkanplace.ms_produtos.application.port.output.ProductRepositoryPort;
import com.elkanplace.ms_produtos.domain.model.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class CreateProductUseCase implements CreateProductUseCasePort {

    private final ProductRepositoryPort productRepositoryPort;

    @Override
    public Product execute(CreateProductCommand command) {
        log.info("Starting product creation - name={}, price={}, stock={}", command.name(), command.price(), command.stock());
        Product product = Product.create(command.name(), command.description(), command.price(), command.stock());
        Product savedProduct = productRepositoryPort.save(product);
        log.info("Product sucessfully created - id={}", savedProduct.getId());
        return savedProduct;
    }
}
