package com.elkanplace.api_produtos.infrastructure.adapter.output;

import com.elkanplace.api_produtos.application.port.output.ProductRepositoryPort;
import com.elkanplace.api_produtos.domain.model.Product;
import com.elkanplace.api_produtos.infrastructure.adapter.output.mapper.ProductDocumentMapper;
import com.elkanplace.api_produtos.infrastructure.adapter.output.repository.ProductMongoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.Optional;

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

    @Override
    public Optional<Product> findById(String id) {
        log.debug("Finding product in MongoDB id={}", id);
        return repository.findById(id)
                .map(mapper::toDomain);
    }
}
