package com.example.task.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class User {

	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String role, List<Task> tasks, List<TaskHistory> taskshistory) {
		super();
		this.id = id;
		this.role = role;
		this.tasks = tasks;
		this.taskshistory = taskshistory;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="rolename")
	private String role;
	private Boolean isActive= true;
	@CreatedDate
	private Date createdAt;
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinTable(name="user_task", joinColumns = @JoinColumn(name="uid"), inverseJoinColumns = @JoinColumn(name="tid"))
	private List<Task> tasks = new ArrayList<>();
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinTable(name="user_taskhistory", joinColumns = @JoinColumn(name="uid"), inverseJoinColumns = @JoinColumn(name="thid"))
	private List<TaskHistory> taskshistory = new ArrayList<>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public List<Task> getTasks() {
		return tasks;
	}
	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	public List<TaskHistory> getTaskshistory() {
		return taskshistory;
	}
	public void setTaskshistory(List<TaskHistory> taskshistory) {
		this.taskshistory = taskshistory;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", role=" + role + ", tasks=" + tasks + ", taskshistory=" + taskshistory + "]";
	}
	
	
	
	
	

	
}
