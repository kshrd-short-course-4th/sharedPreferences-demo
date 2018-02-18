package com.example.rathana.sharedpreferencesdemo.entity;

/**
 * Created by RATHANA on 2/18/2018.
 */

public class User {
    private String username;
    private String password;
    private String address;
    private String gender;
    public User(){}
    public User(String username, String password, String address, String gender) {
        this.username = username;
        this.password = password;
        this.address = address;
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
