package com.airbook.app.controller;


import com.airbook.app.model.User;
import com.airbook.app.repo.UserRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
@RequestMapping("/user")
public class RegistryController {

    private UserRepo userRepo;

    @GetMapping("/index")
    public String init() {
        return "index";
    }

    @GetMapping("/registration")
    public String createUser(WebRequest request, Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "registration_form";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute User user, Model model) {
        model.addAttribute("user", user);
        return "display_form";
    }
}
