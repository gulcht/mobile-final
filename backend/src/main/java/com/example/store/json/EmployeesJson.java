package com.example.store.json;

import java.util.ArrayList;
import java.util.List;

import com.example.store.model.Employees;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeesJson {
    private long id;
	private String firstName;
	private String lastName;
	private String user;
	private String password;
	private LocalDateTime createdAt;

    public static EmployeesJson packJson(Employees employee) {
		EmployeesJson employeesJson = new EmployeesJson();
        employeesJson.setId(employee.getId());
		employeesJson.setFirstName(employee.getFirstName());
		employeesJson.setLastName(employee.getLastName());
		employeesJson.setUser(employee.getUser());
		employeesJson.setPassword(employee.getPassword());
		employeesJson.setCreatedAt(employee.getCreatedAt());
		return employeesJson;
	}
	
	public static List<EmployeesJson> packJsons(List<Employees> employees) {
		List<EmployeesJson> employeesListJson = new ArrayList<EmployeesJson>();
		for(Employees employee:employees) {
			employeesListJson.add(packJson(employee));
		}
		return employeesListJson;
	}
}
