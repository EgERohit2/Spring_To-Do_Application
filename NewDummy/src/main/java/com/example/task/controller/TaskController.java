package com.example.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.task.entities.Task;
import com.example.task.service.impl.TaskServiceImplementation;

@RestController
@RequestMapping("/task")
public class TaskController{
	
	@Autowired
	private TaskServiceImplementation taskServiceImplementation;

	@PostMapping("/data")
	public String postData(@RequestBody Task task) {
		taskServiceImplementation.postAllData(task);
		return "posted";
	}
}
