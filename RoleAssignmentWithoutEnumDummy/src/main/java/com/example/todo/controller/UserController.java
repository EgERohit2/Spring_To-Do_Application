package com.example.todo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo.component.JwtUtil;
import com.example.todo.entities.Role;
import com.example.todo.entities.Task;
import com.example.todo.entities.User;
import com.example.todo.entities.UserDto;
import com.example.todo.repository.UserRepository;
import com.example.todo.service.impl.TaskServiceImplementation;
import com.example.todo.service.impl.UserServiceImplementation;
import com.example.todo.service.impl.UserTaskHistoryServiceImplementation;
import com.example.todo.service.impl.UserTaskServiceImplementation;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private UserTaskHistoryServiceImplementation userTaskHistoryServiceImplementation;

	@Autowired
	private UserServiceImplementation userServiceImplementation;

	@Autowired
	private TaskServiceImplementation taskServiceImplementation;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("/data")
	public List<User> getAllUsers() {
		return userServiceImplementation.getAllUsers();
	}

	// @PreAuthorize("hasRole('ROLE_admin')")
//	@GetMapping("/{id}")
//	public ResponseEntity<User> getUserById(@PathVariable("id") int id) {
//		Optional<User> user = userServiceImplementation.getUserById(id);
//		if (user.isPresent()) {
//			return ResponseEntity.ok(user.get());
//		} else {
//			return ResponseEntity.notFound().build();
//		}
//	}

	@PostMapping("/data")
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		return ResponseEntity.ok(userServiceImplementation.saveUser(user));
	}

//	@PutMapping("/{id}")
//	public ResponseEntity<User> updateUser(@PathVariable("id") int id, @RequestBody User user) {
//		User updatedUser = userServiceImplementation.updateUser(id, user);
//
//		return ResponseEntity.ok(updatedUser);
//
//	}

	@PutMapping("/{id}")
	public User updateUser(@PathVariable("id") int id, @RequestBody User user) {
		return userServiceImplementation.updateUser(id, user);

	}

	@GetMapping("/userDto")
	public List<UserDto> getAllUserDto() {
		return userServiceImplementation.getAllUserDto();
	}

	@PreAuthorize("hasRole('ROLE_admin')")
	@PostMapping("/post")
	public String post(@RequestParam(value = "user_id") int user_id, @RequestParam(value = "role_id") int role_id) {
		this.userServiceImplementation.addRoles(user_id, role_id);
		return "Role assigned";
	}

//	@PreAuthorize("hasRole('ROLE_admin')")
//	@GetMapping("/{id}")
//	public ResponseEntity<?> getUserById(@PathVariable("id") int id, @RequestHeader("Authorization") String token) {
//	    // extract username from token
//	    String username = jwtUtil.parseToken(token.replace("Bearer ", ""));
//	    
//	    // fetch user details from database
//	    Optional<User> optionalUser = userServiceImplementation.getUserById(id);
//	    if (optionalUser.isPresent()) {
//	        User user = optionalUser.get();
//	        
//	        // check if user associated with the given id matches the username in the token
//	        if (user.getUsername().equals(username)) {
//	            // return user details
//	            return ResponseEntity.ok(user);
//	        } else {		
//	            // return 403 Forbidden status if user does not have permission to access the resource
//	            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
//	        }
//	    } else {
//	        // return 404 Not Found status if user with the given id does not exist
//	        return ResponseEntity.notFound().build();
//	    }
//	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getTasksByUserId(@PathVariable("id") int id,
			@RequestHeader("Authorization") String token) {
		String username = jwtUtil.getUsernameFromToken(token);
		System.out.println("@@" + username);
		User currentUser = userRepository.findByUsername(username);
		System.out.println("YYYYYYYYYYYYYYYYYYYYYYYYYYYYY");
		System.out.println(currentUser);

		if (currentUser.getRole() != Role.admin && currentUser.getId() != id) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}

		Optional<Task> tasks = taskServiceImplementation.getTaskById(id);
		return ResponseEntity.ok(tasks);
	}
}
