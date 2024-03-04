package com.example.resttemplatedemo.controller;

import com.example.resttemplatedemo.model.Employee;
import com.example.resttemplatedemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee/")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public List<Employee> getAllEmployees(){
        return service.getAllEmployee();
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable("id") int id){
        return service.getEmployee(id);
    }

    @PostMapping
    public Employee saveEmployee(@RequestBody Employee employee){
        return service.saveEmployee(employee);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee){
        return service.updateEmployee(id,employee);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable("id") int id){
        return service.deleteEmployee(id);
    }
}
