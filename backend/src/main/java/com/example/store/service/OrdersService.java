package com.example.store.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.store.model.Orders;
import com.example.store.repository.OrdersRepository;
import com.example.store.service.Inf.IOrders;

@Service
public class OrdersService implements IOrders{

    OrdersRepository ordersRepository;

    public OrdersService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    @Override
    public List<Orders> findAllOrders() {
        return ordersRepository.findAll();
    }

    @Override
    public Orders findById(long id) {
       return ordersRepository.findById(id);
    }

    @Override
    public Orders save(Orders order) {
       return ordersRepository.save(order);
    }

    @Override
    public Optional<Orders> findOptionalById(long id) {
        return ordersRepository.findOptionalById(id);
    }

    @Override
    public List<Orders> findByCustomerId(long id) {
        return ordersRepository.findByCustomerId(id);
    }

    @Override
    public List<Orders> findByProductId(long id) {
       return ordersRepository.findByProductId(id);
    }

    @Override
    public List<Orders> findByEmployeeId(long id) {
       return ordersRepository.findByEmployeeId(id);
    }


    
}
