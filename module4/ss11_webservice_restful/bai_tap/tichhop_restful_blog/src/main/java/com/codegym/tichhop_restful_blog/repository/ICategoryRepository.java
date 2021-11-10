package com.codegym.tichhop_restful_blog.repository;

import com.codegym.tichhop_restful_blog.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Long> {
}
