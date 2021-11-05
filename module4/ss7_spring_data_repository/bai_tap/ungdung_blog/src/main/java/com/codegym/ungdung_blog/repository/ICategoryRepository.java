package com.codegym.ungdung_blog.repository;

import com.codegym.ungdung_blog.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Long> {
}
