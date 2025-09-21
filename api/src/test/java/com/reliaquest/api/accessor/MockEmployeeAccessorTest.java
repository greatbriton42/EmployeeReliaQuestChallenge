package com.reliaquest.api.accessor;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

import com.reliaquest.api.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClient;

@ExtendWith(MockitoExtension.class)
public class MockEmployeeAccessorTest {

    private final RestClient restClientMock = mock(RestClient.class);

    private final RestClient.RequestHeadersUriSpec uriSpecMock = mock(RestClient.RequestHeadersUriSpec.class);
    private final RestClient.RequestBodySpec bodySpecMock = mock(RestClient.RequestBodySpec.class);
    private final RestClient.ResponseSpec responseSpecMock = mock(RestClient.ResponseSpec.class);

    private final MockEmployeeAccessor mockEmployeeAccessor = new MockEmployeeAccessor(restClientMock);

    private final Employee mockEmployee = Employee.builder()
            .id("1")
            .employeeAge(35)
            .employeeTitle("MyTitle")
            .employeeSalary(500000)
            .employeeEmail("MyTestEmail")
            .build();

    @BeforeEach
    public void setUp() {
        when(restClientMock.get()).thenReturn(uriSpecMock);
        when(uriSpecMock.uri(anyString(), (Object) any())).thenReturn(bodySpecMock);
        when(bodySpecMock.accept(MediaType.APPLICATION_JSON)).thenReturn(bodySpecMock);
        when(bodySpecMock.retrieve()).thenReturn(responseSpecMock);
    }

    @Test
    public void testGetEmployeesSuccess() {

        ResponseEntity<Employee> mockResponse = ResponseEntity.ok(mockEmployee);
        when(responseSpecMock.toEntity(Employee.class)).thenReturn(mockResponse);

        Employee employee = mockEmployeeAccessor.getEmployee(1);

        assertNotNull(employee);
        verify(uriSpecMock).uri("/employee/{id}", 1);
    }
}
