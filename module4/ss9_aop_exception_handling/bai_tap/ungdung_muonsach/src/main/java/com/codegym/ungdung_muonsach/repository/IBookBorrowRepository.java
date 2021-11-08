package com.codegym.ungdung_muonsach.repository;

import com.codegym.ungdung_muonsach.model.BookBorrow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookBorrowRepository extends JpaRepository<BookBorrow, Long> {
}
