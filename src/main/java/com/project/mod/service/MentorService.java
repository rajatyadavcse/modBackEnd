package com.project.mod.service;

import java.util.List;

import com.project.mod.model.Mentor;

public interface MentorService {
	
	Mentor create(Mentor mentor);
	
	Mentor delete(int id);
	
	List<Mentor> findAll();
	
	Mentor findById(int id);
	
	Mentor update(Mentor mentor);
	
	Mentor findMentor(String userName, String password);
}
