package com.ti.blog.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ti.blog.entity.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

}
