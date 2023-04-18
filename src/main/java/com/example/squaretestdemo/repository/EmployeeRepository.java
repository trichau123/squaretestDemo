package com.example.squaretestdemo.repository;

import com.example.squaretestdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,String> {
}
