package com.reliaquest.api.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController implements IEmployeeController {

    @Override
    @GetMapping("/employees")
    public ResponseEntity<List> getAllEmployees() {
        return null;
    }

    @Override
    @GetMapping("/employee/{searchString}")
    public ResponseEntity<List> getEmployeesByNameSearch(String searchString) {
        return null;
    }

    @Override
    @GetMapping("/employee/{id}")
    public ResponseEntity getEmployeeById(String id) {
        return null;
    }

    @Override
    @GetMapping("/employee/salary/highest")
    public ResponseEntity<Integer> getHighestSalaryOfEmployees() {
        return null;
    }

    @Override
    @GetMapping("/employee/salary/topTen")
    public ResponseEntity<List<String>> getTopTenHighestEarningEmployeeNames() {
        return null;
    }

    @Override
    @PostMapping("/employee")
    public ResponseEntity createEmployee(Object employeeInput) {

        return null;
    }

    @Override
    @DeleteMapping("/employee/{id}")
    public ResponseEntity<String> deleteEmployeeById(String id) {
        return null;
    }
}
