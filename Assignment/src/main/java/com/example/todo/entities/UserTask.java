package com.example.todo.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class UserTask {

	private static final TaskStatus TODO = null;
	public UserTask() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public UserTask(int id, User user, Task task, TaskStatus status, List<UserTaskHistory> userTaskHistory) {
		super();
		this.id = id;
		this.user = user;
		this.task = task;
		this.status = status;
		this.userTaskHistory = userTaskHistory;
	}



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	@ManyToOne
	private Task task;
	@Enumerated(EnumType.STRING)
	private TaskStatus status=TODO;
	@OneToMany(mappedBy = "usertask",cascade = CascadeType.ALL)
	private List<UserTaskHistory> userTaskHistory;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public TaskStatus getStatus() {
		return status;
	}

	public void setStatus(TaskStatus status) {
		this.status = status;
	}

	public List<UserTaskHistory> getUserTaskHistory() {
		return userTaskHistory;
	}

	public void setUserTaskHistory(List<UserTaskHistory> userTaskHistory) {
		this.userTaskHistory = userTaskHistory;
	}

	@Override
	public String toString() {
		return "UserTask [id=" + id + ", user=" + user + ", task=" + task + ", status=" + status + ", userTaskHistory="
				+ userTaskHistory + "]";
	}

	

}
