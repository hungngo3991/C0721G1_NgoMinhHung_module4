package com.codegym.tichhop_restful_blog.service.impl;


import com.codegym.tichhop_restful_blog.model.Blog;
import com.codegym.tichhop_restful_blog.repository.IBlogRepository;
import com.codegym.tichhop_restful_blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BlogServiceImpl implements IBlogService {

    @Autowired
    private IBlogRepository blogRepository;


    @Override
    public Iterable<Blog> findByCateId(Long id) {
        return blogRepository.findByCateId(id);
    }

    @Override
    public Iterable<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Optional<Blog> findById(Long id) {
        return blogRepository.findById(id);
    }

    @Override
    public Blog save(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public void remove(Long id) {
        blogRepository.deleteById(id);
    }
}
