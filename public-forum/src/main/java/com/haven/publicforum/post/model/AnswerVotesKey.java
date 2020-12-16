package com.haven.publicforum.post.model;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class AnswerVotesKey implements Serializable {

    @ManyToOne
    Comment comment;
    long userId;

    public AnswerVotesKey() {
    }

    public AnswerVotesKey(Comment comment, long userId) {
        this.comment = comment;
        this.userId = userId;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
