package com.todolist.todolist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.todolist.todolist.repository.TaskRepository;
import com.todolist.todolist.model.Task;

@Service
public class TaskService {
    @Autowired
    private TaskRepository _taskRepository;

    public Task addTask(String title, String description) {
        Task newTask = new Task(title,description, false); 
        return _taskRepository.save(newTask);
    }
    public List<Task> getAllTasks() {
        return _taskRepository.findAll();
    }
    
}
