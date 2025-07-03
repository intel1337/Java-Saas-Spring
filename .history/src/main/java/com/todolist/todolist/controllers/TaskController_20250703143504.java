package com.todolist.todolist.controllers;



import org.springframework.web.bind.annotation.GetMapping;
import com.todolist.todolist.model.*;
import com.todolist.todolist.repository.*;
import com.todolist.todolist.service.*;

public class TaskController {
    @GetMapping("/add")
	public String home() {




		return "home";
	}
    
}
