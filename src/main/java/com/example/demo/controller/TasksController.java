package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.TasksEntity;
import com.example.demo.service.TaskService;

@RestController
@RequestMapping("/api/v1/tasks")
public class TasksController {
	@Autowired
	private TaskService taskService;
	
	@GetMapping("/{taskId}")
	public ResponseEntity<HashMap<String, Object>> retriveTaskById(@PathVariable int taskId) {
		HashMap<String, Object> response = new HashMap<>();
		TasksEntity task = taskService.fetchTaskById(taskId);
		
		if(task!=null) {
			response.put("task", task);
			return ResponseEntity.ok(response);
		}
		else {
			response.put("status", 404);
			response.put("message", "Task not found");
			return ResponseEntity.status(404).body(response);
		}
	}
	
	@GetMapping
	public ResponseEntity<List<TasksEntity>> retrieveAllTasks() {
		List<TasksEntity> tasks = taskService.fetchTasks();
		return ResponseEntity.ok(tasks);
	}
	
	@PostMapping
	public ResponseEntity<HashMap<String, Object>> createTask(@RequestBody TasksEntity task) {
		HashMap<String, Object> response = new HashMap<>();
		try {
			TasksEntity newTask = taskService.addTask(task);
			if(newTask!=null) {
				response.put("message", "Task is created successfully");
				response.put("task id", newTask.getTaskId());
				response.put("task title", newTask.getTitle());
				return ResponseEntity.ok(response);
			}
			else {
				response.put("status", 500);
				response.put("message", "Internal server error - Task could not be created");
			}
		}
		catch(Exception e) {
			response.put("status", 500);
			response.put("message", "Exception encountered - Task could not be created");
		}
		return ResponseEntity.status(500).body(response);
	}
	
	@PutMapping("/{taskId}")
	public ResponseEntity<HashMap<String, Object>> modifyTask(@RequestBody TasksEntity updatedTask, @PathVariable int taskId) {
		HashMap<String, Object> response = new HashMap<>();
		try {
			TasksEntity task = taskService.updateTask(updatedTask, taskId);
			if(task!=null) {
				response.put("message", "Task is updated successfully");
				response.put("task id", task.getTaskId());
				response.put("task title", task.getTitle());
				return ResponseEntity.ok(response);
			}
			else {
				response.put("status", 500);
				response.put("message", "Internal server error - Task could not be updated");
			}
		}
		catch(Exception e) {
			response.put("status", 500);
			response.put("message", "Exception encountered - Task could not be updated");
		}
		return ResponseEntity.status(500).body(response);
	}
	
	@DeleteMapping("/{taskId}")
	public ResponseEntity<HashMap<String, Object>> removeTask(@PathVariable int taskId) {
		HashMap<String, Object> response = new HashMap<>();
		try {
			int status = taskService.deleteTask(taskId);
			if(status==0) {
				response.put("message", "Task is deleted successfully");
				response.put("task id", taskId);
				return ResponseEntity.ok(response);
			}
			else {
				response.put("status", 500);
				response.put("message", "Internal server error - Task could not be deleted");
			}
		}
		catch(Exception e) {
			response.put("status", 500);
			response.put("message", "Exception encountered - Task could not be deleted");
		}
		return ResponseEntity.status(500).body(response);
	}

}
