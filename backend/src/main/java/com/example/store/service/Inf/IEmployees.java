package com.example.store.service.Inf;

import java.util.Optional;

import com.example.store.model.Employees;

public interface IEmployees {
    Employees findById(long id);
	Employees save(Employees employee);
    // Employees update(Employees employee);
	Optional<Employees> findOptionalById(long id);
}
