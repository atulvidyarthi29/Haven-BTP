package com.haven.publicforum.service;

import com.haven.publicforum.dao.CommentRepository;
import com.haven.publicforum.dao.PostRepository;
import com.haven.publicforum.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }


    public List<Comment> getAllCommentsByPost(long postId) {
        return commentRepository.findByPostId(postId);
    }

    public List<Comment> getAllCommentsByUser() {
//        TODO: A big error here
        return commentRepository.findByUserId(0);
    }

    public void addComment(long postId, Comment comment) {
        comment.setPost(postRepository.findById(postId).get());
//        comment.setUser(userUtil.loggedInUser().get());
        commentRepository.save(comment);
    }

    public void deleteComment(long id) throws Exception {
        Optional<Comment> comment = commentRepository.findById(id);
        comment.orElseThrow(() -> new Exception("Comment cannot be retrieved"));

//        if (comment.get().getUser().getId() != userUtil.loggedInUser().get().getId())
//            throw new Exception("Authentication Failed");

        commentRepository.delete(comment.get());
    }

    public void updateComment(long id, Comment comment) throws Exception {
//        if (comment.getUser().getId() != userUtil.loggedInUser().get().getId())
//            throw new Exception("Authentication Failed");

        comment.setId(id);
        commentRepository.save(comment);
    }
}
