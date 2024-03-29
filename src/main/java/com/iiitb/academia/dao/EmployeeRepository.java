package com.iiitb.academia.dao;

import com.iiitb.academia.entity.Employee;
import com.iiitb.academia.entity.Organisation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Employee findByEmail(String email);
}
