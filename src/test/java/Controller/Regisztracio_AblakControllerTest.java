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
public class Regisztracio_AblakControllerTest {
    
    public Regisztracio_AblakControllerTest() {
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
     * Test of SendButtonPush method, of class Regisztracio_AblakController.
     */
    @Test
    public void testSendButtonPush() throws Exception {
        System.out.println("SendButtonPush");
        ActionEvent event = null;
        Regisztracio_AblakController instance = new Regisztracio_AblakController();
        instance.SendButtonPush(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of initialize method, of class Regisztracio_AblakController.
     */
    @Test
    public void testInitialize() {
        System.out.println("initialize");
        URL url = null;
        ResourceBundle rb = null;
        Regisztracio_AblakController instance = new Regisztracio_AblakController();
        instance.initialize(url, rb);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSQLInstance method, of class Regisztracio_AblakController.
     */
    @Test
    public void testSetSQLInstance() {
        System.out.println("setSQLInstance");
        MysqlCon sqlInstance = null;
        Regisztracio_AblakController instance = new Regisztracio_AblakController();
        instance.setSQLInstance(sqlInstance);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
