package com.iiitb.academia.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private int departmentId;

    @Column(name = "name")
    private String name;

    @Column(name = "capacity")
    private int capacity;

    public Department() {
    }

    public Department(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }
}
