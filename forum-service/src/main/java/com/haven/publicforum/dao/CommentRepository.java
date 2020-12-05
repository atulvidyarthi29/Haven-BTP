package com.haven.publicforum.dao;

import com.haven.publicforum.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPostId(long id);

    List<Comment> findByUserId(long id);
}
