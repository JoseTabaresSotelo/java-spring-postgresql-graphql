package com.ti.blog.service;

import java.util.List;

import com.ti.blog.entity.Post;

public interface PostService {
    Post getPost(Long id);

    Post savePost(Post post, Long categoryId, Long[] userId);

    void deletePost(Long id);

    List<Post> getPosts();

}
