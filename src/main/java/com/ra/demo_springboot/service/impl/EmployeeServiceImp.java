package com.ra.demo_springboot.service.impl;

import com.ra.demo_springboot.model.Employee;
import com.ra.demo_springboot.repository.EmployeeRepository;
import com.ra.demo_springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EmployeeServiceImp implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Employee Not Found"));
    }

    @Override
    public Employee save(Employee employee) {
        employeeRepository.save(employee);
        return employee;
    }

    @Override
    public Employee update(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void delete(Employee employee) {
        employeeRepository.delete(employee);

    }
}
