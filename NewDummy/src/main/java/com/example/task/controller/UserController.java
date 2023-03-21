package com.example.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.task.entities.User;
import com.example.task.service.impl.UserServiceImplementation;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserServiceImplementation userServiceImplementation;
	
	@PostMapping("/data")
	public String postData(@RequestBody User user) {
		userServiceImplementation.postAllData(user);
		return "posted";
	}
	
}
