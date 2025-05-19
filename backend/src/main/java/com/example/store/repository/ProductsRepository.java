package com.example.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.store.model.Products;
import java.util.Optional;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long>{
    Products findById(long id);
    Optional<Products> findOptionalById(long id);
}
