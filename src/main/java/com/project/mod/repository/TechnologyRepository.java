package com.project.mod.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.project.mod.model.Technology;

public interface TechnologyRepository extends Repository<Technology, Integer> {
	
	Technology delete(Technology technology);
	
	List<Technology> findAll();
	
	Technology findOne(int id);
	
	Technology save(Technology technology);
}
