package com.elkanplace.api_produtos.infrastructure.adapter.output.repository;

import com.elkanplace.api_produtos.infrastructure.adapter.output.document.ProductDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductMongoRepository extends MongoRepository<ProductDocument, String> {
}
