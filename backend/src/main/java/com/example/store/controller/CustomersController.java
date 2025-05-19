package com.example.store.controller;

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

import com.example.store.business.CustomersBusiness;
import com.example.store.json.CustomersJson;
import com.example.store.model.Customers;
import com.example.store.payload.CustomersPayload;
import com.example.store.service.CustomersService;

@RestController
@RequestMapping("/api")
public class CustomersController {
    @Autowired
	CustomersService customersService;
	
	@Autowired
	CustomersBusiness customersBusiness;

	public CustomersController(CustomersService customersService) {
        this.customersService = customersService;
    }
	
	@PostMapping("/customers/save")
	public ResponseEntity<Void> saveCustomers(@RequestBody CustomersPayload payload) throws Exception {
		customersBusiness.saveCustomer(payload);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/customers/get/{id}")
	public ResponseEntity<CustomersJson> getCustomerById(@PathVariable("id") long id) throws Exception{
		return ResponseEntity.ok(customersBusiness.getCustomerId(id));
	}

	@PutMapping(value = "/customers/update/{id}")
	public ResponseEntity<CustomersJson> updateCustomers(@PathVariable("id") long id, @RequestBody CustomersPayload payload){
		Optional<Customers> customersData = customersService.findOptionalById(id);
		if(customersData.isPresent()) {
			customersBusiness.updateCustomer(customersData.get().getId(), payload);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
