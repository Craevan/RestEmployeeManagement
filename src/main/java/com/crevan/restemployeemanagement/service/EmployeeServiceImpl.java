package com.crevan.restemployeemanagement.service;

import com.crevan.restemployeemanagement.entity.Employee;
import com.crevan.restemployeemanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository repository;

    @Autowired
    public void setRepository(final EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    @Override
    public void saveEmployee(final Employee employee) {
        repository.save(employee);
    }

    @Override
    public Employee getEmployee(final int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void deleteEmployee(final int id) {
        repository.deleteById(id);
    }
}
