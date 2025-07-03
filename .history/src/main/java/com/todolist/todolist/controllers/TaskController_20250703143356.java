package com.todolist.todolist.controllers;

import java.text.DateFormat;
import java.util.Locale;

import org.springframework.web.bind.annotation.GetMapping;
import c

public class TaskController {
    @GetMapping("/hello")
	public String home(Locale locale, Model model) {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);
		return "home";
	}
    
}
