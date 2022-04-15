package com.example.CloudStorage.controller;

import com.example.CloudStorage.model.Notes;
import com.example.CloudStorage.model.formBackingObjects.NotesFormObject;
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

    public HomeController(NotesService notesService) {
        this.notesService = notesService;
    }

    @GetMapping
    public String getHomePage(Authentication authentication,@ModelAttribute("notesFormObject") NotesFormObject notesFormObject, Model model){
        System.out.println(authentication.getName());
        ArrayList<Notes> Notes = notesService.getAllNotesAssociatedToUser(authentication.getName());
        model.addAttribute("notes",Notes);
        // TODO ---> create service to feth login user specific data
        return "home";
    }
}
