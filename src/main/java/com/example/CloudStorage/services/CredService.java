package com.example.CloudStorage.services;

import com.example.CloudStorage.mapper.CredMapper;
import com.example.CloudStorage.mapper.UserMapper;
import com.example.CloudStorage.model.CredModel;
import com.example.CloudStorage.model.formBackingObjects.CredFormObject;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Base64;

@Service
public class CredService {
    CredMapper credMapper;
    EncryptionService encryptionService;
    UserMapper userMapper; // to get usetId associated with a unique userName

    public CredService(CredMapper credMapper, EncryptionService encryptionService, UserMapper userMapper) {
        this.credMapper = credMapper;
        this.encryptionService = encryptionService;
        this.userMapper = userMapper;
    }

    public void createNewCred(CredFormObject obj, String userName){ // to create new crediantial for user
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        String encodedSalt = Base64.getEncoder().encodeToString(salt);
        String encryptedPassword = encryptionService.encryptValue(obj.getPassword(), encodedSalt);
        int userId = userMapper.getUserId(userName);                // to get usetId associated with a unique userName

//        System.out.println(obj.getUrl());
//        System.out.println(obj.getUsername());
//        System.out.println(encryptedPassword);
//        System.out.println(encodedSalt);
//        System.out.println(userId);

        String url = obj.getUrl();
        String userNameTo = obj.getUsername();
        String credId = obj.getCredentialid();

        if(credId==""){
            System.out.println("--Creating New Crediantials--");
            credMapper.addCred(new CredModel(url,userNameTo,encodedSalt,encryptedPassword,userId));
        }else{
            System.out.println("--Updating Existing Crediantials--");
            credMapper.updateCred(url,userNameTo,encodedSalt,encryptedPassword,userId,credId);
        }
    }

    public ArrayList<CredModel> getAllCred(String userName){
        int userId = userMapper.getUserId(userName); // to get usetId associated with a unique userName
        return credMapper.getAllCrediantial(userId);
    }
}
