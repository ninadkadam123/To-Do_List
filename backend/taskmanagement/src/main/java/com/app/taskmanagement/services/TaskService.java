package com.app.taskmanagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.taskmanagement.model.CountType;
import com.app.taskmanagement.model.Task;
import com.app.taskmanagement.repo.TaskRepository;


@Service
public class TaskService {

	private TaskRepository taskRepository;
	
	@Autowired
	public TaskService(TaskRepository taskRepository) {
		this.taskRepository=taskRepository;
	}
	
	
	public List<Task> getAllTasks(){
		return this.taskRepository.getallTaskByDueDateDesc();
	}
	
	public Task addTask(Task task) {
		return this.taskRepository.save(task);
	}
	
	public boolean taskExits(Long id) {
		return this.taskRepository.existsById(id);
	}
	
	public Task updateTask(Task task) {
		return this.taskRepository.save(task);
	}
	
	public Task getTaskById(Long id) {
		return this.taskRepository.getTaskByID(id);
	}
	
	public void deleteTask(Long id) {
		this.taskRepository.deleteById(id);
	}
	
	
	public List<CountType> getPercentageGroupByType(){
		return this.taskRepository.getPercentageGroupByType();
	}
}
