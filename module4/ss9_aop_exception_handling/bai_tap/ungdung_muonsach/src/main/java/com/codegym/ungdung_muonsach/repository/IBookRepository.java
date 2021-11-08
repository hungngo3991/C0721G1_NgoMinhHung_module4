package com.codegym.ungdung_muonsach.repository;

import com.codegym.ungdung_muonsach.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book, Long> {
}
