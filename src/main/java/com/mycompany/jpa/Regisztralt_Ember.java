/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Gabi
 */
@Entity
public class Regisztralt_Ember{
    
    private String Name;
    private String Email;
    private String Password;
    private RoleType Role;
    private int id;

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
    @Enumerated(EnumType.STRING)                        // Ha ez a sor kimaradt, az adatbázisban 0 vagy 1 érték jelenik meg, ezért megmondjuk neki, hogy STRING-ben írja ki
    public RoleType getRole() {
        return Role;
    }

    public void setRole(RoleType Role) {
        this.Role = Role;
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
