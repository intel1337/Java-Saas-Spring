package com.todolist.todolist.service;

public @interface TaskService {
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;
    
    @Service
    public class TaskService {
    
        @Autowired
        private TaskRepository taskRepository;
    
        public Task addTask(String title) {
            Task newTask = new Task(title, false); // task non complétée par défaut
            return taskRepository.save(newTask);
        }
    }
    
}

import com.todolist.todolist.repository.TaskRepository;
