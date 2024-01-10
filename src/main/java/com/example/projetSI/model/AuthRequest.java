package com.example.projetSI.model;

public class AuthRequest {
    private String username;
    private String password;

    //constructors
    public AuthRequest() {}

    public AuthRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    //getters
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }

    //setters
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
