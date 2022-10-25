package com.nestdigital.books.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class BookModel {
    @Id
    @GeneratedValue
    private int id;
    private String bookname;
    private String bookdiscription;
    private int pages;
    private String language;

    public BookModel(int id, String bookname, String bookdiscription, int pages, String language) {
        this.id = id;
        this.bookname = bookname;
        this.bookdiscription = bookdiscription;
        this.pages = pages;
        this.language = language;
    }

    public BookModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getBookdiscription() {
        return bookdiscription;
    }

    public void setBookdiscription(String bookdiscription) {
        this.bookdiscription = bookdiscription;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
