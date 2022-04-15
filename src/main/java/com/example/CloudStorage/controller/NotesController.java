package com.example.CloudStorage.controller;

import com.example.CloudStorage.model.Notes;
import com.example.CloudStorage.model.formBackingObjects.NotesFormObject;
import com.example.CloudStorage.services.NotesService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class NotesController {
    NotesService notesService;

    public NotesController(NotesService notesService) {
        this.notesService = notesService;
    }

    @PostMapping("/notes")
    public String addNote(Authentication authentication, Model model, @ModelAttribute("notesFormObject")NotesFormObject notesFormObject){
        System.out.println("------Notes Post Form Start-------"+authentication.getName());
        if(notesFormObject.getNoteId()!=""){
            notesService.updateNote(notesFormObject.getNotetitle(),notesFormObject.getNotedescription(),Integer.parseInt(notesFormObject.getNoteId(),10));
            System.out.println("---wating for it the noteId-----"+notesFormObject.getNoteId());
        }else{
            int retVal = notesService.addNoteToNotesForAUser(notesFormObject,authentication.getName());
            System.out.println(retVal);
        }
        System.out.println("------Notes Post Form END-------");
        return "redirect:/home";
    }

    @GetMapping("/deleteNote")
    public String deleteNote(@RequestParam(value = "noteid", required = false) String noteid,Authentication authentication, Model model, @ModelAttribute("notesFormObject")NotesFormObject notesFormObject){
        notesService.deleteNote(Integer.parseInt(noteid,10));
        System.out.println("----___----___---__%%%%%"+noteid);
        return "redirect:/home";
    }
}
