package com.haven.publicforum.security;

import com.haven.publicforum.post.model.HavenUserDetails;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


@Service
public class UserUtil {

    public HavenUserDetails loggedInUser() {
        return (HavenUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
