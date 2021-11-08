package com.codegym.ungdung_muonsach.controller;

import com.codegym.ungdung_muonsach.model.Book;
import com.codegym.ungdung_muonsach.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private IBookService bookService;

    @GetMapping("")
    public ModelAndView listBook () {
        ModelAndView modelAndView = new ModelAndView("/book/index");
        modelAndView.addObject("books", bookService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm () {
        ModelAndView modelAndView = new ModelAndView("/book/create");
        modelAndView.addObject("book", new Book());
        return modelAndView;
    }

    @PostMapping("/save")
    public String save (@ModelAttribute Book book, RedirectAttributes redirectAttributes) {
        bookService.save(book);
        redirectAttributes.addFlashAttribute("message", "A new book has been created successfully.");
        return "redirect:/book";
    }

    @GetMapping("/view/{id}")
    public ModelAndView view (@PathVariable Long id) {
        Optional<Book> book = bookService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/book/view");
        modelAndView.addObject("book", book.get());
        return modelAndView;
    }
}
