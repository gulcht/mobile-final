package com.example.store.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.store.model.Products;
import com.example.store.repository.ProductsRepository;
import com.example.store.service.Inf.IProducts;

@Service
public class ProductsService implements IProducts{

    ProductsRepository productsRepository;

    public ProductsService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    @Override
    public Products findById(long id) {
        return productsRepository.findById(id);
    }

    @Override
    public Products save(Products product) {
        return productsRepository.save(product);
    }

    @Override
    public Optional<Products> findOptionalById(long id) {
        return productsRepository.findOptionalById(id);
    }

   
    
}
