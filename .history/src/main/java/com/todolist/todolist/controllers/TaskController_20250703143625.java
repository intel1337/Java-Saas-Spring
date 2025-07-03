package com.todolist.todolist.controllers;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.todolist.todolist.model.*;
import com.todolist.todolist.repository.*;
import com.todolist.todolist.service.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @PostMapping("/add")
	public String addTask() {





		return "home";
	}
    
}
