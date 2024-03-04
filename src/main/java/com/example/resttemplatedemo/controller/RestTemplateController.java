package com.example.resttemplatedemo.controller;

import com.example.resttemplatedemo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@RestController
public class RestTemplateController {

    private final String URL = "http://localhost:8080/employee/";
    private final String URL_ID = "http://localhost:8080/{id}";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/all-employees")
    public ResponseEntity getAll(){
        HttpHeaders header = new HttpHeaders();
        header.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> request = new HttpEntity<>(header);
        return restTemplate.exchange(URL, HttpMethod.GET,request, Employee[].class);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity getOne(@PathVariable("id") int id){
        HttpHeaders header = new HttpHeaders();
        header.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> request = new HttpEntity<>(header);
        return restTemplate.exchange(URL + id, HttpMethod.GET,request,Employee.class);
    }

    @PostMapping("/employees")
    public ResponseEntity createEmployee(@RequestBody Employee employee){
        HttpHeaders header = new HttpHeaders();
        header.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<Employee> request = new HttpEntity<>(employee,header);
        return restTemplate.exchange(URL,HttpMethod.POST,request,Employee.class);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee){
        HttpHeaders header =new HttpHeaders();
        header.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<Employee> request = new HttpEntity<>(employee, header);
        return restTemplate.exchange(URL + id, HttpMethod.PUT,request,Employee.class);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity deleteEmployee(@PathVariable("id") int id){
        HttpHeaders header = new HttpHeaders();
        header.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> request = new HttpEntity<>(header);
        return restTemplate.exchange(URL + id, HttpMethod.DELETE,request,String.class);
    }
}
