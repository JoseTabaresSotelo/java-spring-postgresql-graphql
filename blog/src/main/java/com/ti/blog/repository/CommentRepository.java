package com.ti.blog.repository;

import org.springframework.data.repository.CrudRepository;

import com.ti.blog.entity.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long> {

}
