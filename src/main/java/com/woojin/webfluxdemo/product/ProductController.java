package com.woojin.webfluxdemo.product;

import com.woojin.webfluxdemo.common.dto.ApiResponse;
import com.woojin.webfluxdemo.product.dto.CreateProductRequest;
import com.woojin.webfluxdemo.product.dto.ManyProductRequest;
import com.woojin.webfluxdemo.product.dto.UpdateProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public Mono<ApiResponse> getMany(@RequestBody ManyProductRequest request){
        return productService.getManyRecent(request.getPage(), request.getLimit())
                .collectList()
                .map(products -> ApiResponse.builder()
                                .code(HttpStatus.OK.value())
                                .page(request.getPage())
                                .limit(request.getLimit())
                                .data(products)
                                .build()
                        );
    }

    @GetMapping("/{id}")
    public Mono<ApiResponse> getById(@PathVariable String id) {
        return productService.getById(id)
                .map(product -> ApiResponse.builder()
                        .code(HttpStatus.OK.value())
                        .data(product)
                        .build());
    }

    @PostMapping
    public Mono<ApiResponse> create(@RequestBody CreateProductRequest request) {
        Mono<ApiResponse> response = productService.create(request)
                .map(product -> ApiResponse.builder()
                        .code(HttpStatus.CREATED.value())
                        .data(product)
                        .build());

        return response;
    }

    @PutMapping("/{id}")
    public Mono<ApiResponse> update(@PathVariable String id, @RequestBody UpdateProductRequest request) {
        return productService.update(id, request)
                .map(product -> ApiResponse.builder()
                        .code(HttpStatus.OK.value())
                        .data(product)
                        .build());
    }

    @DeleteMapping("/{id}")
    public Mono<ApiResponse> delete(@PathVariable String id) {
        return productService.delete(id)
                .then(Mono.just(ApiResponse.builder()
                                .code(HttpStatus.OK.value())
                                .message("Product with id" + id + "has been deleted.")
                                .build()));
    }
}
