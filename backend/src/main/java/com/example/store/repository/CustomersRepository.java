package com.example.store.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.store.model.Customers;

@Repository
public interface CustomersRepository extends JpaRepository<Customers, Long>{
    Customers findById(long id);
    Optional<Customers> findOptionalById(long id);
}
