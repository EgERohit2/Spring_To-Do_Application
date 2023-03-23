package com.example.todo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo.entities.Task;
import com.example.todo.service.impl.TaskServiceImplementation;

@RestController
@RequestMapping("/task")
public class TaskController {

	@Autowired
	private TaskServiceImplementation taskServiceImplementation;

	@GetMapping("")
	public List<Task> getAllTasks() {
		return taskServiceImplementation.getAllTasks();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Task> getTaskById(@PathVariable("id") int id) {
		Optional<Task> task = taskServiceImplementation.getTaskById(id);
		if (task.isPresent()) {
			return ResponseEntity.ok(task.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/data")
	public ResponseEntity<Task> saveTask(@RequestBody Task task) {
		return ResponseEntity.ok(taskServiceImplementation.saveTask(task));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Task> updateTask(@PathVariable("id") int id, @RequestBody Task task) {
		Task updatedTask = taskServiceImplementation.updateTask(id, task);
		if (updatedTask != null) {
			return ResponseEntity.ok(updatedTask);
		} else {
			return ResponseEntity.notFound().build();
		}

	}
}
