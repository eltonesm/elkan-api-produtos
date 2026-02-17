package com.elkanplace.ms_produtos.application.usecase;

import com.elkanplace.ms_produtos.application.port.input.CreateProductUseCasePort;
import com.elkanplace.ms_produtos.application.port.output.ProductRepositoryPort;
import com.elkanplace.ms_produtos.domain.model.Product;
import com.elkanplace.ms_produtos.infrastructure.adapter.input.dto.CreateProductRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class CreateProductUseCase implements CreateProductUseCasePort {

    private final ProductRepositoryPort productRepositoryPort;

    @Override
    public Product execute(CreateProductRequest request) {
        log.info("Starting product creation - name={}, price={}, stock={}", request.name(), request.price(), request.stock());
        Product product = Product.create(request);
        Product saveProduct = productRepositoryPort.save(product);
        log.info("Product sucessfully created - id={}", saveProduct.getId());
        return saveProduct;
    }
}
