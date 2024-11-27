package com.ti.blog.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ti.blog.entity.Post;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {

}
