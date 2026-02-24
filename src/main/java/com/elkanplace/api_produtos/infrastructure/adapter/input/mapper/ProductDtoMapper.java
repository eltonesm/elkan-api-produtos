package com.elkanplace.api_produtos.infrastructure.adapter.input.mapper;

import com.elkanplace.api_produtos.application.command.CreateProductCommand;
import com.elkanplace.api_produtos.domain.model.Product;
import com.elkanplace.api_produtos.infrastructure.adapter.input.dto.CreateProductRequest;
import com.elkanplace.api_produtos.infrastructure.adapter.input.dto.ProductDetailedResponse;
import com.elkanplace.api_produtos.infrastructure.adapter.input.dto.ProductResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductDtoMapper {

    ProductResponse toResponse(Product product);

    ProductDetailedResponse toDetailedResponse(Product product);

    CreateProductCommand toCommand(CreateProductRequest request);
}
