package com.airbook.app.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping
    public String hi() {
        return "<h2>Hi, everyone!!!</h2>";
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/user")
    public String userHi() {
        return "<h1>Hi, user!</h1>";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public String adminHi() {
        return "<h1>Hi, admin!</h1>";
    }


}
