package com.employee.employeeJPA.entity;

import javax.persistence.*;
import java.util.*;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "department")
    private List<Employee> employees;
}