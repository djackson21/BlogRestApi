package com.minoritypioneer.springbootblogrestapi.controller;

import com.minoritypioneer.springbootblogrestapi.payload.PostDto;
import com.minoritypioneer.springbootblogrestapi.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {


    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
        return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
    }

    @GetMapping("/posts")
    public List<PostDto> getAllPosts() {
        return postService.getAllPost();
    }
}
