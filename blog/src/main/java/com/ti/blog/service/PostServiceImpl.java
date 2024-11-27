package com.ti.blog.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ti.blog.entity.Post;
import com.ti.blog.entity.User;
import com.ti.blog.exception.NotFoundException;
import com.ti.blog.entity.Category;
import com.ti.blog.repository.CategoryRepository;
import com.ti.blog.repository.CommentRepository;
import com.ti.blog.repository.PostRepository;
import com.ti.blog.repository.UserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PostServiceImpl implements PostService {
    PostRepository postRepository;
    UserRepository userRepository;
    CategoryRepository categoryRepository;
    CommentRepository commentRepository;

    @Override
    public Post getPost(Long id) {
        return postRepository.findById(id).get();
    }

    @Override
    public Post savePost(Post post, Long userId, Long categoryId) {
        User user = userRepository.findById(userId).get();
        Category category = categoryRepository.findById(categoryId).get();

        post.setUser(user);
        post.setCategory(category);
        post.setCreatedAt(LocalDate.now());
        post.setUpdatedAt(LocalDate.now());

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

    static Post unwrapPost(Optional<Post> entity, Long id) {
        if (entity.isPresent())
            return entity.get();
        else
            throw new NotFoundException(id, "Post");
    }
}
