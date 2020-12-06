package com.haven.publicforum.post.service;

import com.haven.publicforum.post.dao.CommentRepository;
import com.haven.publicforum.post.dao.PostRepository;
import com.haven.publicforum.post.model.Comment;
import com.haven.publicforum.security.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final UserUtil userUtil;

    @Autowired
    public CommentService(CommentRepository commentRepository, PostRepository postRepository, UserUtil userUtil) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
        this.userUtil = userUtil;
    }


    public List<Comment> getAllCommentsByPost(long postId) {
        return commentRepository.findByPostId(postId);
    }

    public List<Comment> getAllCommentsByUser() {
        return commentRepository.findByUserId(userUtil.loggedInUser().getId());
    }

    public void addComment(long postId, Comment comment) {
        comment.setPost(postRepository.findById(postId).get());
        comment.setUserId(userUtil.loggedInUser().getId());
        commentRepository.save(comment);
    }

    public void deleteComment(long id) throws Exception {
        Optional<Comment> comment = commentRepository.findById(id);
        comment.orElseThrow(() -> new Exception("Comment cannot be retrieved"));

        if (comment.get().getUserId() != userUtil.loggedInUser().getId())
            throw new Exception("Authentication Failed");

        commentRepository.delete(comment.get());
    }

    public void updateComment(long id, Comment comment) throws Exception {
        if (comment.getUserId() != userUtil.loggedInUser().getId())
            throw new Exception("Authentication Failed");

        comment.setId(id);
        commentRepository.save(comment);
    }
}
