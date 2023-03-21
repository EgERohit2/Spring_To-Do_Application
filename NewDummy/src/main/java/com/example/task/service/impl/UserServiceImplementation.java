package com.example.task.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.task.entities.User;
import com.example.task.repository.UserRepository;
import com.example.task.service.UserService;
@Service
public class UserServiceImplementation implements UserService{

	@Autowired
	private UserRepository userRepository;

	@Override
	public User postAllData(User user) 
	{
		User u = new User();
		u.setEmail(user.getEmail());
		u.setPassword(user.getPassword());
		u.setMob(user.getMob());
		u.setRoles(user.getRoles());
		u.setTask(new ArrayList<>(user.getTask()));
		return userRepository.save(u);
	}
	
	
}
