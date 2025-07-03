package com.todolist.todolist.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.todolist.todolist.model.*;

import com.todolist.todolist.service.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired 
    private TaskService _taskservice;
    @PostMapping("/add")
	public String addTask(@RequestParam String title) {
        _taskservice.addTask(null, null);
		return "home";
	}
    
}
