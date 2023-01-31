package com.app.taskmanagement;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.app.taskmanagement.model.CountType;
import com.app.taskmanagement.model.Task;
import com.app.taskmanagement.services.TaskService;





@RestController
@RequestMapping("/api/v1")
public class TaskController {
	
	private TaskService taskService;
	
	@Autowired
	public TaskController(TaskService taskService) {
		this.taskService=taskService;
	}
	
	@GetMapping("/task")
	public ResponseEntity<List<Task>> getTask(){
		try {
			
			List<Task> list=this.taskService.getAllTasks();
			return new ResponseEntity<>(list,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}		
		
	}
	
	@GetMapping("/gettask/{id}")
	public ResponseEntity<Task> getById(@PathVariable Long id){
		try {
			System.out.print(this.taskService.taskExits(id));
			System.out.println("in Get By Id"+id);
			Task Task=this.taskService.getTaskById(id);
			System.out.println(Task);
			return new ResponseEntity<Task>(Task,HttpStatus.FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);	
		}
		
	}
	
	@GetMapping("/task/vData/percentagecounttype")
	public ResponseEntity<List<CountType>> getTaskByPercentageType(){
		try {
			
			List<CountType> list=this.taskService.getPercentageGroupByType();
			
			return new ResponseEntity<>(list,HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);	

		}
	}
	
	@PostMapping("/task")
	public ResponseEntity<Task> addTask(@RequestBody Task task){
		try {
			Task newTask=this.taskService.addTask(task);
			return new ResponseEntity<>(newTask,HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/updatetask")
	public ResponseEntity<Task> updateTask(@RequestBody Task task){
		try {
			
			
			Task updatedTask=this.taskService.updateTask(task);
			return new ResponseEntity<>(updatedTask,HttpStatus.FOUND);
            
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		
	}
	
	
	@DeleteMapping("/task/{id}")
	public ResponseEntity<Void> deleteTask(@PathVariable Long id){
		
		try {
			this.taskService.deleteTask(id);
			return new ResponseEntity<>(HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}

}
