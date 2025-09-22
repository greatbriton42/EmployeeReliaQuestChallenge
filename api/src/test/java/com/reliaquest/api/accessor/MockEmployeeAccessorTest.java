package com.reliaquest.api.accessor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

import com.reliaquest.api.model.Employee;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClient;

@ExtendWith(MockitoExtension.class)
public class MockEmployeeAccessorTest {

    private final RestClient restClientMock = mock(RestClient.class);

    // Normally I would want to use @Mock and @InjectMock, but for some reason I couldn't get the build to work.
    // I don't know what you guys internally, but figure I mention. This is just uglier and the reason Mockito
    // came out with the mentioned annotations.

    private final RestClient.RequestHeadersUriSpec uriSpecMock = mock(RestClient.RequestHeadersUriSpec.class);
    private final RestClient.RequestBodyUriSpec bodyUriSpecMock = mock(RestClient.RequestBodyUriSpec.class);
    private final RestClient.RequestBodySpec bodySpecMock = mock(RestClient.RequestBodySpec.class);
    private final RestClient.ResponseSpec responseSpecMock = mock(RestClient.ResponseSpec.class);

    private final MockEmployeeAccessor mockEmployeeAccessor = new MockEmployeeAccessor(restClientMock);

    private final Employee mockEmployee = Employee.builder()
            .id("1")
            .employeeAge(45)
            .employeeName("Bob Barker")
            .employeeTitle("MyBigTitle")
            .employeeSalary(500000)
            .employeeEmail("MyTestEmail")
            .build();

    private final Employee mockEmployee2 = Employee.builder()
            .id("2")
            .employeeAge(35)
            .employeeName("Steve Irwin")
            .employeeTitle("MyJrTitle")
            .employeeSalary(100000)
            .employeeEmail("MyTestEmail2")
            .build();

    public void setUpGetOrDelete() {
        when(restClientMock.get()).thenReturn(uriSpecMock);
        when(restClientMock.delete()).thenReturn(uriSpecMock);
        when(uriSpecMock.uri(anyString(), (Object) any())).thenReturn(bodySpecMock);
        when(uriSpecMock.uri(anyString())).thenReturn(bodySpecMock);
        when(bodySpecMock.accept(MediaType.APPLICATION_JSON)).thenReturn(bodySpecMock);
        when(bodySpecMock.retrieve()).thenReturn(responseSpecMock);
    }

    public void setUpPost() {
        when(restClientMock.post()).thenReturn(bodyUriSpecMock);
        when(bodyUriSpecMock.uri(anyString())).thenReturn(bodySpecMock);
        when(bodySpecMock.accept(MediaType.APPLICATION_JSON)).thenReturn(bodySpecMock);
        when(bodySpecMock.body((Object) any())).thenReturn(bodySpecMock);
        when(bodySpecMock.retrieve()).thenReturn(responseSpecMock);
    }

    @Test
    public void testGetEmployeeSuccess() {
        setUpGetOrDelete();
        ResponseEntity<Employee> mockResponse = ResponseEntity.ok(mockEmployee);
        when(responseSpecMock.toEntity(Employee.class)).thenReturn(mockResponse);

        Employee employee = mockEmployeeAccessor.getEmployee("1");

        assertNotNull(employee);
        verify(uriSpecMock).uri("/employee/{id}", "1");
    }

    @Test
    public void testGetEmployeesSuccess() {
        setUpGetOrDelete();
        ResponseEntity<List<Employee>> mockResponse = ResponseEntity.ok(List.of(mockEmployee, mockEmployee2));
        when(responseSpecMock.toEntity(new ParameterizedTypeReference<List<Employee>>() {}))
                .thenReturn(mockResponse);

        List<Employee> employee = mockEmployeeAccessor.getEmployees();

        assertNotNull(employee);
        verify(uriSpecMock).uri("/employee");
    }

    @Test
    public void testPostEmployeeSuccess() {
        setUpPost();
        final Employee createEmployee = Employee.builder()
                .id("3")
                .employeeAge(19)
                .employeeName("Randy Jones")
                .employeeTitle("MyNewTitle")
                .employeeSalary(60000)
                .employeeEmail("MyJobEmail")
                .build();

        ResponseEntity<Employee> mockResponse = ResponseEntity.ok(createEmployee);
        when(responseSpecMock.toEntity(Employee.class)).thenReturn(mockResponse);

        Employee employee = mockEmployeeAccessor.postEmployee(createEmployee);

        assertEquals(employee, createEmployee);
        verify(bodyUriSpecMock).uri("/employee");
    }

    @Test
    public void testDeleteEmployeeSuccess() {
        setUpGetOrDelete();
        ResponseEntity<Employee> mockResponse = ResponseEntity.ok(mockEmployee);
        when(responseSpecMock.toEntity(Employee.class)).thenReturn(mockResponse);

        Employee employee = mockEmployeeAccessor.deleteEmployee("1");

        assertNotNull(employee);
        verify(uriSpecMock).uri("/employee/{id}", "1");
    }
}
