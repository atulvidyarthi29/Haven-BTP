package com.haven.publicforum.post.dao;

import com.haven.publicforum.post.model.AnswerUpVoteAndDownVote;
import com.haven.publicforum.post.model.AnswerVotesKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AnswerUpVoteDownVoteRepository extends JpaRepository<AnswerUpVoteAndDownVote, AnswerVotesKey> {
    long countAnswerUpVoteAndDownVoteByIdAndVote(AnswerVotesKey answerVotesKey, int score);

    @Query("select sum(vote) from AnswerUpVoteAndDownVote where id.userId=?1")
    long reputationScore(long userId);
}
