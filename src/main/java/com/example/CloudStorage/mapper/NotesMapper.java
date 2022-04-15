package com.example.CloudStorage.mapper;

import com.example.CloudStorage.model.Notes;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

@Mapper
public interface NotesMapper {
    @Select("SELECT * from NOTES WHERE userid = #{userId}")
    ArrayList<Notes> getNotes(int userId);

    @Delete("DELETE FROM NOTES WHERE noteid = ${noteid}")
    void deleteNote(int noteid);

    @Update("UPDATE NOTES SET notetitle=#{notetitle}, notedescription=#{notedescription} WHERE noteid=#{noteid}")
    void updateNotes(String notetitle, String notedescription, int noteid);

    @Insert("INSERT INTO NOTES (notetitle, notedescription, userid) VALUES(#{notetitle}, #{notedescription}, #{userid})")
    @Options(useGeneratedKeys = true, keyProperty = "noteid")
    int addNoteTONotes(Notes note);
}
