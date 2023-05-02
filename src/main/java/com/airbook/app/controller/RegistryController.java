package com.airbook.app.controller;


import ch.qos.logback.core.encoder.EchoEncoder;
import com.airbook.app.model.User;
import com.airbook.app.repo.UserRepo;
import com.airbook.app.service.RegistryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class RegistryController {

    private final RegistryService registryService;
    private PasswordEncoder passwortEncoder;

    @Autowired
    public RegistryController(RegistryService registryService, PasswordEncoder passwortEncoder) {
        this.registryService = registryService;
        this.passwortEncoder = passwortEncoder;
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "registration";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user, Model model, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        user.setPassword(passwortEncoder.encode(user.getPassword()));
        registryService.registerUser(user);

        System.out.println(user.getPassword());
    return "redirect:/login";
    }
}
