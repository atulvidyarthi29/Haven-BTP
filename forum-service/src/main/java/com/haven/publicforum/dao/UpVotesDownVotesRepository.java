package com.haven.publicforum.dao;


import com.haven.publicforum.model.UpVoteDownVotes;
import com.haven.publicforum.model.VotesKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpVotesDownVotesRepository extends JpaRepository<UpVoteDownVotes, VotesKey> {
}
