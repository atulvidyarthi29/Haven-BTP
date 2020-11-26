package com.haven.publicforum.users.dao;

import com.haven.publicforum.users.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HavenUserRepository extends JpaRepository<User, Long> {
    public Optional<User> findUserByUsername(String username);
}
