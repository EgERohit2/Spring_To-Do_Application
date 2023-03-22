package com.example.todo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todo.entities.Task;
import com.example.todo.repository.TaskRepository;
import com.example.todo.service.TaskService;

@Service
public class TaskServiceImplementation implements TaskService{

	@Autowired
	private TaskRepository taskRepository;
	
	@Override
	public Task postAllData(Task task) {
		
		Task t = new Task();
		t.setName(task.getName());
		t.setDesc(task.getDesc());
		t.setStartDate(task.getStartDate());
		t.setEndDate(task.getEndDate());
		return taskRepository.save(t);
	}

	

}
