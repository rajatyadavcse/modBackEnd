package com.project.mod.service;

import java.util.List;

import com.project.mod.model.User;

public interface UserService {
	
	User create(User user);
	
	User delete(int id);
	
	List<User> findAll();
	
	User findById(int id);
	
	User update(User user);
	User findUser(String userName, String password, String role);

}
