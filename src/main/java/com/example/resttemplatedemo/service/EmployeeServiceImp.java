package com.example.resttemplatedemo.service;

import com.example.resttemplatedemo.model.Employee;
import com.example.resttemplatedemo.repository.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeService{

    private final EmployeeRepository repo;

    public EmployeeServiceImp(EmployeeRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Employee> getAllEmployee() {
        return repo.findAll();
    }

    @Override
    public Employee getEmployee(int id) {
        return repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee was not present in the database."));
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return repo.save(employee);
    }

    @Override
    public Employee updateEmployee(int id, Employee employee) {
        Employee oldEmployee = getEmployee(id);
        oldEmployee.setId(employee.getId());
        oldEmployee.setName(employee.getName());
        oldEmployee.setSalary(employee.getSalary());
        return repo.save(oldEmployee);
    }

    @Override
    public String deleteEmployee(int id) {
        repo.deleteById(id);
        return "Employee Deleted From the Database";
    }

}
