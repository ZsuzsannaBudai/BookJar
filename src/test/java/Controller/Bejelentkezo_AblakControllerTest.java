/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.mycompany.jpa.MysqlCon;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
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
public class Bejelentkezo_AblakControllerTest {
    
    public Bejelentkezo_AblakControllerTest() {
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
     * Test of LoginWindow_Button_Pushed method, of class Bejelentkezo_AblakController.
     */
    @Test
    public void testLoginWindow_Button_Pushed() throws Exception {
        System.out.println("LoginWindow_Button_Pushed");
        ActionEvent event = null;
        Bejelentkezo_AblakController instance = new Bejelentkezo_AblakController();
        instance.LoginWindow_Button_Pushed(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of initialize method, of class Bejelentkezo_AblakController.
     */
    @Test
    public void testInitialize() {
        System.out.println("initialize");
        URL url = null;
        ResourceBundle rb = null;
        Bejelentkezo_AblakController instance = new Bejelentkezo_AblakController();
        instance.initialize(url, rb);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDolgozo method, of class Bejelentkezo_AblakController.
     */
    @Test
    public void testSetDolgozo() {
        System.out.println("setDolgozo");
        boolean dolgozo = false;
        Bejelentkezo_AblakController instance = new Bejelentkezo_AblakController();
        instance.setDolgozo(dolgozo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSQLInstance method, of class Bejelentkezo_AblakController.
     */
    @Test
    public void testSetSQLInstance() {
        System.out.println("setSQLInstance");
        MysqlCon sqlInstance = null;
        Bejelentkezo_AblakController instance = new Bejelentkezo_AblakController();
        instance.setSQLInstance(sqlInstance);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
