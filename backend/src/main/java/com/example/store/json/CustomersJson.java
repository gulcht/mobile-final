package com.example.store.json;

import java.util.ArrayList;
import java.util.List;

import com.example.store.model.Customers;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomersJson {
    private long id;
	private String firstName;
	private String lastName;
	private String cUser;
	private String password;
	private LocalDateTime createdAt;

    public static CustomersJson packJson(Customers customer) {
		CustomersJson customersJson = new CustomersJson();
        customersJson.setId(customer.getId());
		customersJson.setFirstName(customer.getFirstName());
		customersJson.setLastName(customer.getLastName());
		customersJson.setCUser(customer.getCUser());
		customersJson.setPassword(customer.getPassword());
		customersJson.setCreatedAt(customer.getCreatedAt());
		return customersJson;
	}
	
	public static List<CustomersJson> packJsons(List<Customers> customers) {
		List<CustomersJson> customersListJson = new ArrayList<CustomersJson>();
		for(Customers customer:customers) {
			customersListJson.add(packJson(customer));
		}
		return customersListJson;
	}
}
