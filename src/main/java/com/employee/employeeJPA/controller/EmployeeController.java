package com.employee.employeeJPA.controller;

import com.employee.employeeJPA.entity.Employee;
import com.employee.employeeJPA.entity.Skill;
import com.employee.employeeJPA.service.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> addSkill(@RequestBody Skill skill) {
        Skill existingSkill = employeeService.getSkillByName(skill.getSkillName());
        if (existingSkill != null) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body("Skill with name '" + skill.getSkillName() + "' already exists.");
        }
        Skill savedSkill = employeeService.addSkill(skill);
        return ResponseEntity.ok(savedSkill);
    }

    @GetMapping("/employees")
    public Page<Employee> getEmployees(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sort,
            @RequestParam(defaultValue = "asc") String direction) {

        Sort.Direction sortDirection = direction.equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, sort));

        return employeeService.getAllEmployees(pageable);
    }




}