package com.ra.demo_springboot.service.impl;

import com.ra.demo_springboot.model.Department;
import com.ra.demo_springboot.repository.DepartmentRepository;
import com.ra.demo_springboot.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DepartmentServiceImp implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Department findById(Long id) {
        return departmentRepository.findById(id).orElseThrow(() -> new NoSuchElementException("khong ton tai san pham co ma" + id));
    }

    @Override
    public Department save(Department department) {
        department.setStatus(true);
        departmentRepository.save(department);
        return department;
    }

    @Override
    public Department update(Department department) {
        departmentRepository.findById(department.getId()).orElseThrow(() -> new NoSuchElementException("khong ton tai san pham co ma " + department.getId()));
        return departmentRepository.save(department);
    }

    @Override
    public void delete(Department department) {
        departmentRepository.delete(department);
    }
}
