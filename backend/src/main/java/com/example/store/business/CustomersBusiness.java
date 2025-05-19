package com.example.store.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.store.json.CustomersJson;
import com.example.store.model.Customers;
import com.example.store.payload.CustomersPayload;
import com.example.store.service.CustomersService;

@Service
public class CustomersBusiness{
    
    @Autowired
    CustomersService customersService;

    public CustomersJson getCustomerId(long id) {
        return CustomersJson.packJson(customersService.findById(id));
    }

    public void saveCustomer(CustomersPayload customersPayload) {
		Customers customer = new Customers(
            customersPayload.getFirstName(),
            customersPayload.getLastName(),
            customersPayload.getUser(),
            customersPayload.getPassword(),
            customersPayload.getCreatedAt()
                );
		customersService.save(customer);
	}
    public void updateCustomer(long id, CustomersPayload customersPayload) {
		Customers customerData = customersService.findById(id);
		customerData.setFirstName(customersPayload.getFirstName());
		customerData.setLastName(customersPayload.getLastName());
        customerData.setCUser(customersPayload.getUser());
		customerData.setPassword(customersPayload.getPassword());
        customerData.setCreatedAt(customersPayload.getCreatedAt());
		customersService.save(customerData);
	}
}
