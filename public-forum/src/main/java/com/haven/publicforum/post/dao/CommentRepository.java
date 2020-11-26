package com.haven.publicforum.post.dao;

import com.haven.publicforum.post.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPostId(long id);

    List<Comment> findByUserId(long id);
}
