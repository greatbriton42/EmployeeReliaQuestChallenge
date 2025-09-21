package com.reliaquest.api.accessor;

import com.reliaquest.api.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
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

    public Employee getEmployee(final int id) {
        final ResponseEntity<Employee> response = restClient
                .get()
                .uri("/employee/{id}", id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .toEntity(Employee.class);

        return response.getBody();
    }
}
