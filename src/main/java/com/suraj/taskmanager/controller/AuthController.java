package com.suraj.taskmanager.controller;

import com.suraj.taskmanager.model.User;
import com.suraj.taskmanager.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    // Show login page
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    // Handle login form
    @PostMapping("/login")
    public String loginSubmit(@RequestParam String email,
                              @RequestParam String password,
                              HttpSession session,
                              Model model) {
        User user = userService.loginUser(email, password);
        if (user != null) {
            session.setAttribute("loggedInUser", user);
            return "redirect:/tasks";
        }
        model.addAttribute("error", "Invalid email or password!");
        return "login";
    }

    // Show register page
    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    // Handle register form
    @PostMapping("/register")
    public String registerSubmit(@RequestParam String fullName,
                                 @RequestParam String email,
                                 @RequestParam String password,
                                 Model model) {
        User user = userService.registerUser(fullName, email, password);
        if (user != null) {
            return "redirect:/login";
        }
        model.addAttribute("error", "Email already exists!");
        return "register";
    }

    // Logout
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}