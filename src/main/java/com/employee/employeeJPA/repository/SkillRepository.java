package com.employee.employeeJPA.repository;

import com.employee.employeeJPA.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SkillRepository extends JpaRepository<Skill, Integer> {
    List<Skill> findByEmployee_Id(Integer employeeId);
}
