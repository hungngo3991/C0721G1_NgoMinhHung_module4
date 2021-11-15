package com.codegym.tichhop_ajax_blog.service;

import com.codegym.tichhop_ajax_blog.model.Category;


public interface ICategoryService{
    Iterable<Category> findAll();
}
