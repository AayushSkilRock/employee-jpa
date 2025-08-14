package com.employee.employeeJPA.repository;

import com.employee.employeeJPA.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByDepartmentId(Integer departmentId);
    List<Employee> findBySkillsId(Integer skillId);

}
