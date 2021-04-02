package com.edinoc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.edinoc.entity.Task;
import com.edinoc.service.TaskServiceImpl;

@CrossOrigin(origins ="http://localhost:8080")
@RestController
@RequestMapping("/api")
public class TaskRestController {
	@Autowired
	private TaskServiceImpl service;

	@GetMapping("/tasks")
	public List<Task> getTasks() {
		return service.findAll();
	}

	@GetMapping("/tasks/{id}")
	public Task getTask(@PathVariable Long id) {
		return service.findById(id);
	}

	@PostMapping("/tasks")
	@ResponseStatus(HttpStatus.CREATED)
	public Task create(@RequestBody Task task) {
		service.save(task);
		return task;
	}

	@PutMapping("/tasks/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Task update(@RequestBody Task task, @PathVariable Long id) {
		Task currentTask = service.findById(id);
		currentTask.setName(task.getName());
		currentTask.setStatus(task.getStatus());
		service.save(currentTask);
		return currentTask;
	}

	@DeleteMapping("/tasks/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
}
