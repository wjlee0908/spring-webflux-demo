package com.woojin.webfluxdemo.product.dto;

import lombok.Getter;

@Getter
public class UpdateProductRequest {
    private String name;

    private Long price;
}
