package com.example.todo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todo.entities.UserTask;
import com.example.todo.repository.UserTaskRepository;
import com.example.todo.service.UserTaskService;

@Service
public class UserTaskServicImplementation implements UserTaskService {

	@Autowired
	private UserTaskRepository userTaskRepository;

	@Override
	public void postAllData(UserTask usertask) {

		UserTask ut = new UserTask();
		ut.setUser(usertask.getUser());
		ut.setTask(usertask.getTask());
		ut.setStatus(usertask.getStatus());
		ut.setUserTaskHistory(usertask.getUserTaskHistory());

		userTaskRepository.save(ut);

	}

}
