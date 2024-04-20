package com.woojin.webfluxdemo.product;

import com.woojin.webfluxdemo.product.dto.CreateProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Mono<Product> getById(String id) {
        return productRepository.findById(id);
    }

    public Flux<Product> getManyRecent(int page, int limit) {
        Pageable pageable = PageRequest.of(page, limit);

        return productRepository.findAllByOrderByCreatedAtDesc(pageable);
    }

    public Mono<Product> create(CreateProductRequest request) {
        Product product = Product.builder()
                .name(request.getName())
                .price(request.getPrice())
                .build();

        return productRepository.save(product);
    }
}
