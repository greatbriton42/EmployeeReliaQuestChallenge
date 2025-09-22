package com.reliaquest.api.component;

import com.reliaquest.api.accessor.MockEmployeeAccessor;
import com.reliaquest.api.model.Employee;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeComponent {
    private final MockEmployeeAccessor employeeAccessor;

    @Autowired
    public EmployeeComponent(MockEmployeeAccessor employeeAccessor) {
        this.employeeAccessor = employeeAccessor;
    }

    public Employee getEmployeeById(String id) {
        return employeeAccessor.getEmployee(id);
    }

    public List<Employee> getEmployees() {
        return employeeAccessor.getEmployees();
    }

    public List<Employee> searchEmployeeByName(String name) {
        final List<Employee> allEmployees = employeeAccessor.getEmployees();

        return allEmployees.stream()
                .filter(employee -> Objects.equals(employee.getEmployeeName(), name))
                .toList();
    }

    public int getHighestSalary() {
        final List<Employee> allEmployees = employeeAccessor.getEmployees();

        final Optional<Employee> highestEmployee = allEmployees.stream()
                .max((curr, next) -> Integer.max(curr.getEmployeeSalary(), next.getEmployeeSalary()));

        return highestEmployee.map(Employee::getEmployeeSalary).orElse(0);
    }

    public List<String> getTopEarnersNames() {
        final List<Employee> allEmployees = employeeAccessor.getEmployees();
        final PriorityQueue<Employee> topTenEmployees =
                new PriorityQueue<>(10, Comparator.comparing(Employee::getEmployeeSalary));

        allEmployees.forEach(employee -> {
            if (!topTenEmployees.offer(employee)) {
                assert topTenEmployees.peek() != null;
                if (topTenEmployees.peek().getEmployeeSalary() < employee.getEmployeeSalary()) {
                    topTenEmployees.poll();
                    topTenEmployees.add(employee);
                }
            }
        });
        return topTenEmployees.stream().map(Employee::getEmployeeName).toList();
    }

    public Employee createEmployee(Employee employee) {
        return employeeAccessor.postEmployee(employee);
    }

    public String deleteEmployee(String id) {
        return employeeAccessor.deleteEmployee(id).getEmployeeName();
    }
}
