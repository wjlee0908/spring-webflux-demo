package com.woojin.webfluxdemo.product;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Product {
    @Id
    private String id;

    private String name;

    private Long price;
}
