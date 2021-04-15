/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import com.mycompany.jpa.MysqlCon;
import com.mycompany.jpa.Regisztralt_Ember;
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
public class ModelTest {
    
    public ModelTest() {
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
     * Test of login method, of class Model.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        String email = "";
        String password = "";
        boolean dolgozo = false;
        Model instance = new Model();
        Regisztralt_Ember expResult = null;
        Regisztralt_Ember result = instance.login(email, password, dolgozo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSQLInstance method, of class Model.
     */
    @Test
    public void testSetSQLInstance() {
        System.out.println("setSQLInstance");
        MysqlCon sqlInstance = null;
        Model instance = new Model();
        instance.setSQLInstance(sqlInstance);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
