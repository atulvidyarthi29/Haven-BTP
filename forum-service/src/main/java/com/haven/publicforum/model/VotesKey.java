package com.haven.publicforum.model;


import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class VotesKey implements Serializable {

    @ManyToOne
    Post post;

    long userId;
}
