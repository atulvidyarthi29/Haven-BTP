package com.haven.userauthentication.admin.model;

public class Request {
    private String email;

    public Request() {
    }

    public Request(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
