package com.crevan.restemployeemanagement.service;

import com.crevan.restemployeemanagement.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    void saveEmployee(final Employee employee);

    Employee getEmployee(final int id);

    void deleteEmployee(final int id);
}
