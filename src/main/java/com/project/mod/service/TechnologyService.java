package com.project.mod.service;

import java.util.List;

import com.project.mod.model.Technology;

public interface TechnologyService {
	
	Technology create(Technology technology);
	
	Technology delete(int id);
	
	List<Technology> findAll();
	
	Technology findById(int id);
	
	Technology update(Technology technology);
}
