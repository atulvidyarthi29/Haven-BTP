package com.haven.publicforum.post.controller;

import com.haven.publicforum.post.model.Post;
import com.haven.publicforum.post.service.PostService;
import com.haven.publicforum.post.service.UpVotesDownVotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("posts")
public class PostController {

    private final PostService postService;
    private final UpVotesDownVotesService upVotesDownVotesService;


    @Autowired
    public PostController(PostService postService, UpVotesDownVotesService upVotesDownVotesService) {
        this.postService = postService;
        this.upVotesDownVotesService = upVotesDownVotesService;
    }

    @GetMapping("")
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping("create")
    public ResponseEntity<?> createNewPost(@RequestBody Post newPost) throws Exception {
        postService.createPost(newPost);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public Post getAllPostById(@PathVariable("id") long id) {
        return postService.getPostById(id).orElse(null);
    }

    @DeleteMapping("delete/{id}")
    public void deletePostById(@PathVariable("id") long id) throws Exception {
        postService.deletePost(id);
    }

    @PutMapping("update/{id}")
    public void updatePostById(@PathVariable("id") long id, @RequestBody Post post) throws Exception {
        postService.updatePost(id, post);
    }

    @PostMapping("{postId}/up-vote")
    public void upVote(@PathVariable long postId){
        upVotesDownVotesService.setScore(postId, 10);
    }

    @PostMapping("{postId}/down-vote")
    public void downVote(@PathVariable long postId) {
        upVotesDownVotesService.setScore(postId, -10);
    }

}
