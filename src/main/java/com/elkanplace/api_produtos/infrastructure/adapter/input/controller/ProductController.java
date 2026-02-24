package com.elkanplace.api_produtos.infrastructure.adapter.input.controller;

import com.elkanplace.api_produtos.application.port.input.CreateProductUseCasePort;
import com.elkanplace.api_produtos.application.port.input.GetProductByIdUseCasePort;
import com.elkanplace.api_produtos.domain.model.Product;
import com.elkanplace.api_produtos.infrastructure.adapter.input.dto.CreateProductRequest;
import com.elkanplace.api_produtos.infrastructure.adapter.input.dto.ProductDetailedResponse;
import com.elkanplace.api_produtos.infrastructure.adapter.input.dto.ProductResponse;
import com.elkanplace.api_produtos.infrastructure.adapter.input.mapper.ProductDtoMapper;
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
    private final GetProductByIdUseCasePort getProductByIdUseCasePort;
    private final ProductDtoMapper mapper;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ProductResponse create(@RequestBody @Valid CreateProductRequest request) {
        log.info("Creating product - name={}, price={}", request.name(), request.price());
        var command = mapper.toCommand(request);
        Product product = createProductUseCasePort.execute(command);
        return mapper.toResponse(product);
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ProductDetailedResponse findById(@PathVariable String id){
        log.info("Get Product - idProduct={}", id);
        return mapper.toDetailedResponse(getProductByIdUseCasePort.execute(id));
    }
}
