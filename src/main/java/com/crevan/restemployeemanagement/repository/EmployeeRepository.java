package com.crevan.restemployeemanagement.repository;

import com.crevan.restemployeemanagement.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
