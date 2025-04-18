package com.adam.taskmanager.service;

import java.util.List;
import com.adam.taskmanager.entity.Task;

// Interface
public interface TaskService {
    // methods
    List<Task> getAllTasks();
    Task getTaskById(Long id);
    Task createTask(Task task);
    Task updateTask(Long id, Task updatedTask);
    void deleteTask(Long id);
}

