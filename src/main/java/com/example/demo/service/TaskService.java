package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.TasksEntity;
import com.example.demo.entity.UserAuthViewEntity;
import com.example.demo.repository.TasksRepository;
import com.example.demo.repository.UserAuthViewRepository;

@Service
public class TaskService {
	@Autowired
	private TasksRepository tasksRepository;
	@Autowired
	private UserAuthViewRepository userAuthViewRepository;
	
	public TasksEntity fetchTaskById(int taskId, String userName) {
		UserAuthViewEntity user = userAuthViewRepository.findByUserName(userName);
		int userId = user.getUserId();
		TasksEntity task = tasksRepository.findById(taskId).orElse(null);
		if(task.getUserId() != userId) 
			throw new IllegalArgumentException("User ID does not match the authenticated user"); 
		return task;
	}
	
	public List<TasksEntity> fetchTasks(String userName) {
		UserAuthViewEntity user = userAuthViewRepository.findByUserName(userName);
		System.out.println("TaskService: fetchTasks called for userId: " + user.getUserId());
		return  tasksRepository.findByUserId(user.getUserId());
	}
	
	public TasksEntity addTask(TasksEntity task, String userName) {
		UserAuthViewEntity user = userAuthViewRepository.findByUserName(userName);
		int userId = user.getUserId();
		if(task.getUserId() != userId)
			throw new IllegalArgumentException("User ID does not match the authenticated user");			
		task.setCreatedAt(LocalDateTime.now());
		return tasksRepository.save(task);
	}
	
	public TasksEntity updateTask(TasksEntity updatedTask, int taskId) {
		TasksEntity task = tasksRepository.findById(taskId).orElse(null);
		int taskuserId = task.getUserId();
		if(taskuserId != updatedTask.getUserId()) {
			throw new IllegalArgumentException("User ID does not match the authenticated user");
		}
		if(task!=null) {
			task.setTitle(updatedTask.getTitle());
			task.setUserId(updatedTask.getUserId());
			task.setDescription(updatedTask.getDescription());
			task.setstatus(updatedTask.getStatus());
			task.setDueDate(updatedTask.getDueDate());
			tasksRepository.save(task);
		}
		return task;
	}
	
	public int deleteTask(int taskId, String userName) {
		TasksEntity task = tasksRepository.findById(taskId).orElse(null);
		UserAuthViewEntity user = userAuthViewRepository.findByUserName(userName);
		int taskuserId = task.getUserId();
		if(taskuserId != user.getUserId()) {
			throw new IllegalArgumentException("User ID does not match the authenticated user");
		}
		if(task!=null) {
			tasksRepository.deleteById(taskId);
			return 0;
		}
		return -1;
	}
	

	

}
