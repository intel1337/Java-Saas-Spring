package com.todolist.todolist.controllers;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.todolist.todolist.model.*;

import com.todolist.todolist.service.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    @PostMapping("/add")
	public String addTask() {






		return "home";
	}
    
}
