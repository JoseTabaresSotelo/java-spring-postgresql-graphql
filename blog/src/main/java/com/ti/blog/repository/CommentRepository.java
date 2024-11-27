package com.ti.blog.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ti.blog.entity.Comment;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {

}
