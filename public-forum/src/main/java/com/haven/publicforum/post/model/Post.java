package com.haven.publicforum.post.model;


import javax.persistence.*;


@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String title;
    String description;
    long upVotes;
    long downVotes;

    long userId;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUpVotes(long upVotes) {
        this.upVotes = upVotes;
    }

    public void setDownVotes(long downVotes) {
        this.downVotes = downVotes;
    }

    public long getUpVotes() {
        return upVotes;
    }

    public long getDownVotes() {
        return downVotes;
    }

}
