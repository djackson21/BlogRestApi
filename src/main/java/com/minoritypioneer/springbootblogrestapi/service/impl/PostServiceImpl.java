package com.minoritypioneer.springbootblogrestapi.service.impl;

import com.minoritypioneer.springbootblogrestapi.entity.Post;
import com.minoritypioneer.springbootblogrestapi.payload.PostDto;
import com.minoritypioneer.springbootblogrestapi.repository.PostRepository;
import com.minoritypioneer.springbootblogrestapi.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {

        //convert DTO to entity

        Post post = mapToEntity(postDto);
        Post newPost = postRepository.save(post);

        //convert entity to DTO
        PostDto postResponse = mapToDTO(newPost);
        return postResponse;
    }

    @Override
    public List<PostDto> getAllPost() {

        List<Post> posts = postRepository.findAll();
        return posts.stream().map(post -> mapToDTO(post)).collect(Collectors.toList());
    }

    //convert entity to DTO
    private PostDto mapToDTO(Post post) {
        PostDto postDto= new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setDescription(post.getDescription());
        postDto.setContent(post.getContent());
        return postDto;
    }

    //convert DTO to entity
    private Post mapToEntity(PostDto postDto) {
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        return post;
    }
}
