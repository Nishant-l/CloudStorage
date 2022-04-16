package com.example.CloudStorage.model;

public class CredModel {
    private int credentialid;
    private String url;
    private String username;
    private String salt;
    private String password;
    private String originalPassword;
    private int userid;

    public CredModel(int credentialid, String url, String username, String salt, String password, int userid) {
        this.credentialid = credentialid;
        this.url = url;
        this.username = username;
        this.salt = salt;
        this.password = password;
        this.userid = userid;
    }

    public CredModel(String url, String username, String salt, String password, int userid) {
        this.url = url;
        this.username = username;
        this.salt = salt;
        this.password = password;
        this.userid = userid;
    }

    public String getOriginalPassword() {
        return originalPassword;
    }

    public void setOriginalPassword(String originalPassword) {
        this.originalPassword = originalPassword;
    }

    public int getCredentialid() {
        return credentialid;
    }

    public void setCredentialid(int credentialid) {
        this.credentialid = credentialid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getsalt() {
        return salt;
    }

    public void setsalt(String salt) {
        this.salt = salt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }
}
