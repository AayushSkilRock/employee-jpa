package com.employee.employeeJPA.controller;

import com.employee.employeeJPA.entity.Employee;
import com.employee.employeeJPA.entity.Skill;
import com.employee.employeeJPA.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/employee")
    public String createEmployee(@RequestBody Employee emp) {
        employeeService.addEmployee(emp);
        return "Employee Added";
    }

    @PostMapping("/employees")
    public String createEmployees(@RequestBody List<Employee> employeeList) {
        employeeService.addEmployees(employeeList);
        return "Employees Added";
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable("id") int id) {
        Employee emp = employeeService.getEmployeeById(id);
        return emp;

    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/departments/{departmentId}/employees")
    public List<Employee> getEmployeesByDepartmentId(@PathVariable Integer departmentId) {
        return employeeService.getEmployeesByDepartmentId(departmentId);
    }
    @GetMapping("/skills/{skillId}/employees")
    public List<Employee> getEmployeesBySkillId(@PathVariable Integer skillId) {
        return employeeService.getEmployeesBySkillId(skillId);
    }


    @PostMapping("/skills")
    public Skill addSkill(@RequestBody Skill skill) {
        return employeeService.addSkill(skill);
    }


}