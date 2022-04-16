package com.example.CloudStorage.controller;

import com.example.CloudStorage.model.formBackingObjects.CredFormObject;
import com.example.CloudStorage.services.CredService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CredController {
    CredService credService;

    public CredController(CredService credService) {
        this.credService = credService;
    }

    @PostMapping("/cred")
    public String createNewCred(Authentication authentication, Model model, @ModelAttribute("credFormObject") CredFormObject credFormObject){
        String userName = authentication.getName();
        credService.createNewCred(credFormObject,userName);
        return "redirect:/home";
    }

    @GetMapping("/deleteCred")
    public String deleteCred(@RequestParam(value="credentialid", required = false) String credentialid){
        System.out.println(credentialid);
        credService.DeleteCred(credentialid);
        return "redirect:/home";
    }
}
