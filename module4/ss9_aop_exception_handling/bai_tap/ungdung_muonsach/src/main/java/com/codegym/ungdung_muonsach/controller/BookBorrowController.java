package com.codegym.ungdung_muonsach.controller;

import com.codegym.ungdung_muonsach.model.Book;
import com.codegym.ungdung_muonsach.model.BookBorrow;
import com.codegym.ungdung_muonsach.service.IBookBorrowService;
import com.codegym.ungdung_muonsach.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/borrow-return")
public class BookBorrowController {
    @Autowired
    private IBookBorrowService bookBorrowService;

    @Autowired
    private IBookService bookService;

    @PostMapping("/borrow")
    public ModelAndView borrow(@ModelAttribute Book book) throws Exception {
        if (book.getQuantity() > 0) {
            Long idBorrow = (long) (Math.random() * 100000);
            BookBorrow bookBorrow = new BookBorrow(idBorrow, book);
            bookBorrowService.save(bookBorrow);
            book.setQuantity(book.getQuantity() - 1);
            bookService.save(book);
            ModelAndView modelAndView = new ModelAndView("/book/index");
            modelAndView.addObject("books", bookService.findAll());
            modelAndView.addObject("message", "You have successfully borrowed the book. Your book loan id is: " + idBorrow);
            return modelAndView;
        } else {
            throw new Exception("Error");
        }
    }

    @GetMapping("/return")
    public ModelAndView showReturnForm() {
        ModelAndView modelAndView = new ModelAndView("/borrow/index");
        modelAndView.addObject("bookBorrow", new BookBorrow());
        return modelAndView;
    }

    @PostMapping("")
    public String returnBook(@ModelAttribute BookBorrow bookBorrow, RedirectAttributes redirectAttributes) throws Exception {
        Optional<BookBorrow> bookBorrowOptional = bookBorrowService.findById(bookBorrow.getIdBorrow());
        if (bookBorrowOptional.isPresent()) {
            Optional<Book> bookOptional = bookService.findById(bookBorrowOptional.get().getBook().getId());
            bookOptional.get().setQuantity(bookOptional.get().getQuantity() + 1);
            bookService.save(bookOptional.get());
            bookBorrowService.remove(bookBorrow.getIdBorrow());
        } else {
            throw new Exception("Error");
        }
        redirectAttributes.addFlashAttribute("message", "You have successfully returned the book");
        return "redirect:/book";
    }


}
