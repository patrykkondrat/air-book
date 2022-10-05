package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping(value = "/hello")
    public String getHome() {
        return "<h1>HOME!</h1>";
    }

    @GetMapping(value = "/test")
    public String getStart() {
        return "<h2>Test!!!</h2>";
    }


}
