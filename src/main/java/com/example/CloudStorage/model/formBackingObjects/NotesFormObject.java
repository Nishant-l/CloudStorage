package com.example.CloudStorage.model.formBackingObjects;

public class NotesFormObject {
    private String notetitle;
    private String notedescription;

    public NotesFormObject(String notetitle, String notedescription) {
        this.notetitle = notetitle;
        this.notedescription = notedescription;
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
