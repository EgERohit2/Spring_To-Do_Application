package com.example.todo.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo.component.JwtUtil;
import com.example.todo.entities.Task;
import com.example.todo.entities.TaskDto;
import com.example.todo.entities.TaskStatus;
import com.example.todo.entities.User;
import com.example.todo.repository.UserRepository;
import com.example.todo.service.impl.TaskServiceImplementation;

@RestController
@RequestMapping("/task")
public class TaskController {

	@Autowired
	private TaskServiceImplementation taskServiceImplementation;

	@Autowired
	private UserRepository userRepository;

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

	@PutMapping("/{id}/update-status")
	public ResponseEntity<?> updateTaskStatus(@PathVariable("id") int id) {
		Optional<Task> optionalTask = taskServiceImplementation.getTaskById(id);
		if (optionalTask.isPresent()) {
			Task task = optionalTask.get();
			Date currentDate = new Date();
			if (currentDate.after(task.getEndDate())) {
				task.setStatus(TaskStatus.OVERDUE);
			} else {
				task.setStatus(TaskStatus.INPROGRESS);
			}
			taskServiceImplementation.saveTask(task);
			return ResponseEntity.ok("Task status updated successfully");
		} else {
			return ResponseEntity.notFound().build();
		}
	}
//
//	@GetMapping("/tasks/user/{id}")
//	public List<TaskDto> getTasksByUserId(@PathVariable("id") int id, @RequestHeader("Authorization") String token) {
//		String username = JwtUtil.getUsernameFromToken(token.replace("Bearer ", ""));
//		User user = userRepository.findByUsername(username);
//		if (user == null || user.getId() != id) {
//			throw new Exception("Unauthorized access");
//		}
//		Optional<Task> tasks = taskServiceImplementation.getTaskById(id);
//		return tasks.stream().map(task -> TaskDto.fromTask(task)).collect(Collectors.toList());
//	}
}
