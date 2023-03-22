package com.example.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo.entities.UserTask;
import com.example.todo.service.impl.UserTaskServicImplementation;

@RestController
@RequestMapping("/usertask")
public class UserTaskController {

	@Autowired
	private UserTaskServicImplementation userTaskServicImplementation;
	
	@PostMapping("/data")
	public String postData(@RequestBody UserTask usertask) {
		this.userTaskServicImplementation.postAllData(usertask);
		return "posted";
	}
}
