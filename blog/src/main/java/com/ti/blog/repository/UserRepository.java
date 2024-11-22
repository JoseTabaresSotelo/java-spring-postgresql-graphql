package com.ti.blog.repository;

import org.springframework.data.repository.CrudRepository;

import com.ti.blog.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {

}