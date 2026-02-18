package com.elkanplace.ms_produtos.infrastructure.adapter.input.mapper;

import com.elkanplace.ms_produtos.application.command.CreateProductCommand;
import com.elkanplace.ms_produtos.domain.model.Product;
import com.elkanplace.ms_produtos.infrastructure.adapter.input.dto.CreateProductRequest;
import com.elkanplace.ms_produtos.infrastructure.adapter.input.dto.ProductResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductDtoMapper {

    ProductResponse toResponse(Product product);

    CreateProductCommand toCommand(CreateProductRequest request);
}
