package com.edinoc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edinoc.entity.Task;
import com.edinoc.repository.TaskRepository;

@Service
public class TaskServiceImpl implements ITaskService {
	@Autowired
	private TaskRepository repository;

	@Override
	public List<Task> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public void save(Task task) {
		// TODO Auto-generated method stub
		repository.save(task);
	}

	@Override
	public void update(Task task) {
		// TODO Auto-generated method stub
		repository.save(task);
	}

	@Override
	public Task findById(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}
}