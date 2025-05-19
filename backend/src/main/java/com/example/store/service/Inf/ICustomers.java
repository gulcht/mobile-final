package com.example.store.service.Inf;

import java.util.Optional;

import com.example.store.model.Customers;

public interface ICustomers {
	Customers findById(long id);
	Customers save(Customers user);
    Optional<Customers> findOptionalById(long id);
    // Customers update(Customers user);
}
