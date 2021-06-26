package com.project.mod.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.mod.model.User;
import com.project.mod.service.UserService;

@RestController
@CrossOrigin
@RequestMapping({"/users"})
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public User create(@RequestBody User user) {
		return userService.create(user);
	}
	
	@GetMapping(path = {"/{id}"})
	public User findOne(@PathVariable("id") int id) {
		return userService.findById(id);
	}
	
	@PutMapping(path = {"/{id}"})
    public User update(@PathVariable("id") int id, @RequestBody User user){
        user.setId(id);
        return userService.update(user);
    }

    @DeleteMapping(path ={"/{id}"})
    public User delete(@PathVariable("id") int id) {
        return userService.delete(id);
    }

    @GetMapping
    public List<User> findAll(){
        return userService.findAll();
    }
    @GetMapping(path = {"/{userName}/{password}/{role}"})
    public User findUser(@PathVariable("userName") String userName, @PathVariable("password") String password, @PathVariable("role") String role) {
    	return userService.findUser(userName, password, role);
      }
}

