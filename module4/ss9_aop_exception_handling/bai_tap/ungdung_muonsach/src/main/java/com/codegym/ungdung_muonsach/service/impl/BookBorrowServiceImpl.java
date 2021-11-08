package com.codegym.ungdung_muonsach.service.impl;

import com.codegym.ungdung_muonsach.model.BookBorrow;
import com.codegym.ungdung_muonsach.repository.IBookBorrowRepository;
import com.codegym.ungdung_muonsach.service.IBookBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookBorrowServiceImpl implements IBookBorrowService {

    @Autowired
    private IBookBorrowRepository bookBorrowRepository;

    @Override
    public List<BookBorrow> findAll() {
        return bookBorrowRepository.findAll();
    }

    @Override
    public Optional<BookBorrow> findById(Long id) {
        return bookBorrowRepository.findById(id);
    }

    @Override
    public void save(BookBorrow bookBorrow) {
        bookBorrowRepository.save(bookBorrow);
    }

    @Override
    public void remove(Long id) {
        bookBorrowRepository.deleteById(id);
    }
}
