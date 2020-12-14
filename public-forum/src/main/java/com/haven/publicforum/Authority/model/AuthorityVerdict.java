package com.haven.publicforum.Authority.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AuthorityVerdict {

    @Id
    long id;
    String verdict;
    long userId;
    boolean isAuthentic;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getVerdict() {
        return verdict;
    }

    public void setVerdict(String verdict) {
        this.verdict = verdict;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public boolean isAuthentic() {
        return isAuthentic;
    }

    public void setAuthentic(boolean authentic) {
        isAuthentic = authentic;
    }
}
