package com.example.todo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.todo.entities.Task;
import com.example.todo.entities.TaskStatus;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

	void save(List<Task> tasks);

	List<Task> findByEndDateBeforeAndStatusNot(Date date, TaskStatus overdue);

}
