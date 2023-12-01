package com.iiitb.academia.service;

import com.iiitb.academia.dao.EmployeeRepository;
import com.iiitb.academia.dao.OrganisationRepository;
import com.iiitb.academia.entity.Employee;
import com.iiitb.academia.entity.Organisation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

}
