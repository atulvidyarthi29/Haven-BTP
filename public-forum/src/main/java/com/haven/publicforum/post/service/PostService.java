package com.haven.publicforum.post.service;

import com.haven.publicforum.post.dao.PostRepository;
import com.haven.publicforum.post.model.Post;
import com.haven.publicforum.security.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final UserUtil userUtil;

    @Autowired
    public PostService(PostRepository postRepository, UserUtil userUtil) {
        this.postRepository = postRepository;
        this.userUtil = userUtil;
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Optional<Post> getPostById(long id) {
        return postRepository.findById(id);
    }

    public void createPost(Post newPost) throws Exception {
        newPost.setUserId(userUtil.loggedInUser().getId());
        postRepository.save(newPost);
    }

    public void deletePost(long id) throws Exception {
        Optional<Post> postToDelete = postRepository.findById(id);
        postToDelete.orElseThrow(() -> new Exception("Post not found"));
        if (postToDelete.get().getUserId() != userUtil.loggedInUser().getId())
            throw new Exception("Authentication Failed");
        postRepository.delete(postToDelete.get());
    }

    public void updatePost(long id, Post post) throws Exception {
        Optional<Post> optionalPost = postRepository.findById(id);
        optionalPost.orElseThrow(() -> new Exception("Cannot retrieve the post."));
        Post postToUpdate = optionalPost.get();
        if (postToUpdate.getId() != userUtil.loggedInUser().getId())
            throw new Exception("Authentication Failed");
        postToUpdate.setTitle(post.getTitle());
        postToUpdate.setDescription(post.getDescription());
        postRepository.save(postToUpdate);
    }
}
