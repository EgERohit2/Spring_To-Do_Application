package com.example.task.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Task {

	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Task(int id, String desc, Date startDate, Date endDate, TaskStatus status, List<User> user) {
		super();
		this.id = id;
		this.desc = desc;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
		this.user = user;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Boolean isActive = true;
	@CreatedDate
	private Date createdAt;
	@LastModifiedDate
	private Date updatedAt;
	@Column(name = "description")
	private String desc;
	@Column(name = "start_date")
	private Date startDate;
	@Column(name = "end_date")
	private Date endDate;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private TaskStatus status;
	@ManyToMany(mappedBy = "tasks")
	private List<User> user = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public TaskStatus getStatus() {
		return status;
	}

	public void setStatus(TaskStatus status) {
		this.status = status;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", desc=" + desc + ", startDate=" + startDate + ", endDate=" + endDate + ", status="
				+ status + ", user=" + user + "]";
	}

}
