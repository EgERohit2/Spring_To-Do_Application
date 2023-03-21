package com.example.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.task.entities.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
