package com.example.employeemanager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employeemanager.model.Employee;
import com.example.employeemanager.repository.EmployeeRepository;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployees(String keyword) {
        if (keyword != null && !keyword.trim().isEmpty()) {
            return employeeRepository.findByFullNameContainingIgnoreCase(keyword.trim());
        }
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public boolean isEmailUnique(String email, Long id) {
        Optional<Employee> existing = employeeRepository.findByEmail(email);
        if (existing.isEmpty()) {
            return true;
        }
        return id != null && existing.get().getId().equals(id);
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
    }
}
