package com.reliaquest.api.constants;

import com.reliaquest.api.model.Employee;
import java.util.List;

public class TestConstants {
    public static final String EMPLOYEE_ID = "MY_ID";
    public static final String EMPLOYEE_ID2 = "MY_ID2";
    public static final String EMPLOYEE_ID3 = "MY_ID3";
    public static final String EMPLOYEE_ID4 = "MY_ID4";
    public static final String EMPLOYEE_ID5 = "MY_ID5";
    public static final String EMPLOYEE_ID6 = "MY_ID6";
    public static final String EMPLOYEE_ID7 = "MY_ID7";
    public static final String EMPLOYEE_ID8 = "MY_ID8";
    public static final String EMPLOYEE_ID9 = "MY_ID9";
    public static final String EMPLOYEE_ID10 = "MY_ID10";
    public static final String EMPLOYEE_ID11 = "MY_ID11";
    public static final String EMPLOYEE_ID12 = "MY_ID12";
    public static final String EMPLOYEE_ID13 = "MY_ID13";

    public static final String EMPLOYEE_NAME1 = "Winston Smith";
    public static final String EMPLOYEE_NAME2 = "Henry Rearden";
    public static final String EMPLOYEE_NAME3 = "John Galt";
    public static final String EMPLOYEE_NAME4 = "Susan Pevensie";
    public static final String EMPLOYEE_NAME5 = "Edmund Pevensie";
    public static final String EMPLOYEE_NAME6 = "Lucy Pevensie";
    public static final String EMPLOYEE_NAME7 = "Peter Pevensie";
    public static final String EMPLOYEE_NAME8 = "Prince Caspian";
    public static final String EMPLOYEE_NAME9 = "Reepicheep";
    public static final String EMPLOYEE_NAME10 = "Aslan";
    public static final String EMPLOYEE_NAME11 = "Mr. Tummus";
    public static final String EMPLOYEE_NAME12 = "Jadis";
    public static final String EMPLOYEE_NAME13 = "Miraz";

    public static final int HIGHEST_SALARY = 100000000;

    public static final Employee TEST_EMPLOYEE_1 = Employee.builder()
            .id(EMPLOYEE_ID)
            .employeeAge(45)
            .employeeName(EMPLOYEE_NAME1)
            .employeeTitle("MyBigTitle")
            .employeeSalary(200000)
            .employeeEmail("MyTestEmail")
            .build();

    public static final Employee TEST_EMPLOYEE_2 = Employee.builder()
            .id(EMPLOYEE_ID2)
            .employeeAge(35)
            .employeeName(EMPLOYEE_NAME2)
            .employeeTitle("MyOwnerTitle")
            .employeeSalary(500000)
            .employeeEmail("MyTestEmail")
            .build();

    public static final Employee TEST_EMPLOYEE_3 = Employee.builder()
            .id(EMPLOYEE_ID3)
            .employeeAge(35)
            .employeeName(EMPLOYEE_NAME3)
            .employeeTitle("MyMysteryTitle")
            .employeeSalary(120000)
            .employeeEmail("MyTestEmail")
            .build();

    public static final Employee TEST_EMPLOYEE_4 = Employee.builder()
            .id(EMPLOYEE_ID4)
            .employeeAge(35)
            .employeeName(EMPLOYEE_NAME4)
            .employeeTitle("MyRoyalTitle")
            .employeeSalary(110000)
            .employeeEmail("MyTestEmail")
            .build();

    public static final Employee TEST_EMPLOYEE_5 = Employee.builder()
            .id(EMPLOYEE_ID5)
            .employeeAge(35)
            .employeeName(EMPLOYEE_NAME5)
            .employeeTitle("MyRoyalTitle")
            .employeeSalary(90000)
            .employeeEmail("MyTestEmail")
            .build();

    public static final Employee TEST_EMPLOYEE_6 = Employee.builder()
            .id(EMPLOYEE_ID6)
            .employeeAge(35)
            .employeeName(EMPLOYEE_NAME6)
            .employeeTitle("MyRoyalTitle")
            .employeeSalary(300000)
            .employeeEmail("MyTestEmail")
            .build();

    public static final Employee TEST_EMPLOYEE_7 = Employee.builder()
            .id(EMPLOYEE_ID7)
            .employeeAge(35)
            .employeeName(EMPLOYEE_NAME7)
            .employeeTitle("MyRoyalTitle")
            .employeeSalary(250001)
            .employeeEmail("MyTestEmail")
            .build();

    public static final Employee TEST_EMPLOYEE_8 = Employee.builder()
            .id(EMPLOYEE_ID8)
            .employeeAge(35)
            .employeeName(EMPLOYEE_NAME8)
            .employeeTitle("MyRoyalTitle")
            .employeeSalary(250000)
            .employeeEmail("MyTestEmail")
            .build();

    public static final Employee TEST_EMPLOYEE_9 = Employee.builder()
            .id(EMPLOYEE_ID9)
            .employeeAge(35)
            .employeeName(EMPLOYEE_NAME9)
            .employeeTitle("Knight")
            .employeeSalary(75000)
            .employeeEmail("MyTestEmail")
            .build();

    public static final Employee TEST_EMPLOYEE_10 = Employee.builder()
            .id(EMPLOYEE_ID10)
            .employeeAge(35)
            .employeeName(EMPLOYEE_NAME10)
            .employeeTitle("Lion")
            .employeeSalary(HIGHEST_SALARY)
            .employeeEmail("MyTestEmail")
            .build();

    public static final Employee TEST_EMPLOYEE_11 = Employee.builder()
            .id(EMPLOYEE_ID11)
            .employeeAge(35)
            .employeeName(EMPLOYEE_NAME11)
            .employeeTitle("Sir")
            .employeeSalary(35000)
            .employeeEmail("MyTestEmail")
            .build();

    public static final Employee TEST_EMPLOYEE_12 = Employee.builder()
            .id(EMPLOYEE_ID12)
            .employeeAge(35)
            .employeeName(EMPLOYEE_NAME12)
            .employeeTitle("Witch")
            .employeeSalary(85000)
            .employeeEmail("MyTestEmail")
            .build();

    public static final Employee TEST_EMPLOYEE_13 = Employee.builder()
            .id(EMPLOYEE_ID13)
            .employeeAge(35)
            .employeeName(EMPLOYEE_NAME13)
            .employeeTitle("Uncle")
            .employeeSalary(55000)
            .employeeEmail("MyTestEmail")
            .build();

    public static final List<Employee> ALL_EMPLOYEES = List.of(
            TEST_EMPLOYEE_1,
            TEST_EMPLOYEE_2,
            TEST_EMPLOYEE_3,
            TEST_EMPLOYEE_4,
            TEST_EMPLOYEE_5,
            TEST_EMPLOYEE_6,
            TEST_EMPLOYEE_7,
            TEST_EMPLOYEE_8,
            TEST_EMPLOYEE_9,
            TEST_EMPLOYEE_10,
            TEST_EMPLOYEE_11,
            TEST_EMPLOYEE_12,
            TEST_EMPLOYEE_13);

    public static final List<Employee> HIGHEST_EARNINGS = List.of(
            TEST_EMPLOYEE_1,
            TEST_EMPLOYEE_2,
            TEST_EMPLOYEE_3,
            TEST_EMPLOYEE_4,
            TEST_EMPLOYEE_6,
            TEST_EMPLOYEE_7,
            TEST_EMPLOYEE_8,
            TEST_EMPLOYEE_9,
            TEST_EMPLOYEE_10,
            TEST_EMPLOYEE_11);
}
