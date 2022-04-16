package com.example.CloudStorage.mapper;

import com.example.CloudStorage.model.CredModel;
import com.example.CloudStorage.model.formBackingObjects.CredFormObject;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

@Mapper
public interface CredMapper {

    @Select("SELECT * FROM CREDENTIALS WHERE userid = #{userId}")
    public ArrayList<CredModel> getAllCrediantial(int userId);

    @Insert("INSERT INTO CREDENTIALS (url,username,salt,password,userid) VALUES (#{url},#{username},#{salt},#{password},#{userid})")
    @Options(useGeneratedKeys = true, keyProperty = "credentialid")
    public int addCred(CredModel credModel);

}