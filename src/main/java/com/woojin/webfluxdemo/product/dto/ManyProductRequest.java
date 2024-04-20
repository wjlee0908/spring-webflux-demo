package com.woojin.webfluxdemo.product.dto;

import lombok.Getter;

@Getter
public class ManyProductRequest {
    private int page;
    private int limit;
}
