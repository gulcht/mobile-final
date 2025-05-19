package com.example.store.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.store.model.Employees;
import com.example.store.repository.EmployeesRepository;
import com.example.store.service.Inf.IEmployees;

@Service
public class EmployeesService implements IEmployees{

    EmployeesRepository employeesRepository;

    public EmployeesService(EmployeesRepository employeesRepository) {
        this.employeesRepository = employeesRepository;
    }

    @Override
    public Employees findById(long id) {
       return employeesRepository.findById(id);
    }

    @Override
    public Employees save(Employees employee) {
        return employeesRepository.save(employee);
    }

    @Override
    public Optional<Employees> findOptionalById(long id) {
       return employeesRepository.findOptionalById(id);
    }

}
