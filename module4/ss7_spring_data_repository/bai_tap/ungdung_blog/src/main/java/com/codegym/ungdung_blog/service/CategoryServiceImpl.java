package com.codegym.ungdung_blog.service;


import com.codegym.ungdung_blog.model.Category;
import com.codegym.ungdung_blog.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService{

    @Autowired
    ICategoryRepository iCategoryRepository;


    @Override
    public List<Category> findAll() {
        return iCategoryRepository.findAll();
    }

    @Override
    public void deleteCategory(Long id) {
        iCategoryRepository.deleteById(id);
    }

    @Override
    public void update(Category category) {
        iCategoryRepository.save(category);
    }

    @Override
    public void save(Category category) {
        iCategoryRepository.save(category);
    }

    @Override
    public Category findById(Long id) {
        return iCategoryRepository.findById(id).get();
    }
}
