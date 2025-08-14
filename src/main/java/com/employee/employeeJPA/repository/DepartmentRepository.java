package com.employee.employeeJPA.repository;

import com.employee.employeeJPA.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
