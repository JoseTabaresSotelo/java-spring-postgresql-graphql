package com.ti.blog.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ti.blog.entity.Post;
import com.ti.blog.repository.PostRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PostServiceImpl implements PostService {
    PostRepository postRepository;

    @Override
    public Post getPost(Long id) {
        return postRepository.findById(id).get();
    }

    @Override
    public Post savePost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public List<Post> getPosts() {
        return (List<Post>) postRepository.findAll();
    }

}
