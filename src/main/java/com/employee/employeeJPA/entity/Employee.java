package com.employee.employeeJPA.entity;

import javax.persistence.*;
import java.util.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;
    @ManyToOne
    private Department department;
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Skill> skills;
}
