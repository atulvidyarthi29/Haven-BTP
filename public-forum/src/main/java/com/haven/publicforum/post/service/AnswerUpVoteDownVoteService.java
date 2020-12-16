package com.haven.publicforum.post.service;

import com.haven.publicforum.post.dao.AnswerUpVoteDownVoteRepository;
import com.haven.publicforum.post.dao.CommentRepository;
import com.haven.publicforum.post.model.AnswerUpVoteAndDownVote;
import com.haven.publicforum.post.model.AnswerVotesKey;
import com.haven.publicforum.post.model.Comment;
import com.haven.publicforum.security.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AnswerUpVoteDownVoteService {

    public final AnswerUpVoteDownVoteRepository answerUpVoteDownVoteRepository;
    public final CommentRepository commentRepository;
    public final UserUtil userUtil;

    @Autowired
    public AnswerUpVoteDownVoteService(AnswerUpVoteDownVoteRepository answerUpVoteDownVoteRepository, CommentRepository commentRepository, UserUtil userUtil) {
        this.answerUpVoteDownVoteRepository = answerUpVoteDownVoteRepository;
        this.commentRepository = commentRepository;
        this.userUtil = userUtil;
    }

    public boolean setUpVoteDownVote(long commentId, int score) {
        Optional<Comment> comment = commentRepository.findById(commentId);
        if (comment.isEmpty()) return false;

        AnswerVotesKey answerVotesKey = new AnswerVotesKey(
                comment.get(),
                userUtil.loggedInUser().getId());

        if (score == 0) answerUpVoteDownVoteRepository.deleteById(answerVotesKey);
        else
            answerUpVoteDownVoteRepository.save(new AnswerUpVoteAndDownVote(answerVotesKey, score));

        comment.get().setLikes(
                answerUpVoteDownVoteRepository
                        .countAnswerUpVoteAndDownVoteByIdAndVote(answerVotesKey, 10));
        comment.get().setDislikes(
                answerUpVoteDownVoteRepository
                        .countAnswerUpVoteAndDownVoteByIdAndVote(answerVotesKey, -10));
        commentRepository.save(comment.get());



        return true;
    }
}
