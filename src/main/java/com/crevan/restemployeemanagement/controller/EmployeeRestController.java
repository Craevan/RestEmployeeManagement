package com.crevan.restemployeemanagement.controller;

import com.crevan.restemployeemanagement.entity.Employee;
import com.crevan.restemployeemanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService service;

    @Autowired
    public void setService(final EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return service.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable final int id) {
        return service.getEmployee(id);
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody final Employee employee) {
        service.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody final Employee employee) {
        service.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable final int id) {
        service.deleteEmployee(id);
        return "Employee with ID = " + id + " was deleted";
    }
}
