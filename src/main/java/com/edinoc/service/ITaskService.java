package com.edinoc.service;

import java.util.List;

import com.edinoc.entity.Task;

public interface ITaskService {
	public List<Task> findAll();
	public Task findById(Long id);
	public void save(Task task);
	public void update(Task task);
	public void delete(Long id);
}