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
    private final ProductMongoRepository repository;


    @Override
    public Product save(Product product) {

        try {

            log.debug("Saving product to MongoDB with id={}", product.getId());
            var document = mapper.toDocument(product);
            var saved = repository.save(document);
            log.debug("Product persisted successfully id={}", saved.getId());
            return mapper.toDomain(saved);

        } catch (Exception ex) {
            log.error("event=product_persist status=error id={} message={}",
                    product.getId(), ex.getMessage(), ex);
            throw new RuntimeException("Error persisting product", ex);
        }
    }
}
