package com.codegym.tichhop_ajax_blog.controller;


import com.codegym.tichhop_ajax_blog.model.Blog;
import com.codegym.tichhop_ajax_blog.model.Category;
import com.codegym.tichhop_ajax_blog.service.IBlogService;
import com.codegym.tichhop_ajax_blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private IBlogService blogService;

    @GetMapping
    public ResponseEntity<Iterable<Category>> getCategories() {
        Iterable<Category> categories = categoryService.findAll();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Iterable<Blog>> getBlogsByCategoryId(@PathVariable("id") Long id, Pageable pageable) {
        Page<Blog> blogs = blogService.findByCategoryId(id, pageable);
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }
}
