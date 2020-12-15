package com.haven.publicforum.Authority;

import com.haven.publicforum.Authority.model.AuthorityVerdict;
import com.haven.publicforum.post.dao.PostRepository;
import com.haven.publicforum.post.model.Department;
import com.haven.publicforum.post.model.Post;
import com.haven.publicforum.security.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorityService {

    private final PostRepository postRepository;
    private final AuthorityRepository authorityRepository;
    private final UserUtil userUtil;

    @Autowired
    public AuthorityService(PostRepository postRepository, AuthorityRepository authorityRepository, UserUtil userUtil) {
        this.postRepository = postRepository;
        this.authorityRepository = authorityRepository;
        this.userUtil = userUtil;
    }

    public boolean passVerdict(long postId, AuthorityVerdict authorityVerdict) {
        Optional<Post> post = postRepository.findById(postId);
        if (post.isEmpty()) return false;

        authorityVerdict.setUserId(userUtil.loggedInUser().getId());
        authorityRepository.save(authorityVerdict);

        post.get().setAuthorityVerdict(authorityVerdict);
        postRepository.save(post.get());
        return true;
    }

    public List<Post> getAllPassedPostPerDepartment(String dept_name) {
        return postRepository.findAllByDeptAndAuthorityVerdictNotNull(
                Department.valueOf(dept_name.toUpperCase()));
    }

    public List<Post> getAllPendingPostPerDepartment(String dept_name) {
        return postRepository.findAllByDeptAndAuthorityVerdict(
                Department.valueOf(dept_name.toUpperCase()), null);
    }
}
