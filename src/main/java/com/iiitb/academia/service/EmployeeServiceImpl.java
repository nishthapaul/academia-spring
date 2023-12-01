package com.iiitb.academia.service;

import com.iiitb.academia.dao.EmployeeRepository;
import com.iiitb.academia.entity.Employee;
import com.iiitb.academia.entity.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    @Autowired

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public ResponseEntity<?> authenticate(LoginRequest loginRequest) {
        Employee employee = employeeRepository.findByEmail(loginRequest.getEmail());
        if (employee != null && employee.getPassword().equals(loginRequest.getPassword())) {
            if (employee.getDepartment().getName().equals("Outreach")) {
                return new ResponseEntity<>("Successfully Authenticated !!", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Do not belong to Outreach Department !!", HttpStatus.FORBIDDEN);
            }
        }
        return new ResponseEntity<>("Invalid Credentials !!", HttpStatus.FORBIDDEN);
    }
}
