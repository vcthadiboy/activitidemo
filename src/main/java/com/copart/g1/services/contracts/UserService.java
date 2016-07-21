package com.copart.g1.services.contracts;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	PersonRepository personRepo ;
	
	//Autowiring the 'Activiti' RuntimeService
	@Autowired
	RuntimeService  runTimeService ;
	
	//Autowire the activiti taskService
	@Autowired
	TaskService taskService ;
	
	/**
	 * Service method to create a couple of dummy users
	 * @author CThadiboy
	 * @return void
	 *
	 */
	 public void createDemoUsers() {
	        if (personRepo.findAll().size() == 0) {
	        	personRepo.save(new Person("Hillary", "Rodham", "clinton", new Date()));
	        	personRepo.save(new Person("Trump", "J", "Donald", new Date()));
	        }
	    }


	public void startProcess(String username) {
		
		  	Person person = personRepo.findByUsername(username);
		  	
		  	//Create the input variables required by the workflow
	        Map<String, Object> variables = new HashMap<String, Object>();
	        variables.put("person", person);
	        
	        //Initiate the activiti process for this workflow
	        runTimeService.startProcessInstanceByKey("oneTaskProcess", variables);
		
	}


	public List<Task> getTasks(String username) {
		return taskService.createTaskQuery().taskAssignee(username).list();
	}


	
}
