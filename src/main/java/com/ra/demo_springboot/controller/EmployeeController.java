package com.ra.demo_springboot.controller;

import com.ra.demo_springboot.model.Employee;
import com.ra.demo_springboot.service.DepartmentService;
import com.ra.demo_springboot.service.EmployeeService;
import com.ra.demo_springboot.service.UploadFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private UploadFile uploadFile;

    @GetMapping("")
    public String index(Model model) {
        List<Employee> list = employeeService.findAll();
        model.addAttribute("employees", list);
        return "employee/listEmployee";
    }

    @GetMapping("/addEmployee")
    public String addEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("department", departmentService.findAll());
        return "employee/add";
    }

    @PostMapping("/add")
    public String addEmployee(@ModelAttribute("employee") Employee employee, @RequestParam("imgUrl") MultipartFile file) {
        String imageUrl = uploadFile.uploadToLocal(file);
        employee.setImgUrl(imageUrl);
        employeeService.save(employee);
        return "redirect:/employee";
    }

    @GetMapping("/edit/{id}")
    public String editEmployee(@PathVariable("id") Long id, Model model) {
        model.addAttribute("employee", employeeService.findById(id));
        model.addAttribute("department", departmentService.findAll());
        return "employee/edit";
    }

    @PostMapping("/edit")
    public String editEmployee(Employee employee) {
        employeeService.save(employee);
        return "redirect:/employee";
    }
}
