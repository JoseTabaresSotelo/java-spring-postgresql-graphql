package com.ti.blog.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ti.blog.entity.Category;
import com.ti.blog.entity.Comment;
import com.ti.blog.entity.Post;
import com.ti.blog.entity.User;
import com.ti.blog.repository.CategoryRepository;
import com.ti.blog.repository.CommentRepository;
import com.ti.blog.repository.PostRepository;
import com.ti.blog.repository.UserRepository;
import com.ti.blog.exception.NotFoundException;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CommentServiceImpl implements CommentService {
    CommentRepository commentRepository;
    UserRepository userRepository;
    PostRepository postRepository;
    CategoryRepository categoryRepository;

    @Override
    public Comment getComment(Long id) {
        Optional<Comment> comment = commentRepository.findById(id);
        Comment unwrappedComment = unwrapComment(comment, id);

        return unwrappedComment;
    }

    @Override
    public Comment saveComment(Comment comment, Long userId, Long postId) {
        User user = userRepository.findById(userId).get();
        Post post = postRepository.findById(postId).get();

        comment.setPost(post);
        comment.setAuthor(user);
        comment.setCreatedAt(LocalDate.now());
        comment.setUpdatedAt(LocalDate.now());

        return commentRepository.save(comment);
    }

    @Override
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public List<Comment> getComments() {
        return (List<Comment>) commentRepository.findAll();
    }

    static Comment unwrapComment(Optional<Comment> entity, Long id) {
        if (entity.isPresent())
            return entity.get();
        else
            throw new NotFoundException(id, "Comment");
    }
}
