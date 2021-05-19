package com.mycompany.jpa;

import java.util.Objects;

/**
 *
 * @author Lali
 */
public class AdminWindow_Lending {
    private String author_lending;
    private String title_lending;
    private String isbn;
    private String lend_date;
    private String lend_date_end;
    private String Email;

    public AdminWindow_Lending() {
    }

    public AdminWindow_Lending(String author_lending, String title_lending, String isbn, String lend_date, String lend_date_end, String Email) {
        this.author_lending = author_lending;
        this.title_lending = title_lending;
        this.isbn = isbn;
        this.lend_date = lend_date;
        this.lend_date_end = lend_date_end;
        this.Email = Email;
    }

    public String getAuthor_lending() {
        return author_lending;
    }

    public String getTitle_lending() {
        return title_lending;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getLend_date() {
        return lend_date;
    }

    public String getLend_date_end() {
        return lend_date_end;
    }

    public String getEmail() {
        return Email;
    }

    public void setAuthor_lending(String author_lending) {
        this.author_lending = author_lending;
    }

    public void setTitle_lending(String title_lending) {
        this.title_lending = title_lending;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setLend_date(String lend_date) {
        this.lend_date = lend_date;
    }

    public void setLend_date_end(String lend_date_end) {
        this.lend_date_end = lend_date_end;
    }

    public void setEmail(String Email) {
        this.Email = Email;
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
        final AdminWindow_Lending other = (AdminWindow_Lending) obj;
        if (!Objects.equals(this.author_lending, other.author_lending)) {
            return false;
        }
        if (!Objects.equals(this.title_lending, other.title_lending)) {
            return false;
        }
        if (!Objects.equals(this.isbn, other.isbn)) {
            return false;
        }
        if (!Objects.equals(this.lend_date, other.lend_date)) {
            return false;
        }
        if (!Objects.equals(this.lend_date_end, other.lend_date_end)) {
            return false;
        }
        if (!Objects.equals(this.Email, other.Email)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getAuthor_lending() + " " + getEmail() + " " + getIsbn() + " " + getLend_date() + " " + getLend_date_end() + " " + getTitle_lending();
    }
    
    
}
