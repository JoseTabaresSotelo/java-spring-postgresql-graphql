package com.ti.blog.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ti.blog.entity.Comment;
import com.ti.blog.repository.CommentRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CommentServiceImpl implements CommentService {
    CommentRepository commentRepository;

    @Override
    public Comment getComment(Long id) {
        return commentRepository.findById(id).get();
    }

    @Override
    public Comment saveComment(Comment comment) {
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
}
