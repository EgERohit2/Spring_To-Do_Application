package com.example.todo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todo.entities.User;
import com.example.todo.repository.UserRepository;
import com.example.todo.service.UserService;

@Service
public class UserServiceImplementation implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public Optional<User> getUserById(int id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}

	@Override
	public User updateUser(int id, User user) {
		// TODO Auto-generated method stub
		Optional<User> optionalUser = userRepository.findById(id);
		if (optionalUser.isPresent()) {
			User existingUser = optionalUser.get();
			existingUser.setName(user.getName());
			existingUser.setEmail(user.getEmail());
			existingUser.setPsk(user.getPsk());
			existingUser.setMob(user.getMob());
			existingUser.setUsertask(user.getUsertask());
			return userRepository.save(existingUser);
		} else {
			return null;
		}

	}

}
