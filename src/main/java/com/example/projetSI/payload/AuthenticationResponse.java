package com.example.projetSI.payload;

import com.example.projetSI.model.Access;

import java.util.Set;

public class AuthenticationResponse {

    private String token;
    private String type = "Bearer";
    private int userId;
    private String username;
    private Set<Access> authorities;

    //constructors
    public AuthenticationResponse() {}

    public AuthenticationResponse(String token, int userId, String username, Set<Access> authorities) {
        this.token = token;
        this.userId = userId;
        this.username = username;
        this.authorities = authorities;
    }

    //getters
    public String getToken() {
        return token;
    }
    public String getTokenType() {
        return type;
    }
    public int getId() {
        return userId;
    }
    public String getUsername() {
        return username;
    }
    public Set<Access> getUserAuthorities() {
        return authorities;
    }

    //setters
    public void setToken(String token) {
        this.token = token;
    }
    public void setTokenType(String tokenType) {
        this.type = tokenType;
    }
    public void setId(int userId) {
        this.userId = userId;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setUserAuthorities(Set<Access> authorities) {
        this.authorities = authorities;
    }

    // Builder class
    public static class Builder {
        private String token;
        private int userId;
        private String username;
        private Set<Access> authorities;

        public Builder withToken(String token) {
            this.token = token;
            return this;
        }
        public Builder withUserId(int userId) {
            this.userId = userId;
            return this;
        }
        public Builder withUsername(String username) {
            this.username = username;
            return this;
        }
        public Builder withAuthorities(Set<Access> authorities) {
            this.authorities = authorities;
            return this;
        }

        public AuthenticationResponse build() {
            AuthenticationResponse response = new AuthenticationResponse();
            response.token = this.token;
            response.userId = this.userId;
            response.username = this.username;
            response.authorities = this.authorities;
            return response;
        }
    }

    // Static method to obtain the builder
    public static Builder builder() {
        return new Builder();
    }
}
