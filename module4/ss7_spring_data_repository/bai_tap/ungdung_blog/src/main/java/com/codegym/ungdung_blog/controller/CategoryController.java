package com.codegym.ungdung_blog.controller;

import com.codegym.ungdung_blog.model.Category;
import com.codegym.ungdung_blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    ICategoryService iCategoryService;

    @GetMapping("")
    public ModelAndView listCategory() {
        ModelAndView modelAndView = new ModelAndView("/category/list");
        List<Category> categoryList = iCategoryService.findAll();
        modelAndView.addObject("categoryList", categoryList);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createCategoryForm() {
        ModelAndView modelAndView = new ModelAndView("/category/create");
        modelAndView.addObject("category", new Category());
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute Category category) {
        iCategoryService.save(category);
        ModelAndView modelAndView = new ModelAndView("/category/list");
        List<Category> categoryList = iCategoryService.findAll();
        modelAndView.addObject("categoryList", categoryList);
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable Long id) {
        iCategoryService.deleteCategory(id);
        List<Category> categoryList = iCategoryService.findAll();
        ModelAndView modelAndView = new ModelAndView("/category/list");
        modelAndView.addObject("categoryList", categoryList);
        modelAndView.addObject("message", "Delete Completed!");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("/category/edit");
        modelAndView.addObject("category", iCategoryService.findById(id));
        return modelAndView;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute Category category) {
        iCategoryService.update(category);
        List<Category> categoryList = iCategoryService.findAll();
        ModelAndView modelAndView = new ModelAndView("/category/list");
        modelAndView.addObject("categoryList", categoryList);
        modelAndView.addObject("message", "Update Completed!");
        return modelAndView;
    }

}
