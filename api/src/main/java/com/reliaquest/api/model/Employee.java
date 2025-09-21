package com.reliaquest.api.model;

import lombok.Builder;

@Builder
public class Employee {
    private final String id;
    private final String employeeName;
    private final int employeeSalary;
    private final int employeeAge;
    private final String employeeTitle;
    private final String employeeEmail;
}
