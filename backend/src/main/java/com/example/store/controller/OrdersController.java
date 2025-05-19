package com.example.store.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.store.business.OrdersBusiness;
import com.example.store.json.OrdersJson;
import com.example.store.model.Orders;
import com.example.store.payload.OrdersPayload;
import com.example.store.service.OrdersService;

@RestController
@RequestMapping("/api")
public class OrdersController {
    @Autowired
	OrdersService ordersService;
	
	@Autowired
	OrdersBusiness ordersBusiness;

	public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }
	
	@PostMapping("/orders/save")
	public ResponseEntity<Void> saveOrders(@RequestBody OrdersPayload payload) throws Exception {
		ordersBusiness.saveOrder(payload);
		return new ResponseEntity<>(HttpStatus.CREATED);
		
	}
	
	@GetMapping(value = "/orders/get/{id}")
	public ResponseEntity<OrdersJson> getOrderById(@PathVariable("id") long id) throws Exception{
		return ResponseEntity.ok(ordersBusiness.getOrderById(id));
	}

    @GetMapping(value = "/orders/get/all")
	public ResponseEntity<List<OrdersJson>> getAllOrders() throws Exception{
		return ResponseEntity.ok(ordersBusiness.getAllOrders());
	}

    @GetMapping(value = "/orders/get/{id}/customers")
	public ResponseEntity<List<OrdersJson>> getOrderByCustomerId(@PathVariable("id") long id) throws Exception{
		return ResponseEntity.ok(ordersBusiness.getOrderByCustomerId(id));
	}

    @GetMapping(value = "/orders/get/{id}/employees")
	public ResponseEntity<List<OrdersJson>> getOrderByEmoployeeId(@PathVariable("id") long id) throws Exception{
		return ResponseEntity.ok(ordersBusiness.getOrderByEmployeeId(id));
	}
    @GetMapping(value = "/orders/get/{id}/products")
	public ResponseEntity<List<OrdersJson>> getOrderByProductId(@PathVariable("id") long id) throws Exception{
		return ResponseEntity.ok(ordersBusiness.getOrderByProductId(id));
	}
	@PutMapping(value = "/orders/update/{id}")
	public ResponseEntity<OrdersJson> updateOrders(@PathVariable("id") long id, @RequestBody OrdersPayload payload){
		Optional<Orders> ordersData = ordersService.findOptionalById(id);
		if(ordersData.isPresent()) {
			ordersBusiness.updateOrder(ordersData.get().getId(), payload);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
