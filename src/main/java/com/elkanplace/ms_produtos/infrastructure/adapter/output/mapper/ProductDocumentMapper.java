package com.elkanplace.ms_produtos.infrastructure.adapter.output.mapper;

import com.elkanplace.ms_produtos.domain.model.Product;
import com.elkanplace.ms_produtos.infrastructure.adapter.output.document.ProductDocument;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductDocumentMapper {

    Product toDomain (ProductDocument document);

    ProductDocument toDocument(Product product);
}
