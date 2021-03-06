package com.haven.publicforum.post.model;

import javax.persistence.*;

@Entity
public class UpVoteDownVotes {

    @EmbeddedId
    VotesKey id;

    int vote;

    public VotesKey getId() {
        return id;
    }

    public void setId(VotesKey id) {
        this.id = id;
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }
}
