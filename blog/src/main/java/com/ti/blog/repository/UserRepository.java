package com.ti.blog.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ti.blog.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}