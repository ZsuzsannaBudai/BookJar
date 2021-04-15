/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jpa;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bzse9
 */
public class Regisztralt_EmberTest {
    
    public Regisztralt_EmberTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getName method, of class Regisztralt_Ember.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Regisztralt_Ember instance = new Regisztralt_Ember();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class Regisztralt_Ember.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String Name = "";
        Regisztralt_Ember instance = new Regisztralt_Ember();
        instance.setName(Name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmail method, of class Regisztralt_Ember.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        Regisztralt_Ember instance = new Regisztralt_Ember();
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmail method, of class Regisztralt_Ember.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String Email = "";
        Regisztralt_Ember instance = new Regisztralt_Ember();
        instance.setEmail(Email);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPassword method, of class Regisztralt_Ember.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        Regisztralt_Ember instance = new Regisztralt_Ember();
        String expResult = "";
        String result = instance.getPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPassword method, of class Regisztralt_Ember.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String Password = "";
        Regisztralt_Ember instance = new Regisztralt_Ember();
        instance.setPassword(Password);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRole method, of class Regisztralt_Ember.
     */
    @Test
    public void testGetRole() {
        System.out.println("getRole");
        Regisztralt_Ember instance = new Regisztralt_Ember();
        RoleType expResult = null;
        RoleType result = instance.getRole();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRole method, of class Regisztralt_Ember.
     */
    @Test
    public void testSetRole() {
        System.out.println("setRole");
        RoleType Role = null;
        Regisztralt_Ember instance = new Regisztralt_Ember();
        instance.setRole(Role);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class Regisztralt_Ember.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Regisztralt_Ember instance = new Regisztralt_Ember();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Regisztralt_Ember.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        Regisztralt_Ember instance = new Regisztralt_Ember();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
