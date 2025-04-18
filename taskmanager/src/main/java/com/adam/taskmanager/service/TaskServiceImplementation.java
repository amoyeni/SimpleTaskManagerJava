package com.adam.taskmanager.service;

import org.springframework.stereotype.Service;
import java.util.List;

import com.adam.taskmanager.entity.Task;
import com.adam.taskmanager.repository.TaskRepository; 

@Service
public class TaskServiceImplementation implements TaskService {
    // implementation
    private final TaskRepository repo;

    public TaskServiceImplementation(TaskRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Task> getAllTasks() {
        return repo.findAll();
    }

    @Override
    public Task getTaskById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    @Override
    public Task createTask(Task task) {
        return repo.save(task);
    }

    @Override
    public Task updateTask(Long id, Task updatedTask) {
        Task task = getTaskById(id);
        task.setTitle(updatedTask.getTitle());
        task.setDescription(updatedTask.getDescription());
        task.setCompleted(updatedTask.isCompleted());
        return repo.save(task);
    }

    @Override
    public void deleteTask(Long id) {
        repo.deleteById(id);
    }
}
