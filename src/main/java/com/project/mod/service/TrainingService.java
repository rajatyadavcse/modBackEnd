package com.project.mod.service;

import java.util.Date;
import java.util.List;

import com.project.mod.model.Training;

public interface TrainingService {
	
	Training create(Training training);
	
	Training delete(int id);
	
	List<Training> findAll();
	
	Training findById(int id);
	
	Training update(Training training);
	
	List<Training> findTrainingByMentorId(Integer mentorId);
	
	List<Training> findTrainingByUserId(Integer userId);
	
	Training findByIdAndMentorId(Integer Id, Integer mentorId);
	
	Training findByIdAndUserId(Integer Id, Integer userId);
	
	List<Training> findByStartDateBetween(Date startDate, Date endDate);
}
