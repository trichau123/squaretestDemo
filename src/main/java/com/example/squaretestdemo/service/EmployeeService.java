package com.example.squaretestdemo.service;

import com.example.squaretestdemo.entity.Employee;
import com.example.squaretestdemo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public ResponseEntity<String> createEmployee(Employee employee){
       if(repository.save(employee)!=null){
           return new ResponseEntity<>("Create success", HttpStatus.CREATED);
       };
        return new ResponseEntity<>("Create fail", HttpStatus.PRECONDITION_FAILED);
    }

    public ResponseEntity<List<Employee>> getAllEmp(){
        return new ResponseEntity<>(repository.findAll(),HttpStatus.OK);
    }

    public ResponseEntity<String> deleteEmployeeById(String id){
        if(repository.findById(id).isPresent()){
            repository.deleteById(id);
            return new ResponseEntity<>("Deleted",HttpStatus.OK);
        }
        return new ResponseEntity<>("Not found id",HttpStatus.NOT_FOUND);
    }
    public ResponseEntity<String> updateEmployeeById(String id){
        if(repository.findById(id).isPresent()){
            repository.save(repository.findById(id).get());
            return new ResponseEntity<>("Updated",HttpStatus.OK);
        }
        return new ResponseEntity<>("Not found id",HttpStatus.NOT_FOUND);
    }
}
