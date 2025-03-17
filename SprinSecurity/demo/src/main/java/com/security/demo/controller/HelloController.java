package com.security.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
@RestController
public class HelloController {
     @GetMapping("/")
    public String home(HttpServletRequest request) {
        return "Welcome to User Home"+request.getSession().getId();
    }
}
