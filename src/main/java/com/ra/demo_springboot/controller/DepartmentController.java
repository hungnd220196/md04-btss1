package com.ra.demo_springboot.controller;

import com.ra.demo_springboot.model.Department;
import com.ra.demo_springboot.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("")
    public String department(Model model) {
        model.addAttribute("departments", departmentService.findAll());
        return "department/home";
    }

    @GetMapping("/add")
    public String addDepartment(Model model) {
        model.addAttribute("department", new Department());
        return "department/add";
    }

    @PostMapping("/add")
    public String addDepartment(Department department) {
        departmentService.save(department);
        return "redirect:/department";
    }

    @GetMapping("/edit/{id}")
    public String editDepartment(@PathVariable("id") Long id, Model model) {
        Department department = departmentService.findById(id);
        model.addAttribute("department", department);
        return "department/edit";
    }

    @PostMapping("/edit")
    public String updateDepartment(@ModelAttribute("department") Department department) {
        department.setId(departmentService.findById(department.getId()).getId());
        departmentService.save(department);
        return "redirect:/department";
    }

    @GetMapping("/delete/{id}")
    public String deleteDepartment(@PathVariable("id") Long id) {
        departmentService.delete(departmentService.findById(id));
        return "redirect:/department";
    }

}
