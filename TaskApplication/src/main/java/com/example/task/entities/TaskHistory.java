package com.example.task.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class TaskHistory {

	public TaskHistory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TaskHistory(int id, List<User> user) {
		super();
		this.id = id;
		this.user = user;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@CreatedDate
	private Date createdAt;
	@LastModifiedDate
	private Date updatedAt;
	@ManyToMany(mappedBy = "taskshistory")
	private List<User> user = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

}
