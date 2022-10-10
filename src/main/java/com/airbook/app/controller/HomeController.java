package com.airbook.app.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping
    public String hi() {
        return "Hi!!!";
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping(value = "/hello")
    public String getHome() {
        return "<h1>HOME!</h1>";
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping(value = "/test")
    public String getStart() {
        return "<h2>Test!!!</h2>";
    }


}
