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

import com.example.todo.entities.UserTask;
import com.example.todo.entities.UserTaskHistory;
import com.example.todo.service.impl.UserTaskServiceImplementation;

@RestController
@RequestMapping("/usertask")
public class UserTaskController {

	@Autowired
	private UserTaskServiceImplementation userTaskServiceImplementation;

	@GetMapping("data")
	public List<UserTask> getAllUserTasks() {
		return userTaskServiceImplementation.getAllUserTasks();
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserTask> getUserTaskById(@PathVariable("id") int id) {
		Optional<UserTask> userTask = userTaskServiceImplementation.getUserTaskById(id);
		if (userTask.isPresent()) {
			return ResponseEntity.ok(userTask.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/data")
	public ResponseEntity<UserTask> saveUserTask(@RequestBody UserTask userTask) {
		return ResponseEntity.ok(userTaskServiceImplementation.saveUserTask(userTask));
	}

	@PutMapping("/{id}")
	public ResponseEntity<UserTask> updateUserTask(@PathVariable("id") int id, @RequestBody UserTask userTask) {
		UserTask updatedUserTask = userTaskServiceImplementation.updateUserTask(id, userTask);
		if (updatedUserTask != null) {
			return ResponseEntity.ok(updatedUserTask);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	
}
