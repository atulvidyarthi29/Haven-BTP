package com.haven.publicforum.post.controller;

import com.haven.publicforum.post.model.Comment;
import com.haven.publicforum.post.service.AnswerUpVoteDownVoteService;
import com.haven.publicforum.post.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {

    public final CommentService commentService;
    public final AnswerUpVoteDownVoteService answerUpVoteDownVoteService;

    @Autowired
    public CommentController(CommentService commentService, AnswerUpVoteDownVoteService answerUpVoteDownVoteService) {
        this.commentService = commentService;
        this.answerUpVoteDownVoteService = answerUpVoteDownVoteService;
    }

    @GetMapping("post/{postId}/comments")
    public List<Comment> getCommentsByPost(@PathVariable("postId") int postId) {
        return commentService.getAllCommentsByPost(postId);
    }

    @GetMapping("user/comments")
    public List<Comment> getCommentsByUser() {
        return commentService.getAllCommentsByUser();
    }

    @PostMapping("post/{postId}/new-comment")
    public void addNewComment(@PathVariable("postId") long postId, @RequestBody Comment comment) {
        commentService.addComment(postId, comment);
    }

    @DeleteMapping("post/{postId}/comment/{commentId}")
    public void deleteComment(@PathVariable("postId") long postId,
                              @PathVariable("commentId") long commentId) throws Exception {
        commentService.deleteComment(commentId);
    }

    @PutMapping("post/{postId}/comment/{commentId}")
    public void updateComment(@PathVariable("postId") long postId,
                              @PathVariable("commentId") long commentId, @RequestBody Comment comment) throws Exception {
        commentService.updateComment(commentId, comment);
    }

    @PostMapping("comment/{commentId}/up-vote")
    public void upVoteComment(@PathVariable long commentId){
        answerUpVoteDownVoteService.setUpVoteDownVote(commentId, 10);
    }

    @PostMapping("comment/{commentId}/down-vote")
    public void downVoteComment(@PathVariable long commentId) {
        answerUpVoteDownVoteService.setUpVoteDownVote(commentId, -10);
    }

    @PostMapping("comment/{commentId}/unmark")
    public void unmark(@PathVariable long commentId) {
        answerUpVoteDownVoteService.setUpVoteDownVote(commentId, 0);
    }

}
