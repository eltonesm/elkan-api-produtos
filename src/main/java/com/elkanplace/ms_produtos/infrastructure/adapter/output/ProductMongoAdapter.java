package com.elkanplace.ms_produtos.infrastructure.adapter.output;

import com.elkanplace.ms_produtos.application.port.output.ProductRepositoryPort;
import com.elkanplace.ms_produtos.domain.model.Product;
import com.elkanplace.ms_produtos.infrastructure.adapter.output.mapper.ProductDocumentMapper;
import com.elkanplace.ms_produtos.infrastructure.adapter.output.repository.ProductMongoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Log4j2
public class ProductMongoAdapter implements ProductRepositoryPort {

    private final ProductDocumentMapper mapper;
    private final ProductMongoRepository repositoty;

    @Override
    public Product save(Product product) {
        log.debug("Saving product to MongoDB with id={}", product.getId());
        var document = mapper.toDocument(product);
        var saved = repositoty.save(document);
        log.debug("Product persisted successfully id={}", saved.getId());
        return mapper.toDomain(saved);
    }
}
