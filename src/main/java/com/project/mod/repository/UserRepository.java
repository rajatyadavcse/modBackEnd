package com.project.mod.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.project.mod.model.User;

public interface UserRepository extends Repository<User, Integer> {
	
	User delete(User user);
	
	List<User> findAll();
	
	User findOne(int id);
	
	User save(User user);
	
	@Query("select user from User user where user.userName=? and user.password=? and user.role=?")
	User findUser(String userName, String password, String role);
	
}
