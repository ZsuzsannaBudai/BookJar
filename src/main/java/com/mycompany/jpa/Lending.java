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
public class Lending {
    private String author_lending;
    private String title_lending;
    private String lend_date;
    private String lend_date_end;

    public Lending() {
    }

    public Lending(String author_lending, String title_lending, String lend_date, String lend_date_end) {
        this.author_lending = author_lending;
        this.title_lending = title_lending;
        this.lend_date = lend_date;
        this.lend_date_end = lend_date_end;
    }

    public String getAuthor_lending() {
        return author_lending;
    }

    public String getTitle_lending() {
        return title_lending;
    }

    public String getLend_date() {
        return lend_date;
    }

    public String getLend_date_end() {
        return lend_date_end;
    }

    public void setAuthor_lending(String author_lending) {
        this.author_lending = author_lending;
    }

    public void setTitle_lending(String title_lending) {
        this.title_lending = title_lending;
    }

    public void setLend_date(String lend_date) {
        this.lend_date = lend_date;
    }

    public void setLend_date_end(String lend_date_end) {
        this.lend_date_end = lend_date_end;
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
        final Lending other = (Lending) obj;
        if (!Objects.equals(this.author_lending, other.author_lending)) {
            return false;
        }
        if (!Objects.equals(this.title_lending, other.title_lending)) {
            return false;
        }
        if (!Objects.equals(this.lend_date, other.lend_date)) {
            return false;
        }
        if (!Objects.equals(this.lend_date_end, other.lend_date_end)) {
            return false;
        }
        return true;
    }
    
    
    
}
