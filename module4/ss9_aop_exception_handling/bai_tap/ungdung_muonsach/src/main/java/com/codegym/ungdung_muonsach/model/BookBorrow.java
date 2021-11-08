package com.codegym.ungdung_muonsach.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class BookBorrow {

    @Id
    private Long idBorrow;

    @ManyToOne(targetEntity = Book.class)
    @JoinColumn(name = "id_book", referencedColumnName = "id")
    private Book book;

    public BookBorrow() {
    }

    public BookBorrow(Long idBorrow, Book book) {
        this.idBorrow = idBorrow;
        this.book = book;
    }

    public Long getIdBorrow() {
        return idBorrow;
    }

    public void setIdBorrow(Long idBorrow) {
        this.idBorrow = idBorrow;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
