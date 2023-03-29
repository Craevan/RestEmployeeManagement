package com.crevan.restemployeemanagement.controller;

import com.crevan.restemployeemanagement.entity.Employee;
import com.crevan.restemployeemanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Employee>> getAllEmployees() {
        final List<Employee> employees = service.getAllEmployees();
        return employees != null && !employees.isEmpty()
                ? new ResponseEntity<>(employees, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable final int id) {
        final Employee employee = service.getEmployee(id);
        return employee != null
                ? new ResponseEntity<>(employee, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/employees")
    public ResponseEntity<?> addEmployee(@RequestBody final Employee employee) {
        return new ResponseEntity<>(service.saveEmployee(employee), HttpStatus.CREATED);
    }

    @PutMapping("/employees")
    public ResponseEntity<?> updateEmployee(@RequestBody final Employee employee) {
        return new ResponseEntity<>(service.saveEmployee(employee), HttpStatus.OK);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable final int id) {
        service.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
