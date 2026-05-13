package com.ecommerce.smartecommerce.controller;

import com.ecommerce.smartecommerce.model.User;
import com.ecommerce.smartecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String email,
                            @RequestParam String password,
                            Model model) {

        User user = userService.loginUser(email, password);

        if(user != null) {

            model.addAttribute("name", user.getName());

            return "dashboard";
        }

        model.addAttribute("error", "Invalid Email or Password");

        return "login";
    }
}