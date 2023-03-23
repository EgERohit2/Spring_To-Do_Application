package com.example.todo.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Task {

	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Task(int id, String name, String desc, Date startDate, Date endDate, List<UserTask> usertask) {
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.startDate = startDate;
		this.endDate = endDate;
		this.usertask = usertask;
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
	@OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
	private List<UserTask> usertask;

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

	public List<UserTask> getUsertask() {
		return usertask;
	}

	public void setUsertask(List<UserTask> usertask) {
		this.usertask = usertask;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", name=" + name + ", desc=" + desc + ", startDate=" + startDate + ", endDate="
				+ endDate + ", usertask=" + usertask + "]";
	}

}
