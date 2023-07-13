package com.example.hw25;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {
    private final Map<String, Employee> employeeFullName = new HashMap<>();

    public Employee add(String name, String surname) {
        int maxEmployees = 2;
        if (employeeFullName.size() >= maxEmployees) {
            throw new EmployeeStorageIsFullException();
        }


        Employee newEmployee = new Employee(name, surname);
        String fullName = getFullName(newEmployee);

        if (employeeFullName.containsKey(fullName)) {
            throw new EmployeeAlreadyAddedException();
        }

        employeeFullName.put(fullName,newEmployee);
        return newEmployee;
    }

    public Employee find(String name, String surname) {
        Employee employeeFind = new Employee(name, surname);
        String fullName = getFullName(employeeFind);

        if (!employeeFullName.containsKey(fullName)) {
            throw new EmployeeNotFoundException();
        }
        return employeeFullName.get(fullName);
    }

    public Employee remove(String name, String surname) {
        Employee employeeRemove = new Employee(name, surname);
        String fullName = getFullName(employeeRemove);
        if (!employeeFullName.containsKey(fullName)) {
            throw new EmployeeAlreadyAddedException();
        }
        employeeFullName.remove(fullName);
        return employeeRemove;
    }

    public Collection<Employee> getAll() {
        return employeeFullName.values();
    }

    private String getFullName(Employee employee) {
        return employee.getName() + employee.getSurname();
    }
}
