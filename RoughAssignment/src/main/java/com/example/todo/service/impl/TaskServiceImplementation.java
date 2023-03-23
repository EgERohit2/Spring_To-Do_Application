package com.example.todo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todo.entities.Task;
import com.example.todo.repository.TaskRepository;
import com.example.todo.service.TaskService;

@Service
public class TaskServiceImplementation implements TaskService {

	@Autowired
	private TaskRepository taskRepository;

	@Override
	public Task saveTask(Task task) {
		// TODO Auto-generated method stub
		return taskRepository.save(task);
	}

	@Override
	public List<Task> getAllTasks() {
		// TODO Auto-generated method stub
		return taskRepository.findAll();
	}

	@Override
	public Optional<Task> getTaskById(int id) {
		// TODO Auto-generated method stub
		return taskRepository.findById(id);
	}

	@Override
	public Task updateTask(int id, Task task) {
		// TODO Auto-generated method stub
		 Optional<Task> optionalTask = taskRepository.findById(id);
		    if (optionalTask.isPresent()) {
		        Task existingTask = optionalTask.get();
		        existingTask.setName(task.getName());
		        existingTask.setDesc(task.getDesc());
		        existingTask.setStartDate(task.getStartDate());
		        existingTask.setEndDate(task.getEndDate());
		        existingTask.setUsertask(task.getUsertask());
		        return taskRepository.save(existingTask);
		    } else {
		        return null;
		    }
		  }
	}


