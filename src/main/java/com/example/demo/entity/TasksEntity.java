package com.example.demo.entity;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "todolisttasks")
public class TasksEntity {
	public enum TaskStatus {
	    NOT_STARTED,
	    IN_PROGRESS,
	    COMPLETED,
	    ARCHIEVED
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int taskId;
	
	@Column(name = "userid")
	private int userId;
	
	@NotBlank(message = "Title must not be blank")
	private String title;
	private String description;
	
	@Enumerated(EnumType.STRING)
	private TaskStatus status;
	
	@Column(name = "duedate")
	private LocalDateTime  dueDate;
	@Column(name = "createdat")
	private LocalDateTime  createdAt;
	
	public TasksEntity() {
		
	}
	
	public TasksEntity(int taskId, int userId, String title, String description, TaskStatus status, LocalDateTime  dueDate, LocalDateTime  createdAt) {
		this.taskId = taskId;
		this.userId = userId;
		this.title = title;
		this.description = description;
		this.status = (TaskStatus) status;
		this.dueDate = dueDate;
		this.createdAt = createdAt;
	}
	
	public TasksEntity(int userId, String title, String description, TaskStatus status, LocalDateTime  dueDate, LocalDateTime  createdAt) {
		this.userId = userId;
		this.title = title;
		this.description = description;
		this.status = (TaskStatus) status;
		this.dueDate = dueDate;
		this.createdAt = createdAt;
	}
	
	public TasksEntity(int userId, String title, String description, TaskStatus status, LocalDateTime  dueDate) {
		this.userId = userId;
		this.title = title;
		this.description = description;
		this.status = (TaskStatus) status;
		this.dueDate = dueDate;
	}
	
	public int getTaskId() {
		return taskId;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public TaskStatus getStatus() {
		return (TaskStatus) status;
	}
	
	public void setstatus(TaskStatus status) {
		this.status = (TaskStatus) status;
	}
	
	public LocalDateTime  getDueDate() {
		return dueDate;
	}
	
	public void setDueDate(LocalDateTime  dueDate) {
		this.dueDate = dueDate;
	}
	
	public LocalDateTime  getCreatedAt() {
		return createdAt;
	}
	
	public void setCreatedAt(LocalDateTime  createdAt) {
		this.createdAt = createdAt;
	}
	

}
