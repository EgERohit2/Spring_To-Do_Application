package com.example.todo.service;

import java.util.List;
import java.util.Optional;

import com.example.todo.entities.Task;
import com.example.todo.entities.TaskDto;
import com.example.todo.entities.UserDto;

public interface TaskService {

	public Task saveTask(Task task);

	public List<Task> getAllTasks();

	public Optional<Task> getTaskById(int id);

	public Task updateTask(int id, Task task);
	
	public TaskDto converEntitytoDto(Task task);

//	 public void checkOverdueTasks();

//	public void checkOverdueTasksAndUpdateStatus();

}
