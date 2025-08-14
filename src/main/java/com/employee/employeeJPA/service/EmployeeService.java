package com.employee.employeeJPA.service;

import com.employee.employeeJPA.entity.Employee;
import com.employee.employeeJPA.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Optional<Employee> getEmployeeById(Integer id) {
        return employeeRepository.findById(id);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public List<Employee> getEmployeesByDepartment(Integer departmentId) {
        return employeeRepository.findByDepartmentId(departmentId);
    }

    public List<Employee> getEmployeesBySkill(Integer skillId) {
        return employeeRepository.findBySkillsId(skillId);
    }

    public Page<Employee> findAllEmployees(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }
}
