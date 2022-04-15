package com.example.CloudStorage.services;

import com.example.CloudStorage.mapper.NotesMapper;
import com.example.CloudStorage.mapper.UserMapper;
import com.example.CloudStorage.model.Notes;
import com.example.CloudStorage.model.formBackingObjects.NotesFormObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class NotesService {
    private NotesMapper notesMapper;
    private UserMapper userMapper;

    public NotesService(NotesMapper notesMapper, UserMapper userMapper) {
        this.notesMapper = notesMapper;
        this.userMapper = userMapper;
    }

    public ArrayList<Notes> getAllNotesAssociatedToUser(String userName){
        int userId = userMapper.getUserId(userName);
        return notesMapper.getNotes(userId);
    }

    public int addNoteToNotesForAUser(NotesFormObject obj, String username){
        int userId = userMapper.getUserId(username);
        return notesMapper.addNoteTONotes(new Notes(obj.getNotetitle(), obj.getNotedescription(), userId));
    }

    public void  deleteNote(int noteid){
        notesMapper.deleteNote(noteid);
    }
}
