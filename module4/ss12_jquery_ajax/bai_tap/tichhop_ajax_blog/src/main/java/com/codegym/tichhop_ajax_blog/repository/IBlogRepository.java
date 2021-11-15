package com.codegym.tichhop_ajax_blog.repository;

import com.codegym.tichhop_ajax_blog.model.Blog;
import com.codegym.tichhop_ajax_blog.model.Category;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;


import java.util.List;

public interface IBlogRepository extends PagingAndSortingRepository<Blog, Long> {

    Page<Blog> findByCategoryId (Long id, Pageable pageable);

    List<Blog> findByTitle(String title);

    Page<Blog> findByTitle(String title, Pageable pageable);


}