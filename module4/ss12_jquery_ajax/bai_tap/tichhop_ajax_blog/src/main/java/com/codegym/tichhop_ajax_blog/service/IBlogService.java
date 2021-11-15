package com.codegym.tichhop_ajax_blog.service;

import com.codegym.tichhop_ajax_blog.model.Blog;
import com.codegym.tichhop_ajax_blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface IBlogService {
    Page<Blog> findAll(Pageable pageable);

    List<Blog> findByTitle(String title);

    Page<Blog> findByTitle(String title, Pageable pageable);

    Page<Blog> findByCategoryId(Long id, Pageable pageable);

    Blog findById (Long id);
}
