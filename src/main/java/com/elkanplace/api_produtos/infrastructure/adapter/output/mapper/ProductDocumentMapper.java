package com.elkanplace.api_produtos.infrastructure.adapter.output.mapper;

import com.elkanplace.api_produtos.domain.model.Product;
import com.elkanplace.api_produtos.infrastructure.adapter.output.document.ProductDocument;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductDocumentMapper {

    Product toDomain (ProductDocument document);

    ProductDocument toDocument(Product product);
}
