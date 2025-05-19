package com.example.store.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.store.json.EmployeesJson;
import com.example.store.model.Employees;
import com.example.store.payload.EmployeesPayload;
import com.example.store.service.EmployeesService;

@Service
public class EmployeesBusiness{
    @Autowired
    EmployeesService employeesService;

    public EmployeesJson getEmployeeId(long id) {
		return EmployeesJson.packJson(employeesService.findById(id));
	}

    public void saveEmployee(EmployeesPayload employeesPayload) {
		Employees employee = new Employees(
            employeesPayload.getFirstName(),
            employeesPayload.getLastName(),
            employeesPayload.getUser(),
            employeesPayload.getPassword(),
            employeesPayload.getCreatedAt()
                );
		employeesService.save(employee);
	}
    public void updateEmployee(long id, EmployeesPayload employeesPayload) {
		Employees employeeData = employeesService.findById(id);
		employeeData.setFirstName(employeesPayload.getFirstName());
		employeeData.setLastName(employeesPayload.getLastName());
        employeeData.setUser(employeesPayload.getUser());
		employeeData.setPassword(employeesPayload.getPassword());
        employeeData.setCreatedAt(employeesPayload.getCreatedAt());
		employeesService.save(employeeData);
	}
}
