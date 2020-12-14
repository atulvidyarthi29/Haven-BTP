package com.haven.userauthentication.admin.model;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
public class InvitationDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long tokenId;

    String token;
    String role;
    String email;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    public InvitationDetail() {
    }

    public InvitationDetail(String role, String email) {
        this.createdDate = new Date();
        this.token = UUID.randomUUID().toString();
        this.role = role;
        this.email = email;
    }

    public long getTokenId() {
        return tokenId;
    }

    public void setTokenId(long tokenId) {
        this.tokenId = tokenId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
