package com.codegym.ungdung_blog.repository;

import com.codegym.ungdung_blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface IBlogRepository extends JpaRepository<Blog, Long> {
    @Query(value = "SELECT * FROM blog WHERE title LIKE :titleSearch  AND category_id LIKE :idCategorySearch ",
            nativeQuery = true)
    Page<Blog> searchAll(Pageable pageable, @Param("titleSearch") String titleSearch,
                         @Param("idCategorySearch") String idCategorySearch);


}