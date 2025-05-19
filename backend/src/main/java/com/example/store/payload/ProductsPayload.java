package com.example.store.payload;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductsPayload {
    private String productName;
    private int price;
    private LocalDateTime createdAt;
}
