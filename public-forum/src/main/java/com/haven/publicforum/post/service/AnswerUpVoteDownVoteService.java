package com.haven.publicforum.post.service;

import com.haven.publicforum.post.dao.AnswerUpVoteDownVoteRepository;
import com.haven.publicforum.post.dao.CommentRepository;
import com.haven.publicforum.post.model.AnswerUpVoteAndDownVote;
import com.haven.publicforum.post.model.AnswerVotesKey;
import com.haven.publicforum.post.model.Comment;
import com.haven.publicforum.security.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class AnswerUpVoteDownVoteService {

    private final AnswerUpVoteDownVoteRepository answerUpVoteDownVoteRepository;
    private final CommentRepository commentRepository;
    private final UserUtil userUtil;
    private final RestTemplate restTemplate;

    @Autowired
    public AnswerUpVoteDownVoteService(AnswerUpVoteDownVoteRepository answerUpVoteDownVoteRepository, CommentRepository commentRepository, UserUtil userUtil, RestTemplate restTemplate) {
        this.answerUpVoteDownVoteRepository = answerUpVoteDownVoteRepository;
        this.commentRepository = commentRepository;
        this.userUtil = userUtil;
        this.restTemplate = restTemplate;
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

        System.out.println(answerUpVoteDownVoteRepository.reputationScore(comment.get().getUserId()));
//        restTemplate.execute("http://user-authentication/reputation/" + comment.get().getUserId()
//                + "/" + ,);

        return true;
    }
}
