package com.haven.publicforum.post.model;


import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class VotesKey implements Serializable {

    @ManyToOne
    Post post;

    long userId;

    public VotesKey() {
    }

    public VotesKey(Post post, long userId) {
        this.post = post;
        this.userId = userId;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
