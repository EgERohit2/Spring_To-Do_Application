package com.example.task.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Task {

	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Task(int id, String name, String desc, Date startDate, Date endDate, User user,
			List<UserTaskHistory> userTaskHistory) {
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.startDate = startDate;
		this.endDate = endDate;
		this.user = user;
		this.userTaskHistory = userTaskHistory;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "task_name")
	private String name;
	@Column(name = "description")
	private String desc;
	private Boolean isActive = true;
	private Date startDate;
	private Date endDate;
	@ManyToOne()
	private User user;
	@OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
	private List<UserTaskHistory> userTaskHistory = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<UserTaskHistory> getUserTaskHistory() {
		return userTaskHistory;
	}

	public void setUserTaskHistory(List<UserTaskHistory> userTaskHistory) {
		this.userTaskHistory = userTaskHistory;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", name=" + name + ", desc=" + desc + ", startDate=" + startDate + ", endDate="
				+ endDate + ", user=" + user + ", userTaskHistory=" + userTaskHistory + "]";
	}

}
