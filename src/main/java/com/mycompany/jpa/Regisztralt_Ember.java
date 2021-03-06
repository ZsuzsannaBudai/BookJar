/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Gabi
 */
@Entity
public class Regisztralt_Ember implements Serializable{
    
    private String Name;
    private String Email;
    private String Password;
    private int Role;
    private int id;
    private String Date;
    private int BookedNumbers;

    public void setBookedNumbers(int BookedNumbers) {
        this.BookedNumbers = BookedNumbers;
    }

    public int getBookedNumbers() {
        return BookedNumbers;
    }

    @Basic                                                  // @Basic -> Adatbázisban az oszlopok létrehozása az adott változóhoz
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    @Basic
    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    @Basic
    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    
    @Basic
    //@Enumerated(EnumType.STRING)                        // Ha ez a sor kimaradt, az adatbázisban 0 vagy 1 érték jelenik meg, ezért megmondjuk neki, hogy STRING-ben írja ki
    public int getRole() {
        return Role;
    }

    public void setRole(int Role) {
        this.Role = Role;
    }

    @Basic
    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    @GeneratedValue
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    } 
}