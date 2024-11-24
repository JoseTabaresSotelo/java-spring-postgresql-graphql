package com.ti.blog.repository;

import org.springframework.data.repository.CrudRepository;

import com.ti.blog.entity.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

}
