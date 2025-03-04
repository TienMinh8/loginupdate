package com.example.loginupdate.model;

import android.text.TextUtils;
import android.util.Patterns;

public class User {

    private String email;
    private String password;
    private String re_password;
    private int avatar;
    private String username;

    public User(int avatar, String username) {
        this.avatar = avatar;
        this.username = username;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(String streemail, String strepassword, String stre_password) {
        this.email = streemail;
        this.password = strepassword;
        this.re_password = stre_password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRe_password() {
        return re_password;
    }

    public void setRe_password(String re_password) {
        this.re_password = re_password;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isValidemail() {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public boolean isValidpassword() {
        return !TextUtils.isEmpty(password) && password.length() >= 6;
    }

    public boolean isValidre_password() {
        return re_password != null && re_password.equals(password);
    }
}