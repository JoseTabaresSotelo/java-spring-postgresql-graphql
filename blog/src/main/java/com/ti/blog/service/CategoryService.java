package com.ti.blog.service;

import java.util.List;

import com.ti.blog.entity.Category;

public interface CategoryService {
    Category getCategory(Long id);

    Category saveCategory(Category category);

    void deleteCategory(Long id);

    List<Category> getCategories();
}
