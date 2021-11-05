package com.codegym.ungdung_blog.model;



import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 99)
    private String title;
    @Column(length = 999)
    private String content;
    @ManyToOne(targetEntity = Category.class)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;
    private Date date;


    public Blog() {
    }

    public Blog(Long id, String title, String content, Category category, Date date) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.category = category;
        this.date = date;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}