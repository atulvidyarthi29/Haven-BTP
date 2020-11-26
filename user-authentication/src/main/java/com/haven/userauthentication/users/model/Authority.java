package com.haven.userauthentication.users.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Authority {
    @Id
    long id;

    @OneToOne
    User user;

    Department department;

}
