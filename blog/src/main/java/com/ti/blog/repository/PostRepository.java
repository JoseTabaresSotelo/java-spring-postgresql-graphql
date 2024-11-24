package com.ti.blog.repository;

import org.springframework.data.repository.CrudRepository;

import com.ti.blog.entity.Post;

public interface PostRepository extends CrudRepository<Post, Long> {

}
