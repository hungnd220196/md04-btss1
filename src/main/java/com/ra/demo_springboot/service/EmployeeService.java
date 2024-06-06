package com.ra.demo_springboot.service;

import com.ra.demo_springboot.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(Long id);

    Employee save(Employee employee);

    Employee update(Employee employee);

    void delete(Employee employee);
}
