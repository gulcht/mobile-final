package com.example.store.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.store.model.Customers;
import com.example.store.repository.CustomersRepository;
import com.example.store.service.Inf.ICustomers;

@Service
public class CustomersService implements ICustomers{

    
    CustomersRepository customersRepository;

    public CustomersService(CustomersRepository customersRepository) {
        this.customersRepository = customersRepository;
    }

    @Override
    public Customers findById(long id) {
        
        return customersRepository.findById(id);
    }

    @Override
    public Customers save(Customers customer) {
      return customersRepository.save(customer);
    }

    @Override
    public Optional<Customers> findOptionalById(long id) {
         return customersRepository.findOptionalById(id);
    }
}
