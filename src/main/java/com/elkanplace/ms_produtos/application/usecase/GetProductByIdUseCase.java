package com.elkanplace.ms_produtos.application.usecase;

import com.elkanplace.ms_produtos.application.port.input.GetProductByIdUseCasePort;
import com.elkanplace.ms_produtos.application.port.output.ProductRepositoryPort;
import com.elkanplace.ms_produtos.domain.model.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class GetProductByIdUseCase implements GetProductByIdUseCasePort {

    private final ProductRepositoryPort productRepositoryPort;

    @Override
    public Product execute(String id) {
        log.info("Starting product getById - id={}", id);
        Product product = productRepositoryPort.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        log.info("Product sucessfully getById - id={}", id);
        return product;
    }
}
