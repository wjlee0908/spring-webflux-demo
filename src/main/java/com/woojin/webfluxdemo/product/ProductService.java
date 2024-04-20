package com.woojin.webfluxdemo.product;

import com.woojin.webfluxdemo.common.dto.ApiResponse;
import com.woojin.webfluxdemo.product.dto.CreateProductRequest;
import com.woojin.webfluxdemo.product.dto.UpdateProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static java.util.Objects.isNull;

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

    public Mono<Product> update(String id, UpdateProductRequest request) {
        Mono<Product> productMono = productRepository.findById(id);

        return productMono.flatMap(
                product -> {
                    if(!isNull(request.getName())) {
                        product.setName(request.getName());
                    }

                    if(!isNull(request.getPrice())) {
                        product.setPrice(request.getPrice());
                    }

                    return productRepository.save(product);
                }
        );
    }
}
