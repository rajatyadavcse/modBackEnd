package com.project.mod.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.project.mod.model.Skill;

public interface SkillRepository  extends Repository<Skill, Integer> {
	
	Skill delete(Skill skill);
	
	List<Skill> findAll();
	
	Skill findOne(int id);
	
	Skill save(Skill skill);
}
