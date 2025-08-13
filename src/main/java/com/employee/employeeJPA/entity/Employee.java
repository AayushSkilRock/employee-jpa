package com.employee.employeeJPA.entity;

import javax.persistence.*;
import java.util.*;

@Entity
public class Employee {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;
    @OneToMany
    private Address address;
    @ManyToOne
    private Department department;
    @OneToMany
    private List<Skill> skills;
}
