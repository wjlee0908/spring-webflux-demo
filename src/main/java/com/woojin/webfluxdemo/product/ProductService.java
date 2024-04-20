package com.woojin.webfluxdemo.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Flux<Product> getMany(int page, int limit) {
        Pageable pageable = PageRequest.of(page, limit);
        return productRepository.findAllBy(pageable);
    }
}
