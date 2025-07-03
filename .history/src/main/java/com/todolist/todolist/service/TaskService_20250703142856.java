package com.todolist.todolist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.todolist.todolist.repository.TaskRepository;
import com.todolist.todolist.model;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task addTask(String title) {
        Task newTask = new Task(title, false); // tâche non complétée par défaut
        return taskRepository.save(newTask);
    }
}
