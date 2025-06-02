package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController 
{
    @GetMapping("/login")
    public String login() 
    {
        return "login";
    }

    @GetMapping("/home")
    public String home() 
    {
        return "home";
    }

    @GetMapping("/admin")
    public String admin() 
    {
        return "admin";
    }

    @GetMapping("/user")
    public String user() 
    {
        return "user";
    }
}
