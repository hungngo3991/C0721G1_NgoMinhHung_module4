package com.codegym.ungdung_muonsach.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String bookType;

    private Integer quantity;

    @OneToMany(mappedBy = "book")
    private Set<BookBorrow> bookBorrows;

    public Book() {
    }

    public Book(Long id, String name, String bookType, Integer quantity, Set<BookBorrow> bookBorrows) {
        this.id = id;
        this.name = name;
        this.bookType = bookType;
        this.quantity = quantity;
        this.bookBorrows = bookBorrows;
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

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Set<BookBorrow> getBookBorrows() {
        return bookBorrows;
    }

    public void setBookBorrows(Set<BookBorrow> bookBorrows) {
        this.bookBorrows = bookBorrows;
    }
}