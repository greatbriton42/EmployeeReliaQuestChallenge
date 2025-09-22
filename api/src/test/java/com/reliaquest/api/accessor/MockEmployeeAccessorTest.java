package com.reliaquest.api.accessor;

import static com.reliaquest.api.constants.TestConstants.*;
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

    // Normally I would want to use @Mock and @InjectMock, but for some reason I couldn't get the build to work.
    // and didn't want to spend to much time messing with it when I have an alternative.
    // I don't know what you guys do internally, but figure I mention. This is just uglier and the reason Mockito
    // came out with the mentioned annotations.

    private final RestClient restClientMock = mock(RestClient.class);
    private final RestClient.RequestHeadersUriSpec uriSpecMock = mock(RestClient.RequestHeadersUriSpec.class);
    private final RestClient.RequestBodyUriSpec bodyUriSpecMock = mock(RestClient.RequestBodyUriSpec.class);
    private final RestClient.RequestBodySpec bodySpecMock = mock(RestClient.RequestBodySpec.class);
    private final RestClient.ResponseSpec responseSpecMock = mock(RestClient.ResponseSpec.class);

    private final MockEmployeeAccessor mockEmployeeAccessor = new MockEmployeeAccessor(restClientMock);

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
        ResponseEntity<Employee> mockResponse = ResponseEntity.ok(TEST_EMPLOYEE_1);
        when(responseSpecMock.toEntity(Employee.class)).thenReturn(mockResponse);

        Employee employee = mockEmployeeAccessor.getEmployee(EMPLOYEE_ID);

        assertNotNull(employee);
        verify(uriSpecMock).uri("/employee/{id}", EMPLOYEE_ID);
    }

    @Test
    public void testGetEmployeesSuccess() {
        setUpGetOrDelete();
        ResponseEntity<List<Employee>> mockResponse = ResponseEntity.ok(List.of(TEST_EMPLOYEE_1, TEST_EMPLOYEE_2));
        when(responseSpecMock.toEntity(new ParameterizedTypeReference<List<Employee>>() {}))
                .thenReturn(mockResponse);

        List<Employee> employee = mockEmployeeAccessor.getEmployees();

        assertNotNull(employee);
        verify(uriSpecMock).uri("/employee");
    }

    @Test
    public void testPostEmployeeSuccess() {
        setUpPost();

        ResponseEntity<Employee> mockResponse = ResponseEntity.ok(TEST_EMPLOYEE_3);
        when(responseSpecMock.toEntity(Employee.class)).thenReturn(mockResponse);

        Employee employee = mockEmployeeAccessor.postEmployee(TEST_EMPLOYEE_3);

        assertEquals(TEST_EMPLOYEE_3, employee);
        verify(bodyUriSpecMock).uri("/employee");
    }

    @Test
    public void testDeleteEmployeeSuccess() {
        setUpGetOrDelete();
        ResponseEntity<Employee> mockResponse = ResponseEntity.ok(TEST_EMPLOYEE_1);
        when(responseSpecMock.toEntity(Employee.class)).thenReturn(mockResponse);

        Employee employee = mockEmployeeAccessor.deleteEmployee(EMPLOYEE_ID);

        assertNotNull(employee);
        verify(uriSpecMock).uri("/employee/{id}", EMPLOYEE_ID);
    }
}
