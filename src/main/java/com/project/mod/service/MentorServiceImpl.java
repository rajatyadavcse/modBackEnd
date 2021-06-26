package com.project.mod.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.mod.model.Mentor;
import com.project.mod.repository.MentorRepository;

@Service
public class MentorServiceImpl implements MentorService {
	
	@Autowired
	private MentorRepository repository;

	@Override
	public Mentor create(Mentor mentor) {
		return repository.save(mentor);
	}

	@Override
	public Mentor delete(int id) {
		Mentor mentor = findById(id);
		if(mentor!=null) {
			repository.delete(mentor);
		}
		return mentor;
	}

	@Override
	public List<Mentor> findAll() {
		return repository.findAll();
	}

	@Override
	public Mentor findById(int id) {
		return repository.findOne(id);
	}

	@Override
	public Mentor update(Mentor mentor) {
		return repository.save(mentor);
	}

	@Override
	public Mentor findMentor(String userName, String password) {
		return repository.findMentor(userName, password);
	}
}
