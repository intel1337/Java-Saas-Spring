package com.todolist.todolist.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.todolist.todolist.model.*;

import com.todolist.todolist.service.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired 
    private TaskService _taskservice; // Instance privée de la classe
    @PostMapping("/add")
	public Task addTask(@RequestParam String title, String description) {
		return _taskservice.addTask(title, description);
	}
    
}
