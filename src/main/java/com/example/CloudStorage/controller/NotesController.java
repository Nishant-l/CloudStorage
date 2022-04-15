package com.example.CloudStorage.controller;

import com.example.CloudStorage.model.formBackingObjects.NotesFormObject;
import com.example.CloudStorage.services.NotesService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/notes")
public class NotesController {
    NotesService notesService;

    public NotesController(NotesService notesService) {
        this.notesService = notesService;
    }

    @PostMapping
    public String addNote(Authentication authentication, Model model, @ModelAttribute("notesFormObject")NotesFormObject notesFormObject){
        System.out.println("------Notes Post Form Start-------"+authentication.getName());
        System.out.println(notesFormObject.getNotetitle());
        System.out.println(notesFormObject.getNotedescription());
        System.out.println(authentication);
        int retVal = notesService.addNoteToNotesForAUser(notesFormObject,authentication.getName());
        System.out.println(retVal);
        System.out.println("------Notes Post Form END-------");
        return "redirect:/home";
    }
}