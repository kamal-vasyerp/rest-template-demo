package com.example.resttemplatedemo.repository;

import com.example.resttemplatedemo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
