package com.example.hw25;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private final ArrayList<Employee> employees = new ArrayList<>();

    public Employee add(String name, String surname) {
        int maxEmployees = 2;
        if (employees.size() >= maxEmployees) {
            throw new EmployeeStorageIsFullException();
        }
        Employee newEmployee = new Employee(name, surname);
        if (employees.contains(newEmployee)) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.add(newEmployee);
        return newEmployee;
    }

    public Employee find(String name, String surname) {
        Employee employeeFind = new Employee(name, surname);

        if (!employees.contains(employeeFind)) {
            throw new EmployeeNotFoundException();
        }
        return employees.get(employees.indexOf(employeeFind));
    }

    public Employee remove(String name, String surname) {
        Employee employeeRemove = new Employee(name, surname);
        if (employees.contains(employeeRemove)) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.remove(employeeRemove);
        return employeeRemove;

    }

    public List<Employee> getAll() {
        return employees;
    }
}
