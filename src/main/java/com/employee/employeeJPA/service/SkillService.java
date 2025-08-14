package com.employee.employeeJPA.service;

import com.employee.employeeJPA.entity.Skill;
import com.employee.employeeJPA.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SkillService {

    @Autowired
    private SkillRepository skillRepository;

    public Skill saveSkill(Skill skill) {
        return skillRepository.save(skill);
    }

    public Optional<Skill> getSkillById(Integer id) {
        return skillRepository.findById(id);
    }
}
