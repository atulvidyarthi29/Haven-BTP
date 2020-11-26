package com.haven.publicforum.post.dao;

import com.haven.publicforum.post.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PostRepository extends JpaRepository<Post, Long> {
}
