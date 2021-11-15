package com.codegym.tichhop_ajax_blog.service.impl;

import com.codegym.tichhop_ajax_blog.model.Category;
import com.codegym.tichhop_ajax_blog.repository.ICategoryRepository;
import com.codegym.tichhop_ajax_blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;


    @Override
    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }
}
