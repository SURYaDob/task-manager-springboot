package com.suraj.taskmanager.controller;

import com.suraj.taskmanager.model.Task;
import com.suraj.taskmanager.model.User;
import com.suraj.taskmanager.service.TaskService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    // Show all tasks
    @GetMapping
    public String showTasks(HttpSession session, Model model,
                            @RequestParam(required = false) String filter) {
        User user = (User) session.getAttribute("loggedInUser");
        if (user == null) return "redirect:/login";

        List<Task> tasks;
        if (filter != null && !filter.isEmpty()) {
            tasks = taskService.getTasksByStatus(user, filter);
        } else {
            tasks = taskService.getAllTasks(user);
        }

        long pending = tasks.stream().filter(t -> t.getStatus().equals("PENDING")).count();
        long completed = tasks.stream().filter(t -> t.getStatus().equals("COMPLETED")).count();

        model.addAttribute("tasks", tasks);
        model.addAttribute("user", user);
        model.addAttribute("pending", pending);
        model.addAttribute("completed", completed);
        model.addAttribute("total", tasks.size());
        model.addAttribute("filter", filter);
        return "tasks";
    }

    // Create new task
    @PostMapping("/create")
    public String createTask(@RequestParam String title,
                             @RequestParam String description,
                             @RequestParam String dueDate,
                             HttpSession session) {
        User user = (User) session.getAttribute("loggedInUser");
        if (user == null) return "redirect:/login";
        taskService.createTask(title, description, dueDate, user);
        return "redirect:/tasks";
    }

    // Update task status
    @GetMapping("/status/{id}")
    public String updateStatus(@PathVariable Long id,
                               @RequestParam String status) {
        taskService.updateStatus(id, status);
        return "redirect:/tasks";
    }

    // Delete task
    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "redirect:/tasks";
    }
 // Show edit form
    @GetMapping("/edit/{id}")
    public String editTaskPage(@PathVariable Long id,
                               HttpSession session,
                               Model model) {
        User user = (User) session.getAttribute("loggedInUser");
        if (user == null) return "redirect:/login";
        Task task = taskService.getTaskById(id);
        model.addAttribute("task", task);
        model.addAttribute("user", user);
        return "edit-task";
    }

    // Handle edit form
    @PostMapping("/edit/{id}")
    public String editTaskSubmit(@PathVariable Long id,
                                 @RequestParam String title,
                                 @RequestParam String description,
                                 @RequestParam String dueDate,
                                 HttpSession session) {
        User user = (User) session.getAttribute("loggedInUser");
        if (user == null) return "redirect:/login";
        taskService.editTask(id, title, description, dueDate);
        return "redirect:/tasks";
    }
}