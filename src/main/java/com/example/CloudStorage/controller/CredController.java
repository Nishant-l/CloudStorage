package com.example.CloudStorage.controller;

import com.example.CloudStorage.model.formBackingObjects.CredFormObject;
import com.example.CloudStorage.services.CredService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cred")
public class CredController {
    CredService credService;

    public CredController(CredService credService) {
        this.credService = credService;
    }

    @PostMapping
    public String createNewCred(Authentication authentication, Model model, @ModelAttribute("credFormObject") CredFormObject credFormObject){
        String userName = authentication.getName();
        credService.createNewCred(credFormObject,userName);
        return "redirect:/home";
    }
}
