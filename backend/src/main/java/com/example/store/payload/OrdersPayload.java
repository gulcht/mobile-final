package com.example.store.payload;

import java.time.LocalDateTime;

import com.example.store.model.Customers;
import com.example.store.model.Employees;
import com.example.store.model.Products;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrdersPayload {
    private Employees employee;
    private Customers customer;
    private Products product;
    private int orderTotal;
    private LocalDateTime createdAt;
}
