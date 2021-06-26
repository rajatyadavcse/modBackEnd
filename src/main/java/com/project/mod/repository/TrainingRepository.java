package com.project.mod.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.Repository;

import com.project.mod.model.Training;

public interface TrainingRepository extends Repository<Training, Integer> {
	
	Training delete(Training training);
	
	List<Training> findAll();
	
	Training findOne(int id);
	
	Training save(Training training);
	
	List<Training> findTrainingByMentorId(Integer mentorId);
	
	List<Training> findTrainingByUserId(Integer userId);
	
	Training findByIdAndMentorId(Integer id, Integer mentorId);
	
	Training findByIdAndUserId(Integer id, Integer userId);
	
	List<Training> findByStartDateBetween(Date dateStart, Date dateEnd);
}
