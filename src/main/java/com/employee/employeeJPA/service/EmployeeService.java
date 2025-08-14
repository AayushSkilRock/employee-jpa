package com.employee.employeeJPA.service;

import com.employee.employeeJPA.entity.Address;
import com.employee.employeeJPA.entity.Department;
import com.employee.employeeJPA.entity.Employee;
import com.employee.employeeJPA.entity.Skill;
import com.employee.employeeJPA.repository.AddressRepository;
import com.employee.employeeJPA.repository.DepartmentRepository;
import com.employee.employeeJPA.repository.EmployeeRepository;
import com.employee.employeeJPA.repository.SkillRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final SkillRepository skillRepository;
    private final AddressRepository addressRepository;
    public EmployeeService(EmployeeRepository employeeRepository,
                           DepartmentRepository departmentRepository,
                           SkillRepository skillRepository,
                           AddressRepository addressRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
        this.skillRepository = skillRepository;
        this.addressRepository = addressRepository;
    }


    public void addEmployee(Employee employee) {
        if (employee.getDepartment() != null && employee.getDepartment().getId() != null) {
            Department existingDept = departmentRepository.findById(employee.getDepartment().getId())
                    .orElseThrow(() -> new RuntimeException("Department not found with id " + employee.getDepartment().getId()));
            employee.setDepartment(existingDept);
        }

        if (employee.getSkills() != null) {
            List<Skill> updatedSkills = new ArrayList<>();
            for (Skill skill : employee.getSkills()) {
                if (skill.getId() != null) {
                    Skill existingSkill = skillRepository.findById(skill.getId())
                            .orElseThrow(() -> new RuntimeException("Skill not found with id " + skill.getId()));
                    updatedSkills.add(existingSkill);
                } else {
                    skill.setEmployee(employee);
                    updatedSkills.add(skill);
                }
            }
            employee.setSkills(updatedSkills);
        }

        if (employee.getAddresses() != null) {
            for (Address address : employee.getAddresses()) {
                address.setEmployee(employee);
            }
        }

        employeeRepository.save(employee);
    }


    public void addEmployees(List<Employee> employees) {
        for (Employee employee : employees) {
            if (employee.getAddresses() != null) {
                for (Address address : employee.getAddresses()) {
                    address.setEmployee(employee);
                }
            }

            if (employee.getSkills() != null) {
                for (Skill skill : employee.getSkills()) {
                    skill.setEmployee(employee);
                }
            }
        }

        employeeRepository.saveAll(employees);
    }

    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
    public List<Employee> getEmployeesByDepartmentId(Integer departmentId) {
        return employeeRepository.findByDepartmentId(departmentId);
    }
    public List<Employee> getEmployeesBySkillId(Integer id) {
        return employeeRepository.findBySkillsId(id);
    }

    public Skill addSkill(Skill skill) {
        return skillRepository.save(skill);
    }
}

