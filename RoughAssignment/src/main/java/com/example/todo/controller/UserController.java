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

import com.example.todo.entities.User;
import com.example.todo.service.impl.UserServiceImplementation;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserServiceImplementation userServiceImplementation;
	
	@GetMapping("/data")
	  public List<User> getAllUsers() {
	    return userServiceImplementation.getAllUsers();
	  }

	  @GetMapping("/{id}")
	  public ResponseEntity<User> getUserById(@PathVariable("id") int id) {
	    Optional<User> user = userServiceImplementation.getUserById(id);
	    if (user.isPresent()) {
	        return ResponseEntity.ok(user.get());
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	  }

	  @PostMapping("/data")
	  public ResponseEntity<User> saveUser(@RequestBody User user) {
	    return ResponseEntity.ok(userServiceImplementation.saveUser(user));
	  }

	  @PutMapping("/{id}")
	  public ResponseEntity<User> updateUser(@PathVariable("id") int id, @RequestBody User user) {
	    User updatedUser = userServiceImplementation.updateUser(id, user);
	    if (updatedUser != null) {
	        return ResponseEntity.ok(updatedUser);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	  }
}
