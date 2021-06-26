package com.project.mod.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.mod.model.Training;
import com.project.mod.repository.TrainingRepository;

@Service
public class TrainingServiceImpl implements TrainingService {

	@Autowired
	private TrainingRepository repository;
	
	@Override
	public Training create(Training training) {
		return repository.save(training);
	}

	@Override
	public Training delete(int id) {
		Training training = findById(id);
		if(training!=null) {
			repository.delete(training);
		}
		return training;
	}

	@Override
	public List<Training> findAll() {
		return repository.findAll();
	}

	@Override
	public Training findById(int id) {
		return repository.findOne(id);
	}

	@Override
	public Training update(Training training) {
		return repository.save(training);
	}

	@Override
	public List<Training> findTrainingByMentorId(Integer mentorId) {
		return repository.findTrainingByMentorId(mentorId);
	}

	@Override
	public List<Training> findTrainingByUserId(Integer userId) {
		return repository.findTrainingByUserId(userId);
	}

	@Override
	public Training findByIdAndMentorId(Integer id, Integer mentorId) {
		return repository.findByIdAndMentorId(id, mentorId);
	}

	@Override
	public Training findByIdAndUserId(Integer id, Integer userId) {
		return repository.findByIdAndUserId(id, userId);
	}

	@Override
	public List<Training> findByStartDateBetween(Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return repository.findByStartDateBetween(startDate, endDate);
	}
	
	
}
