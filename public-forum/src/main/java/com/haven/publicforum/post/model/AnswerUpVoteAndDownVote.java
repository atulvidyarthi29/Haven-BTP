package com.haven.publicforum.post.model;

import javax.persistence.EmbeddedId;

public class AnswerUpVoteAndDownVote {
    @EmbeddedId
    AnswerVotesKey id;

    int vote;

    public AnswerUpVoteAndDownVote() {
    }

    public AnswerUpVoteAndDownVote(AnswerVotesKey id, int vote) {
        this.id = id;
        this.vote = vote;
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }
}
