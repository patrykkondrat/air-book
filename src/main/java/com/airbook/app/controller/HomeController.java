package com.airbook.app.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping
    public String hi() {
        return "<h4>Hi, everyone!!!</h4>";
    }
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/user")
    public String userHi() {
        return "<h3>Hi, user!</h3>";
    }

    @PreAuthorize("hasRole('STUFF')")
    @GetMapping("/stuff")
    public String stuffHi() {
        return "<h2>Hi, stuff!</h2>";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public String adminHi() {
        return "<h1>Hi, admin!</h1>";
    }

}
