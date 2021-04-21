/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jpa;

/**
 *
 * @author Lali
 */
public class Books {
    String author;
    String title;
    String isbn;
    Integer bookID;

    public Books() {
    }

    public Books(String author, String title, String isbn, Integer bookID) {
        this.author = author;
        this.title = title;
        this.isbn = isbn;
        this.bookID = bookID;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public Integer getBookID() {
        return bookID;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setBookID(Integer bookID) {
        this.bookID = bookID;
    }
    
    
}
