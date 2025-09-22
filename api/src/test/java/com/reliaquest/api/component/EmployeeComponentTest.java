package com.reliaquest.api.component;

import static com.reliaquest.api.constants.TestConstants.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.reliaquest.api.accessor.MockEmployeeAccessor;
import com.reliaquest.api.model.Employee;
import java.util.List;
import org.junit.jupiter.api.Test;

public class EmployeeComponentTest {

    private final MockEmployeeAccessor mockEmployeeAccessorMock = mock(MockEmployeeAccessor.class);

    private final EmployeeComponent employeeComponent = new EmployeeComponent(mockEmployeeAccessorMock);

    @Test
    public void testGetEmployeeById() {
        when(mockEmployeeAccessorMock.getEmployee(EMPLOYEE_ID)).thenReturn(TEST_EMPLOYEE_1);

        Employee employee = employeeComponent.getEmployeeById(EMPLOYEE_ID);

        assertEquals(TEST_EMPLOYEE_1, employee);
        verify(mockEmployeeAccessorMock).getEmployee(EMPLOYEE_ID);
    }

    @Test
    public void testGetEmployee() {
        List<Employee> allEmployees = List.of(TEST_EMPLOYEE_1, TEST_EMPLOYEE_2, TEST_EMPLOYEE_3);
        when(mockEmployeeAccessorMock.getEmployees()).thenReturn(allEmployees);

        List<Employee> employees = employeeComponent.getEmployees();

        assertTrue(employees.containsAll(allEmployees));
        assertEquals(3, employees.size());
        verify(mockEmployeeAccessorMock).getEmployees();
    }

    @Test
    public void testSearchEmployeeByNameExactMatch() {
        when(mockEmployeeAccessorMock.getEmployees()).thenReturn(ALL_EMPLOYEES);

        List<Employee> employees = employeeComponent.searchEmployeeByName(EMPLOYEE_NAME3);

        assertEquals(1, employees.size());
        assertEquals(TEST_EMPLOYEE_3, employees.get(0));
        verify(mockEmployeeAccessorMock).getEmployees();
    }

    @Test
    public void testSearchEmployeeByNamePartialMatch() {
        List<Employee> matchEmployees = List.of(TEST_EMPLOYEE_6, TEST_EMPLOYEE_5, TEST_EMPLOYEE_4, TEST_EMPLOYEE_7);

        when(mockEmployeeAccessorMock.getEmployees()).thenReturn(ALL_EMPLOYEES);

        List<Employee> employees = employeeComponent.searchEmployeeByName("Pevensie");

        assertEquals(4, employees.size());
        assertTrue(employees.containsAll(matchEmployees));
        verify(mockEmployeeAccessorMock).getEmployees();
    }

    @Test
    public void testGetHighestSalary() {
        when(mockEmployeeAccessorMock.getEmployees()).thenReturn(ALL_EMPLOYEES);

        int highestSalary = employeeComponent.getHighestSalary();

        assertEquals(HIGHEST_SALARY, highestSalary);
        verify(mockEmployeeAccessorMock).getEmployees();
    }

    @Test
    public void testGetTopEarnersNames() {
        when(mockEmployeeAccessorMock.getEmployees()).thenReturn(ALL_EMPLOYEES);

        List<String> highestNamesReturned = employeeComponent.getTopEarnersNames();

        assertTrue(highestNamesReturned.containsAll(
                HIGHEST_EARNINGS.stream().map(Employee::getEmployeeName).toList()));
        verify(mockEmployeeAccessorMock).getEmployees();
    }

    @Test
    public void testGetTopEarnersLessThanTen() {
        List<Employee> matchEmployees = List.of(TEST_EMPLOYEE_6, TEST_EMPLOYEE_5, TEST_EMPLOYEE_4, TEST_EMPLOYEE_7);

        when(mockEmployeeAccessorMock.getEmployees()).thenReturn(matchEmployees);

        List<String> highestNamesReturned = employeeComponent.getTopEarnersNames();

        assertTrue(highestNamesReturned.containsAll(
                matchEmployees.stream().map(Employee::getEmployeeName).toList()));
        verify(mockEmployeeAccessorMock).getEmployees();
    }

    @Test
    public void testCreateEmployee() {
        when(mockEmployeeAccessorMock.postEmployee(TEST_EMPLOYEE_1)).thenReturn(TEST_EMPLOYEE_1);

        Employee employee = employeeComponent.createEmployee(TEST_EMPLOYEE_1);

        assertEquals(TEST_EMPLOYEE_1, employee);
        verify(mockEmployeeAccessorMock).postEmployee(TEST_EMPLOYEE_1);
    }

    @Test
    public void testDeleteEmployee() {
        when(mockEmployeeAccessorMock.deleteEmployee(EMPLOYEE_ID)).thenReturn(TEST_EMPLOYEE_1);

        String employeeName = employeeComponent.deleteEmployee(EMPLOYEE_ID);

        assertEquals(EMPLOYEE_NAME1, employeeName);
        verify(mockEmployeeAccessorMock).deleteEmployee(EMPLOYEE_ID);
    }
}
