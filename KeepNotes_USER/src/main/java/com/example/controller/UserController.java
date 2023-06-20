package com.example.controller;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;
import com.example.service.TokenGeneratorService;
import com.example.service.UserService;

@RestController
@RequestMapping("/user/")
public class UserController {

	@Autowired
	private UserService service;
	
	@Autowired
	private TokenGeneratorService tokenGenerator;
	
	
	@PostMapping("register")
	public User addUser(@RequestBody User user) {
		return service.createAnUser(user);
		
	}

	@PostMapping("login")
	public Map<String,String> authenticateUser(@RequestBody User user){
		final User user1 = this.service.authenticateUser(user.getUserName(), user.getUserPassword());
		return this.tokenGenerator.generateToken(user1);
	}

	@PutMapping("update/{userId}")
	public User updateUser(@PathVariable("userId") int userId, @RequestBody User user) {
		return service.updateUser(userId, user);
	}
	
	@GetMapping("find/{userId}")
	public User getUser(@PathVariable int userId) {
		return service.retrieveAnUser(userId);
	}
	
	
	@DeleteMapping("delete/{userId}")
	public void deleteUser(@PathVariable int userId) {
		service.deleteUser(userId);
	}
}
