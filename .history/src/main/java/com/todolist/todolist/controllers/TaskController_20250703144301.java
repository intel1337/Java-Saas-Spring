package com.todolist.todolist.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.todolist.todolist.model.*;

import com.todolist.todolist.service.*;

@RestController
@RequestMapping("/tasks") // Route
public class TaskController {
    public interface TaskRequest {
        String getTitle();
        String getDescription();
    }
    @Autowired 
    private TaskService _taskService; // Instance privée de la classe 
    @PostMapping("/add")
	public Task addTask(@RequestBody TaskRequest _taskRequest) {
		return _taskService.addTask(_taskRequest.);
	}
    
}
