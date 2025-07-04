package com.todolist.todolist.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.todolist.todolist.model.*;
import com.todolist.todolist.service.*;
import com.todolist.todolist.dto.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/tasks") // Route
public class TaskController { // Controlleur
    
    @Autowired 
    private TaskService _taskService; // Instance privée de la classe 
    
    @PostMapping("/add") // Route /add
	public Task add(@RequestBody TaskRequest _taskRequest) { // Fonction executée
		return _taskService.addTask(_taskRequest.getTitle(), _taskRequest.getDescription());
	}
    @GetMapping("/get-all")
    public List<Task> getAll() {
        return _taskService.getAllTasks();

    }
    @PutMapping("/update-task/{id}")
    public Task updateStatus(@PathVariable String id, @RequestParam Boolean completed) {
        Task updatedTask = _taskService.updateTaskStatus(id, completed);
        if (updatedTask != null) {
            return updatedTask;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Task not found");
        }
        
    }
    @DeleteMapping("/delete-task/{id}")
    public void deleteTask(@PathVariable String id) {
        Task deletedTask = _taskService.deleteTask(id);
        if (deletedTask == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Task not found");
        }
    }

    
    
}
