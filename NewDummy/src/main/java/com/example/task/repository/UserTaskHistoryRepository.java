package com.example.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.task.entities.UserTaskHistory;
@Repository
public interface UserTaskHistoryRepository extends JpaRepository<UserTaskHistory, Integer>{

}
