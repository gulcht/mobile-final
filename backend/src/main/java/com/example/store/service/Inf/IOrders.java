package com.example.store.service.Inf;

import java.util.List;
import java.util.Optional;

import com.example.store.model.Orders;

public interface IOrders {
    List<Orders> findAllOrders();
    List<Orders> findByCustomerId(long id);
    List<Orders> findByProductId(long id);
    List<Orders> findByEmployeeId(long id);
    Orders findById(long id);
    Orders save(Orders order);
    Optional<Orders> findOptionalById(long id);
}
