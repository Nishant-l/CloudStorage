package com.example.CloudStorage.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

    @GetMapping
    public String getHomePage(Authentication authentication){
        System.out.println(authentication.getName());
        // TODO ---> create service to feth login user specific data
        return "home";
    }
}
