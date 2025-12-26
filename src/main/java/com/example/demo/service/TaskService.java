package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.TasksEntity;
import com.example.demo.repository.TasksRepository;

@Service
public class TaskService {
	@Autowired
	private TasksRepository tasksRepository;
	
	public TasksEntity fetchTaskById(int taskId) {
		return tasksRepository.findById(taskId).orElse(null);
	}
	
	public List<TasksEntity> fetchTasks() {
		return tasksRepository.findAll();
	}
	
	public TasksEntity addTask(TasksEntity task) {
		task.setCreatedAt(LocalDateTime.now());
		return tasksRepository.save(task);
	}
	
	public TasksEntity updateTask(TasksEntity updatedTask, int taskId) {
		TasksEntity task = tasksRepository.findById(taskId).orElse(null);
		if(task!=null) {
			task.setTitle(updatedTask.getTitle());
			task.setUserId(updatedTask.getUserId());
			task.setDescription(updatedTask.getDescription());
			task.setstatus(updatedTask.getStatus());
			task.setDueDate(updatedTask.getDueDate());
//			task.setCreatedAt(updatedTask.getCreatedAt());
			tasksRepository.save(task);
		}
		return task;
	}
	
	public int deleteTask(int taskId) {
		TasksEntity task = tasksRepository.findById(taskId).orElse(null);
		if(task!=null) {
			tasksRepository.deleteById(taskId);
			return 0;
		}
		return -1;
	}

}
