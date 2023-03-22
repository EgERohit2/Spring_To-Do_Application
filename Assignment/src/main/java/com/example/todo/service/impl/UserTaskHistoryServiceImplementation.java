package com.example.todo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todo.entities.UserTaskHistory;
import com.example.todo.repository.UserTaskHistoryRepository;
import com.example.todo.service.UserTaskHistoryService;
@Service
public class UserTaskHistoryServiceImplementation implements UserTaskHistoryService{

	@Autowired
	private UserTaskHistoryRepository userTaskHistoryRepository;
		
	@Override
	public void postAllData(UserTaskHistoryService userTaskHistory) {
		
		
		
	}
}
