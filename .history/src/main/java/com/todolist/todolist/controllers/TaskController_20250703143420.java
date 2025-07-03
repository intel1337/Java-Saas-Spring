package com.todolist.todolist.controllers;



import org.springframework.web.bind.annotation.GetMapping;
import com.todolist.todolist.model.*;

public class TaskController {
    @GetMapping("/hello")
	public String home(Locale locale, Model model) {

DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);
		return "home";
	}
    
}
