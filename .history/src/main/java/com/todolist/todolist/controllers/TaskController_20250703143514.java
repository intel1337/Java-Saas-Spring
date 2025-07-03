package com.todolist.todolist.controllers;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.todolist.todolist.model.*;
import com.todolist.todolist.repository.*;
import com.todolist.todolist.service.*;

public class TaskController {
    @PostMappingMapping("/add-task")
	public String home() {




		return "home";
	}
    
}
