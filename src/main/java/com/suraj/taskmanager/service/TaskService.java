package com.suraj.taskmanager.service;

import com.suraj.taskmanager.model.Task;
import com.suraj.taskmanager.model.User;
import com.suraj.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks(User user) {
        return taskRepository.findByUser(user);
    }

    public List<Task> getTasksByStatus(User user, String status) {
        return taskRepository.findByUserAndStatus(user, status);
    }

    public Task createTask(String title, String description, String dueDate, User user) {
        Task task = new Task();
        task.setTitle(title);
        task.setDescription(description);
        task.setDueDate(LocalDate.parse(dueDate));
        task.setStatus("PENDING");
        task.setUser(user);
        return taskRepository.save(task);
    }

    public void updateStatus(Long taskId, String status) {
        Task task = taskRepository.findById(taskId).orElse(null);
        if (task != null) {
            task.setStatus(status);
            taskRepository.save(task);
        }
    }

    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
        
    }
    public Task getTaskById(Long taskId) {
        return taskRepository.findById(taskId).orElse(null);
    }

    public void editTask(Long taskId, String title, String description, String dueDate) {
        Task task = taskRepository.findById(taskId).orElse(null);
        if (task != null) {
            task.setTitle(title);
            task.setDescription(description);
            task.setDueDate(LocalDate.parse(dueDate));
            taskRepository.save(task);
        }
    }
}