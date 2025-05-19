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

import com.example.store.business.EmployeesBusiness;
import com.example.store.json.EmployeesJson;
import com.example.store.model.Employees;
import com.example.store.payload.EmployeesPayload;
import com.example.store.service.EmployeesService;

@RestController
@RequestMapping("/api")
public class EmployeesController {
    @Autowired
	EmployeesService employeesService;
	
	@Autowired
	EmployeesBusiness employeesBusiness;

	public EmployeesController(EmployeesService employeesService) {
        this.employeesService = employeesService;
    }
	
	@PostMapping("/employees/save")
	public ResponseEntity<Void> saveEmployees(@RequestBody EmployeesPayload payload) throws Exception {
		employeesBusiness.saveEmployee(payload);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	
	@GetMapping(value = "/employees/get/{id}")
	public ResponseEntity<EmployeesJson> getEmployeeById(@PathVariable("id") long id) throws Exception{
		return ResponseEntity.ok(employeesBusiness.getEmployeeId(id));
	}

	@PutMapping(value = "/employees/update/{id}")
	public ResponseEntity<EmployeesJson> updateEmployees(@PathVariable("id") long id, @RequestBody EmployeesPayload payload){
		Optional<Employees> employeesData = employeesService.findOptionalById(id);
		if(employeesData.isPresent()) {
			employeesBusiness.updateEmployee(employeesData.get().getId(), payload);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
