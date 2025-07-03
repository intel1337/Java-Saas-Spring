package com.todolist.todolist.controllers;



import org.springframework.web.bind.annotation.GetMapping;
import com.todolist.todolist.model.*;
import com.todolist.todolist.repository.*;;

public class TaskController {
    @GetMapping("/hello")
	public String home() {




		return "home";
	}
    
}
