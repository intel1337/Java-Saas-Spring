package com.todolist.todolist.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.todolist.todolist.model.*;
import com.todolist.todolist.service.*;
import com.todolist.todolist.dto.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RestController
@RequestMapping("/tasks") // Route
public class TaskController { // Controlleur
    
    @Autowired 
    private TaskService _taskService; // Instance privée de la classe 
    @PostMapping("/add") // Route /add
	public Task addTask(@RequestBody TaskRequest _taskRequest) { // Fonction executée
		return _taskService.addTask(_taskRequest.getTitle(), _taskRequest.getDescription());
	}
    @GetMapping("/get-all")
    public List<Task> getAll() {
        return _taskService.getAllTasks();

    }
    
    
}
