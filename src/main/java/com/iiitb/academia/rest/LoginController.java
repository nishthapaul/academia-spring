package com.iiitb.academia.rest;

import com.iiitb.academia.entity.LoginRequest;
import com.iiitb.academia.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LoginController {
    private final EmployeeService employeeService;

    public LoginController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> getAuthenticationDetails(@RequestBody LoginRequest loginRequest) {
        return employeeService.authenticate(loginRequest);
    }
}
