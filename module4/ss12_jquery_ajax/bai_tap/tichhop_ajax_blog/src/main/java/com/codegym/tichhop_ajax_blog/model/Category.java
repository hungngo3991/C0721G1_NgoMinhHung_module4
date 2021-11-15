package com.codegym.tichhop_ajax_blog.model;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

import java.util.Set;


@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @JsonBackReference(value = "back_class")
    @OneToMany(mappedBy = "category")

    private Set<Blog> blogs;

    public Category() {
    }

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }


    public Category(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(Set<Blog> blogs) {
        this.blogs = blogs;
    }
}
