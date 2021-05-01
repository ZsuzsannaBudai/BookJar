/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jpa;

import java.util.Objects;

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

    @Override
    public String toString() {
        return author + "," + title + "," + isbn + "," + bookID;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Books other = (Books) obj;
        if (!Objects.equals(this.author, other.author)) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.isbn, other.isbn)) {
            return false;
        }
        if (!Objects.equals(this.bookID, other.bookID)) {
            return false;
        }
        return true;
    }
    
    
}
