package com.haven.publicforum.post.model;

import javax.persistence.*;

@Entity
public class UpVoteDownVotes {

    @EmbeddedId
    VotesKey id;

    int upOrDown;

    public VotesKey getId() {
        return id;
    }

    public void setId(VotesKey id) {
        this.id = id;
    }

    public int getUpOrDown() {
        return upOrDown;
    }

    public void setUpOrDown(int upOrDown) {
        this.upOrDown = upOrDown;
    }
}
