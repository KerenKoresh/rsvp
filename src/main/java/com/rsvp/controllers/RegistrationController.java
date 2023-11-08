package com.rsvp.controllers;

import com.rsvp.entities.User;
import com.rsvp.repositories.RoleRepository;
import com.rsvp.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;

@Controller
public class RegistrationController {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder passwordEncoder;

    public RegistrationController(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String username, @RequestParam String password) {
        // Check if the user already exists
        if (userRepository.findByUsername(username) == null) {
            // Create a new user
            User user = new User();
            user.setUsername(username);
            user.setPassword(passwordEncoder.encode(password));

            // Set user role(s) as needed
            user.setRoles(Collections.singleton(roleRepository.getOne("ROLE_USER")));

            // Save the user to the database
            userRepository.save(user);
        }

        // Redirect to the login page
        return "redirect:/login";
    }
}
