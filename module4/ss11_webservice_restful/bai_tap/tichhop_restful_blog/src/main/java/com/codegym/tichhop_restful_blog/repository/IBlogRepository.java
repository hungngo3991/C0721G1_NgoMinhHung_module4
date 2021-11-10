package com.codegym.tichhop_restful_blog.repository;


import com.codegym.tichhop_restful_blog.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IBlogRepository extends JpaRepository<Blog, Long> {
    @Query(value = "SELECT * FROM blog WHERE category_id=:id", nativeQuery = true)
    Iterable<Blog> findByCateId(@Param("id") Long id);
}
