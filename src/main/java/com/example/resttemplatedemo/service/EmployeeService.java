package com.example.resttemplatedemo.service;

import com.example.resttemplatedemo.model.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getAllEmployee();
    public Employee getEmployee(int id);
    public Employee saveEmployee(Employee employee);
    public Employee updateEmployee(int id, Employee employee);
    public String deleteEmployee(int id);
}
