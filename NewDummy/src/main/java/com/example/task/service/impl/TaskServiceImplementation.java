package com.example.task.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.task.entities.Task;
import com.example.task.repository.TaskRepository;
import com.example.task.service.TaskService;

@Service
public class TaskServiceImplementation implements TaskService{

	@Autowired
	private TaskRepository taskRepository;
	
	@Override
	public Task postAllData(Task task) {
		return taskRepository.save(task);
	}

}
