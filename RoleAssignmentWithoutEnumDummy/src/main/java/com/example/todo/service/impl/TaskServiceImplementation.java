package com.example.todo.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todo.entities.Task;
import com.example.todo.entities.TaskDto;
import com.example.todo.entities.UserDto;
import com.example.todo.repository.TaskRepository;
import com.example.todo.repository.UserTaskHistoryRepository;
import com.example.todo.repository.UserTaskRepository;
import com.example.todo.service.TaskService;

@Service
public class TaskServiceImplementation implements TaskService {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserTaskHistoryServiceImplementation userTaskHistoryServiceImplementation;

	@Autowired
	private UserTaskServiceImplementation userTaskServiceImplementation;

	@Autowired
	private UserTaskRepository userTaskRepository;

	@Autowired
	private UserTaskHistoryRepository userTaskHistoryRepository;

	@Autowired
	private TaskRepository taskRepository;

	@Override
	public Task saveTask(Task task) {
		// TODO Auto-generated method stub
		return taskRepository.save(task);
	}

	@Override
	public List<Task> getAllTasks() {
		// TODO Auto-generated method stub
		return taskRepository.findAll();
	}

	@Override
	public Optional<Task> getTaskById(int id) {
		// TODO Auto-generated method stub
		return taskRepository.findById(id);
	}

	@Override
	public Task updateTask(int id, Task task) {
		// TODO Auto-generated method stub
		Optional<Task> optionalTask = taskRepository.findById(id);
		if (optionalTask.isPresent()) {
			Task existingTask = optionalTask.get();
			existingTask.setName(task.getName());
			existingTask.setDesc(task.getDesc());
			existingTask.setStartDate(task.getStartDate());
			existingTask.setEndDate(task.getEndDate());
			existingTask.setUsertask(task.getUsertask());
			return taskRepository.save(existingTask);
		} else {
			return null;
		}
	}
//
//	@Override
//	@Scheduled(cron = "0 0 * * * *")
//	public void checkOverdueTasks() {
//		// TODO Auto-generated method stub
//		List<Task> tasks = taskRepository.findAll();
//		for (Task t1 : tasks) {
//			if (t1.getEndDate().before(new Date())) {
//				t1.setStatus(TaskStatus.OVERDUE);
//				taskRepository.save(tasks);
//			}
//		}
//
//	}

	@Override
	public TaskDto converEntitytoDto(Task task) {	
			modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
			TaskDto taskDto = new TaskDto();
			taskDto = modelMapper.map(task, TaskDto.class);

			return taskDto;
		}
		
	}

//	@Override
//	public void checkOverdueTasks() {
//		// TODO Auto-generated method stub
//		
//	}

//	@Override
//	public void checkOverdueTasksAndUpdateStatus() {
//		// TODO Auto-generated method stub
//		 List<Task> overdueTasks = taskRepository.findByEndDateBeforeAndStatusNot(new Date(), TaskStatus.OVERDUE);
//	        
//	        for (Task task : overdueTasks) {
//	            task.setStatus(TaskStatus.OVERDUE);
//	            taskRepository.save(task);
//	            userTaskServiceImplementation.updateUserTask(task.getId(), TaskStatus.OVERDUE);
//	            userTaskServiceImplementation.createTaskHistory(task.getId(), TaskStatus.OVERDUE);
//	        }
//	    }


