package com.example.prabhakarananbazhag.mlist.activities;

public class Detail {
    public String name;
    public String email;
    public String pass;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPass() {
        return pass;
    }

    public Detail(String name, String email, String pass) {
        this.name = name;
        this.email = email;
        this.pass = pass;
    }

}
