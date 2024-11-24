package com.ti.blog.service;

import java.util.List;

import com.ti.blog.entity.Comment;

public interface CommentService {
    Comment getComment(Long id);

    Comment saveComment(Comment comment);

    void deleteComment(Long id);

    List<Comment> getComments();

}
