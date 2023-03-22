package com.example.todo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todo.entities.User;
import com.example.todo.repository.UserRepository;
import com.example.todo.service.UserService;
@Service
public class UserServiceImplementation implements UserService{

	@Autowired
	private UserRepository userRepository;

	@Override
	public User postAllData(User user) {
		User u = new User();
		u.setEmail(user.getEmail());
		u.setMob(user.getMob());
		u.setName(user.getName());
		u.setPsk(user.getPsk());
		return userRepository.save(u);
	}
	
	
}
