package com.iiitb.academia.service;

import com.iiitb.academia.entity.Employee;
import com.iiitb.academia.entity.LoginRequest;
import org.springframework.http.ResponseEntity;

public interface EmployeeService {
    Employee save(Employee employee);

    ResponseEntity<?> authenticate(LoginRequest loginRequest);
}
