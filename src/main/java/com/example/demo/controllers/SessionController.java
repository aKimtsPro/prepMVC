package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SessionController {

    @GetMapping("/login.html")
    public String login(){
        return "form/login";
    }

    @GetMapping("/bad.html")
    public String bad(){
        return "bad";
    }

}
