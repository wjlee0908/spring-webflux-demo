package com.woojin.webfluxdemo.product;

import com.woojin.webfluxdemo.common.dto.ApiResponse;
import com.woojin.webfluxdemo.product.dto.ManyProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public Mono<ApiResponse> getMany(@RequestBody ManyProductRequest request){
        return productService.getMany(request.getPage(), request.getLimit())
                .collectList()
                .map(products -> ApiResponse.builder()
                                .code(HttpStatus.OK.value())
                                .page(request.getPage())
                                .limit(request.getLimit())
                                .data(products)
                                .build()
                        );
    }
}
