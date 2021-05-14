package com.example.knuplate.model;

import com.google.gson.annotations.SerializedName;

public class UserData {

    @SerializedName("user_name")
    private String user_name;

    @SerializedName("password")
    private String password;

    @Override
    public String toString() {
        return "UserData{" +
                "user_name='" + user_name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
