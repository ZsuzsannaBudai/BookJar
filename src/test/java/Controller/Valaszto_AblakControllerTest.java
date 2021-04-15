/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

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
public class Valaszto_AblakControllerTest {
    
    public Valaszto_AblakControllerTest() {
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
     * Test of initialize method, of class Valaszto_AblakController.
     */
    @Test
    public void testInitialize() {
        System.out.println("initialize");
        URL url = null;
        ResourceBundle rb = null;
        Valaszto_AblakController instance = new Valaszto_AblakController();
        instance.initialize(url, rb);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Dolgozoi_Bejelentkezes_Action method, of class Valaszto_AblakController.
     */
    @Test
    public void testDolgozoi_Bejelentkezes_Action() throws Exception {
        System.out.println("Dolgozoi_Bejelentkezes_Action");
        ActionEvent event = null;
        Valaszto_AblakController instance = new Valaszto_AblakController();
        instance.Dolgozoi_Bejelentkezes_Action(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of OlvasoiBejelentkezes_Action method, of class Valaszto_AblakController.
     */
    @Test
    public void testOlvasoiBejelentkezes_Action() throws Exception {
        System.out.println("OlvasoiBejelentkezes_Action");
        ActionEvent event = null;
        Valaszto_AblakController instance = new Valaszto_AblakController();
        instance.OlvasoiBejelentkezes_Action(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Regisztracio_Action method, of class Valaszto_AblakController.
     */
    @Test
    public void testRegisztracio_Action() throws Exception {
        System.out.println("Regisztracio_Action");
        ActionEvent event = null;
        Valaszto_AblakController instance = new Valaszto_AblakController();
        instance.Regisztracio_Action(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
