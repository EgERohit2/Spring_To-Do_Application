package com.example.todo.service;

import java.util.List;
import java.util.Optional;

import com.example.todo.entities.Task;

public interface TaskService {

	 public Task saveTask(Task task);
	 
	 public List<Task> getAllTasks();
	 
	 public Optional<Task> getTaskById(int id);
	 
	 public Task updateTask(int id, Task task);
}
