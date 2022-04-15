package com.example.CloudStorage.model.formBackingObjects;

public class NotesFormObject {
    private String noteId;
    private String notetitle;
    private String notedescription;

    public NotesFormObject(String noteId, String notetitle, String notedescription) {
        this.noteId = noteId;
        this.notetitle = notetitle;
        this.notedescription = notedescription;
    }

    public String getNoteId() {
        return noteId;
    }

    public void setNoteId(String noteId) {
        this.noteId = noteId;
    }

    public String getNotetitle() {
        return notetitle;
    }

    public void setNotetitle(String notetitle) {
        this.notetitle = notetitle;
    }

    public String getNotedescription() {
        return notedescription;
    }

    public void setNotedescription(String notedescription) {
        this.notedescription = notedescription;
    }
}
