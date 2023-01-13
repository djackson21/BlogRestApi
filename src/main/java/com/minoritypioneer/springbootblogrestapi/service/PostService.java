package com.minoritypioneer.springbootblogrestapi.service;

import com.minoritypioneer.springbootblogrestapi.payload.PostDto;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);

    List<PostDto> getAllPost();
}
