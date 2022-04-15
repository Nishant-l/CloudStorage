package com.example.CloudStorage.mapper;

import com.example.CloudStorage.model.Notes;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface NotesMapper {
    @Select("SELECT * from NOTES WHERE userid = #{userId}")
    ArrayList<Notes> getNotes(int userId);

    @Insert("INSERT INTO NOTES (notetitle, notedescription, userid) VALUES(#{notetitle}, #{notedescription}, #{userid})")
    @Options(useGeneratedKeys = true, keyProperty = "noteid")
    int addNoteTONotes(Notes note);
}
