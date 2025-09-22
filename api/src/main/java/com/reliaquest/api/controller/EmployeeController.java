package com.reliaquest.api.controller;

import com.reliaquest.api.component.EmployeeComponent;
import com.reliaquest.api.model.Employee;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController implements IEmployeeController {

    private final EmployeeComponent employeeComponent;

    @Autowired
    EmployeeController(EmployeeComponent employeeComponent) {
        this.employeeComponent = employeeComponent;
    }

    @Override
    @GetMapping("/employees")
    public ResponseEntity<List> getAllEmployees() {
        List<Employee> employees = employeeComponent.getEmployees();
        return ResponseEntity.ok(employees);
    }

    @Override
    @GetMapping("/employee/{searchString}")
    public ResponseEntity<List> getEmployeesByNameSearch(String searchString) {
        List<Employee> employees = employeeComponent.searchEmployeeByName(searchString);
        return ResponseEntity.ok(employees);
    }

    @Override
    @GetMapping("/employee/{id}")
    public ResponseEntity getEmployeeById(String id) {
        Employee employee = employeeComponent.getEmployeeById(id);
        return ResponseEntity.ok(employee);
    }

    @Override
    @GetMapping("/employee/salary/highest")
    public ResponseEntity<Integer> getHighestSalaryOfEmployees() {
        int highestSalary = employeeComponent.getHighestSalary();
        return ResponseEntity.ok(highestSalary);
    }

    @Override
    @GetMapping("/employee/salary/topTen")
    public ResponseEntity<List<String>> getTopTenHighestEarningEmployeeNames() {
        List<String> topSalaryNames = employeeComponent.getTopEarnersNames();
        return ResponseEntity.ok(topSalaryNames);
    }

    @Override
    @PostMapping("/employee")
    public ResponseEntity createEmployee(Object employeeInput) {
        if (employeeInput instanceof Employee emp) {
            Employee highestSalary = employeeComponent.createEmployee(emp);
            return ResponseEntity.ok(highestSalary);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    @DeleteMapping("/employee/{id}")
    public ResponseEntity<String> deleteEmployeeById(String id) {
        String employee = employeeComponent.deleteEmployee(id);
        return ResponseEntity.ok(employee);
    }
}
