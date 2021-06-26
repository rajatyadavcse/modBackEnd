package com.project.mod.service;

import java.util.List;

import com.project.mod.model.Skill;


public interface SkillService {
	
	Skill create(Skill skill);
	
	Skill delete(int id);
	
	List<Skill> findAll();
	
	Skill findById(int id);
	
	Skill update(Skill skill);
}
