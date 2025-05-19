package com.example.store.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.store.json.OrdersJson;
import com.example.store.model.Orders;
import com.example.store.payload.OrdersPayload;
import com.example.store.service.OrdersService;

@Service
public class OrdersBusiness{
    @Autowired
    OrdersService ordersService;

    
    public OrdersJson getOrderById(long id) {
		return OrdersJson.packJson(ordersService.findById(id));
	}
    public List<OrdersJson> getAllOrders() {
		return OrdersJson.packJsons(ordersService.findAllOrders());
	}

    public List<OrdersJson> getOrderByCustomerId(long id) {
		return OrdersJson.packJsons(ordersService.findByCustomerId(id));
	}
    public List<OrdersJson> getOrderByProductId(long id) {
		return OrdersJson.packJsons(ordersService.findByProductId(id));
	}
    public List<OrdersJson> getOrderByEmployeeId(long id) {
		return OrdersJson.packJsons(ordersService.findByEmployeeId(id));
	}
    // public OrdersJson getOrderByProductId(long id) {
	// 	return OrdersJson.packJson(ordersService.findByProductId(id));
	// }

    public void saveOrder(OrdersPayload ordersPayload) {
		Orders order = new Orders(
            ordersPayload.getCustomer(),
            ordersPayload.getEmployee(),
            ordersPayload.getProduct(),
            ordersPayload.getOrderTotal(),
            ordersPayload.getCreatedAt()
                );
		ordersService.save(order);
	}
    public void updateOrder(long id, OrdersPayload ordersPayload) {
		Orders orderData = ordersService.findById(id);
		orderData.setCustomer(ordersPayload.getCustomer());
		orderData.setEmployee(ordersPayload.getEmployee());
        orderData.setProduct(ordersPayload.getProduct());
		orderData.setOrderTotal(ordersPayload.getOrderTotal());
        orderData.setCreatedAt(ordersPayload.getCreatedAt());
		ordersService.save(orderData);
	}
}
