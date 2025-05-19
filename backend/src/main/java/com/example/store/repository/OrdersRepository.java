package com.example.store.repository;

import com.example.store.model.Orders;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {
    Orders findById(long id);
    List<Orders> findByCustomerId(long id);
    List<Orders> findByProductId(long id);
    List<Orders> findByEmployeeId(long id);
    Optional<Orders> findOptionalById(long id);
}
