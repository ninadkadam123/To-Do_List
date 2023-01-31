package com.app.taskmanagement.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.taskmanagement.model.CountType;
import com.app.taskmanagement.model.Task;


public interface TaskRepository extends JpaRepository<Task, Long> {

	
	@Query(value = "SELECT * FROM task ORDER BY due_date DESC",nativeQuery = true)
	List<Task> getallTaskByDueDateDesc();
	
	@Query(value="Select new com.app.taskmanagement.model.CountType(count(*)/(select count(*) from Task)*100 , type) from Task group by type")
	public List<CountType> getPercentageGroupByType(); 
	
	@Query(value = "SELECT * FROM task Where id=:id",nativeQuery = true)
	Task getTaskByID(Long id);
	
}
