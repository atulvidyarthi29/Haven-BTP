package com.haven.publicforum.dao;

import com.haven.publicforum.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PostRepository extends JpaRepository<Post, Long> {
}
