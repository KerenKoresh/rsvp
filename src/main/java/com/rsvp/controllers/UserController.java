package com.rsvp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping("/login")
    public String login() {
        return "login"; // Return the login page
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration"; // Return the registration page
    }
}
