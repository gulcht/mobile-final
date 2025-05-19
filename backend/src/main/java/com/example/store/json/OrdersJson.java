package com.example.store.json;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.example.store.model.Customers;
import com.example.store.model.Employees;
import com.example.store.model.Products;
import com.example.store.model.Orders;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrdersJson {
    private long id;
    private Customers customer;
	private Employees employee;
    private Products product;
	private int orderTotal;
	private LocalDateTime createdAt;

    public static OrdersJson packJson(Orders order) {
		OrdersJson OrdersJson = new OrdersJson();
        OrdersJson.setId(order.getId());
		OrdersJson.setCustomer(order.getCustomer());
		OrdersJson.setEmployee(order.getEmployee());
		OrdersJson.setProduct(order.getProduct());
		OrdersJson.setOrderTotal(order.getOrderTotal());
		OrdersJson.setCreatedAt(order.getCreatedAt());
		return OrdersJson;
	}
	
	public static List<OrdersJson> packJsons(List<Orders> orders) {
		List<OrdersJson> orderListJson = new ArrayList<OrdersJson>();
		for(Orders order:orders) {
			orderListJson.add(packJson(order));
		}
		return orderListJson;
	}
}
