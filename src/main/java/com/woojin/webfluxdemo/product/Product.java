package com.woojin.webfluxdemo.product;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
@Getter
@Setter
@Builder
public class Product {
    @Id
    private String id;

    private String name;

    private Long price;

    @CreatedDate
    private LocalDateTime createdAt;
}
