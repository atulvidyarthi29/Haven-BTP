package com.haven.publicforum.post.service;

import com.haven.publicforum.post.dao.PostRepository;
import com.haven.publicforum.post.dao.UpVotesDownVotesRepository;
import com.haven.publicforum.post.model.Post;
import com.haven.publicforum.post.model.UpVoteDownVotes;
import com.haven.publicforum.post.model.VotesKey;
import com.haven.publicforum.security.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpVotesDownVotesService {

    private final PostRepository postRepository;
    private final UpVotesDownVotesRepository upVotesDownVotesRepository;
    private final UserUtil userUtil;

    @Autowired
    public UpVotesDownVotesService(PostRepository postRepository, UpVotesDownVotesRepository upVotesDownVotesRepository, UserUtil userUtil) {
        this.postRepository = postRepository;
        this.upVotesDownVotesRepository = upVotesDownVotesRepository;
        this.userUtil = userUtil;
    }

    public boolean setScore(long postId, int score) {
        UpVoteDownVotes upVoteDownVotes = new UpVoteDownVotes();
        Optional<Post> post = postRepository.findById(postId);
        if (post.isEmpty()) return false;
        VotesKey votesKey = new VotesKey(
                post.get(),
                userUtil.loggedInUser().getId());

        post.get().setUpVotes(upVotesDownVotesRepository.countUpVoteDownVotesById(votesKey));
        postRepository.save(post.get());

        upVoteDownVotes.setId(votesKey);
        upVoteDownVotes.setUpOrDown(score);
        upVotesDownVotesRepository.save(upVoteDownVotes);
        return true;
    }

    public void unMarkPost() {

    }

}
