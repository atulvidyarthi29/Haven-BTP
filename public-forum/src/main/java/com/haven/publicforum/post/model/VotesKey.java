package com.haven.publicforum.post.model;


import com.haven.publicforum.users.model.User;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class VotesKey implements Serializable {

    @ManyToOne
    Post post;

    @ManyToOne
    User user;
}
