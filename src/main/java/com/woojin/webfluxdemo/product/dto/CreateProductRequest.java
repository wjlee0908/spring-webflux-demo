package com.woojin.webfluxdemo.product.dto;

import lombok.Getter;

@Getter
public class CreateProductRequest {
    private String name;

    private Long price;
}
