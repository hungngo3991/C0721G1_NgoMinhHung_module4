package com.codegym.ungdung_blog.controller;

import com.codegym.ungdung_blog.model.Blog;
import com.codegym.ungdung_blog.model.Category;
import com.codegym.ungdung_blog.service.IBlogService;
import com.codegym.ungdung_blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private ICategoryService iCategoryService;

    @ModelAttribute("categories")
    public Iterable<Category> categories() {
        return iCategoryService.findAll();
    }

    @Autowired
    IBlogService blogService;

    @GetMapping("")
    public ModelAndView listBlog(
            @PageableDefault(value = 2, sort = "date", direction = Sort.Direction.ASC) Pageable pageable,
            @RequestParam(value = "titleSearch", defaultValue = "", required = false) String titleSearch,
            @RequestParam(value = "idCategorySearch", defaultValue = "", required = false) String idCategorySearch) {
        Page<Blog> blogList = blogService.searchAll(pageable, titleSearch, idCategorySearch);
        ModelAndView modelAndView = new ModelAndView("/blog/list");
        modelAndView.addObject("titleSearch", titleSearch);
        modelAndView.addObject("idCategorySearch", idCategorySearch);
        modelAndView.addObject("blogList", blogList);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createBlogForm() {
        ModelAndView modelAndView = new ModelAndView("/blog/create");
        List<Category> categoryList = iCategoryService.findAll();
        modelAndView.addObject("blog", new Blog());
        modelAndView.addObject("categoryList", categoryList);
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute Blog blog, @PageableDefault(value = 2) Pageable pageable) {
        blog.setDate(new Date(System.currentTimeMillis()));
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("/blog/create");
        Page<Blog> blogList = blogService.findAll(pageable);
        modelAndView.addObject("blogList", blogList);
        modelAndView.addObject("message", "Create a new successful blog!");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Long id) {
        List<Category> categoryList = iCategoryService.findAll();
        ModelAndView modelAndView = new ModelAndView("/blog/edit");
        modelAndView.addObject("blog", blogService.findById(id));
        modelAndView.addObject("categoryList", categoryList);
        return modelAndView;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute Blog blog) {
        blog.setDate(new Date(System.currentTimeMillis()));
        blogService.update(blog);
        List<Blog> blogList = blogService.findAll();
        ModelAndView modelAndView = new ModelAndView("/blog/edit");
        modelAndView.addObject("blogList", blogList);
        modelAndView.addObject("message", "Update blog successful!");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable Long id, @PageableDefault(value = 2, sort = "date", direction = Sort.Direction.ASC) Pageable pageable,
                               @RequestParam(value = "titleSearch", defaultValue = "", required = false) String titleSearch,
                               @RequestParam(value = "idCategorySearch", defaultValue = "", required = false) String idCategorySearch) {
        blogService.deleteBlog(id);
        Page<Blog> blogList = blogService.searchAll(pageable, titleSearch, idCategorySearch);
        ModelAndView modelAndView = new ModelAndView("/blog/list");
        modelAndView.addObject("titleSearch", titleSearch);
        modelAndView.addObject("idCategorySearch", idCategorySearch);
        modelAndView.addObject("blogList", blogList);
        return modelAndView;
    }

}