package com.example.employeemanager.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.employeemanager.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByEmail(String email);
    
    // Task 11 Challenge: Search for Employees by Name
    List<Employee> findByFullNameContainingIgnoreCase(String keyword);
}
