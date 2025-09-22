package com.reliaquest.api.accessor;

import com.reliaquest.api.model.Employee;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class MockEmployeeAccessor {

    private final RestClient restClient;

    @Autowired
    public MockEmployeeAccessor(RestClient restClient) {
        this.restClient = restClient;
    }

    public Employee getEmployee(final String id) {
        final ResponseEntity<Employee> response = restClient
                .get()
                .uri("/employee/{id}", id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .toEntity(Employee.class);

        return response.getBody();
    }

    public List<Employee> getEmployees() {
        final ResponseEntity<List<Employee>> response = restClient
                .get()
                .uri("/employee")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .toEntity(new ParameterizedTypeReference<List<Employee>>() {});

        return response.getBody();
    }

    public Employee postEmployee(Employee newEmployee) {
        final ResponseEntity<Employee> response = restClient
                .post()
                .uri("/employee")
                .accept(MediaType.APPLICATION_JSON)
                .body(newEmployee)
                .retrieve()
                .toEntity(Employee.class);

        return response.getBody();
    }

    public Employee deleteEmployee(String id) {
        final ResponseEntity<Employee> response = restClient
                .delete()
                .uri("/employee/{id}", id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .toEntity(Employee.class);

        return response.getBody();
    }
}
