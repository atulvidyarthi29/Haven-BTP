package com.haven.userauthentication.users.dao;

import com.haven.userauthentication.users.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HavenUserRepository extends JpaRepository<User, Long> {
    public Optional<User> findUserByUsername(String username);
}
