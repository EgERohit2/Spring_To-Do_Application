package com.example.todo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.todo.entities.Task;
import com.example.todo.entities.UserTask;
import com.example.todo.entities.UserTaskHistory;

@Repository
public interface UserTaskRepository extends JpaRepository<UserTask, Integer> {

	UserTask findByUserIdAndTaskId(Integer userId, Integer taskId);

	List<UserTask> findByTask(Task task);

}
