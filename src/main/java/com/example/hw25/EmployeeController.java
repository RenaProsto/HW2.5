package com.example.hw25;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String name, @RequestParam String surname) {
        return employeeService.add(name, surname);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String name, @RequestParam String surname) {
        return employeeService.find(name, surname);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam String name, @RequestParam String surname) {
        return employeeService.remove(name, surname);
    }

    @GetMapping("/getAll")
    public List<Employee> getEmployee() {
        return employeeService.getAll();
    }

}

