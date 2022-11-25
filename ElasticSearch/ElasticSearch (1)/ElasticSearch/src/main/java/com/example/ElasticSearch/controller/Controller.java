package com.example.ElasticSearch.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ElasticSearch.model.Employee;
import com.example.ElasticSearch.repository.EmployeeRepository;

@RestController
public class Controller {
     
    @Autowired
    private EmployeeRepository repository;
     
    @PostMapping("/saveEmployee")
    public String saveEmployee(@RequestBody List<Employee> employees) {
        System.out.println(employees.toString());
        repository.saveAll(employees);
        return employees.size() + " employee(s) have been inserted ...";
    }
 
    @GetMapping("/findEverything")
    public Iterable<Employee> findAllEmployees() {
        return repository.findAll();
    }
 
    @GetMapping("/findByFName/{firstName}")
    public List<Employee> findByFirstName(@PathVariable String firstName) {
        return repository.findByFirstname(firstName);


    }
    @GetMapping("/findById/{id}")
    public Optional<Employee> findByid(@PathVariable String id) {
        return repository.findById(id);
    }
0
    
    @DeleteMapping("/deleteById/{id}")
    public String deleteById(@PathVariable String id)
    {
    	repository.deleteById(id);
    	
    	return "object with id : " + id + " deleted" ;
    }
}