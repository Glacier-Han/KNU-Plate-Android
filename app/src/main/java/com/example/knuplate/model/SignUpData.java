package com.example.knuplate.model;

import com.google.gson.annotations.SerializedName;

public class SignUpData {

    @SerializedName("user_name")
    private String user_name;

    @SerializedName("display_name")
    private String display_name;

    @SerializedName("password")
    private String password;

    @SerializedName("mail_address")
    private String mail_address;

    @Override
    public String toString() {
        return "SignUpData{" +
                "user_name='" + user_name + '\'' +
                ", display_name='" + display_name + '\'' +
                ", password='" + password + '\'' +
                ", mail_address='" + mail_address + '\'' +
                '}';
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail_address() {
        return mail_address;
    }

    public void setMail_address(String mail_address) {
        this.mail_address = mail_address;
    }
}
