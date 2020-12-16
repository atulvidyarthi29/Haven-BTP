package com.haven.publicforum.post.dao;


import com.haven.publicforum.post.model.UpVoteDownVotes;
import com.haven.publicforum.post.model.VotesKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UpVotesDownVotesRepository extends JpaRepository<UpVoteDownVotes, VotesKey> {
    long countUpVoteDownVotesById(VotesKey voteskey);
}
