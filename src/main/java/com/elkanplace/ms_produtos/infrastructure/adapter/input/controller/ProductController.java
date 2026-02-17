package com.elkanplace.ms_produtos.infrastructure.adapter.input.controller;

import com.elkanplace.ms_produtos.application.port.input.CreateProductUseCasePort;
import com.elkanplace.ms_produtos.domain.model.Product;
import com.elkanplace.ms_produtos.infrastructure.adapter.input.dto.CreateProductRequest;
import com.elkanplace.ms_produtos.infrastructure.adapter.input.dto.ProductResponse;
import com.elkanplace.ms_produtos.infrastructure.adapter.input.mapper.ProductDtoMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
@Log4j2
public class ProductController {

    private final CreateProductUseCasePort createProductUseCasePort;
    private final ProductDtoMapper mapper;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ProductResponse create(@RequestBody @Valid CreateProductRequest request) {
        log.info("HTTP POST /api/products - payload name={}", request.name());
        Product product = createProductUseCasePort.execute(request);
        log.info("HTTP POST completed - id={}", product.getId());
        return mapper.toResponse(product);
    }
}
