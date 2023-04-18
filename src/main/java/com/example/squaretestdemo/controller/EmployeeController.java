package com.example.squaretestdemo.controller;

import com.example.squaretestdemo.entity.Employee;
import com.example.squaretestdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping("/create")
    public ResponseEntity<String> createEmp(@RequestBody Employee employee){
        return service.createEmployee(employee);
    }

    @GetMapping("/get")
    public ResponseEntity<List<Employee>> getEmp(){
        return service.getAllEmp();
    }
    @DeleteMapping("/deleteByID/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id){
        return service.deleteEmployeeById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateById(@PathVariable String id){
        return service.updateEmployeeById(id);
    }

}
