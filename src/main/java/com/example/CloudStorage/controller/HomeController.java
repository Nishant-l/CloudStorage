package com.example.CloudStorage.controller;

import com.example.CloudStorage.model.CredModel;
import com.example.CloudStorage.model.Notes;
import com.example.CloudStorage.model.formBackingObjects.CredFormObject;
import com.example.CloudStorage.model.formBackingObjects.NotesFormObject;
import com.example.CloudStorage.services.CredService;
import com.example.CloudStorage.services.EncryptionService;
import com.example.CloudStorage.services.NotesService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/home")
public class HomeController {
    NotesService notesService;
    CredService credService;
    EncryptionService encryptionService;

    public HomeController(NotesService notesService, CredService credService, EncryptionService encryptionService) {
        this.notesService = notesService;
        this.credService = credService;
        this.encryptionService = encryptionService;
    }

    @GetMapping
    public String getHomePage(Authentication authentication, @ModelAttribute("notesFormObject") NotesFormObject notesFormObject, @ModelAttribute("credFormObject") CredFormObject credFormObject, Model model){
        System.out.println(authentication.getName());
        ArrayList<Notes> Notes = notesService.getAllNotesAssociatedToUser(authentication.getName());
        ArrayList<CredModel> Creds = credService.getAllCred(authentication.getName());
        
        for(CredModel i: Creds){
            String encriptedPassword = i.getPassword();
            String salt = i.getsalt();
            String originalPassword = encryptionService.decryptValue(encriptedPassword,salt);
            i.setOriginalPassword(originalPassword);
        }
        model.addAttribute("notes",Notes);
        model.addAttribute("creds",Creds);
        // TODO ---> create service to feth login user specific data
        return "home";
    }
}
