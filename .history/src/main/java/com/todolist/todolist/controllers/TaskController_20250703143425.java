package com.todolist.todolist.controllers;



import org.springframework.web.bind.annotation.GetMapping;
import com.todolist.todolist.model.*;

public class TaskController {
    @GetMapping("/hello")
	public String home(Locale locale, Model model) {



		model.addAttribute("serverTime", formattedDate);
		return "home";
	}
    
}
