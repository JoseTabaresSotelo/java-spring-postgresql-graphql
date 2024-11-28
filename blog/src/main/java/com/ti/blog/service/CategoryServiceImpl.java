package com.ti.blog.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ti.blog.entity.Category;
import com.ti.blog.repository.CategoryRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    CategoryRepository categoryRepository;

    @Override
    public Category getCategory(Long id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public Category saveCategory(Category category) {
        category.setCreatedAt(LocalDate.now());
        category.setUpdatedAt(LocalDate.now());
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public List<Category> getCategories() {
        return (List<Category>) categoryRepository.findAll();
    }
}
