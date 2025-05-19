package com.example.store.service.Inf;

import java.util.Optional;

import com.example.store.model.Products;

public interface IProducts {
    Products findById(long id);
	Products save(Products user);
    // Products update(Products user);
	Optional<Products> findOptionalById(long id);
}
