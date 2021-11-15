package com.codegym.tichhop_ajax_blog.service.impl;

import com.codegym.tichhop_ajax_blog.model.Blog;
import com.codegym.tichhop_ajax_blog.repository.IBlogRepository;
import com.codegym.tichhop_ajax_blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BlogServiceImpl implements IBlogService {

    @Autowired
    private IBlogRepository blogRepository;


    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public List<Blog> findByTitle(String title) {
        return blogRepository.findByTitle(title);
    }

    @Override
    public Page<Blog> findByTitle(String title, Pageable pageable) {
        return blogRepository.findByTitle(title, pageable);
    }

    @Override
    public Page<Blog> findByCategoryId(Long id, Pageable pageable) {
        return blogRepository.findByCategoryId(id, pageable);
    }

    @Override
    public Blog findById(Long id) {
        return blogRepository.findById(id).orElse(null);
    }
}
