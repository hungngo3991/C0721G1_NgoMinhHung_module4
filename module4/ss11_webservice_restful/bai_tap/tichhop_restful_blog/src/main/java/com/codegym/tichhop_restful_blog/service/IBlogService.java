package com.codegym.tichhop_restful_blog.service;

import com.codegym.tichhop_restful_blog.model.Blog;

public interface IBlogService extends IGeneralService<Blog> {
    Iterable<Blog> findByCateId (Long id);
}
