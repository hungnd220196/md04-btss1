package com.ra.demo_springboot.service;

import com.ra.demo_springboot.model.Department;

import java.util.List;


public interface DepartmentService {
    List<Department> findAll();

    Department findById(Long id);

    Department save(Department department);

    Department update(Department department);

    void delete(Department department);
}
