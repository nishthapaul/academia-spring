package com.iiitb.academia.rest;

import com.iiitb.academia.entity.Employee;
import com.iiitb.academia.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

//    @GetMapping("/employees")
//    public List<Employee> getEmployees() {
//        return EmployeeService.findAll();
//    }

//    @GetMapping("/employees/{employeeId}")
//    public Employee getEmployee(@PathVariable int employeeId) {
//        Employee Employee = EmployeeService.findById(employeeId);
//        if ( Employee == null ) {
//            throw new OrganisationNotFoundException("Employee with Employee Id : " + EmployeeId + " not found");
//        }
//        return Employee;
//    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        employee.setEmployeeId(0);
        return employeeService.save(employee);
    }

}
