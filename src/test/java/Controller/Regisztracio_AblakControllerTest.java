/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Model;
import com.mycompany.jpa.MysqlCon;
import com.mycompany.jpa.Regisztralt_Ember;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Assert;

/**
 *
 * @author Gabi
 */
public class Regisztracio_AblakControllerTest {
    
    MysqlCon dbCon;
    
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
    
    @Test
    public void testRegistration() throws ClassNotFoundException, SQLException {
        boolean actual = false;
        
        System.out.println("testRegistration");
        Regisztralt_Ember user1 = new Regisztralt_Ember();
        user1.setName("Istvan");
        user1.setEmail("istvan@gmail.com");
        user1.setPassword("istvan123");
        user1.setRole(1);
        
        Model model = new Model();
        model.setSQLInstance(this.dbCon);
        
        model.register(user1.getName(), user1.getEmail(), user1.getPassword());
         
        String driver="com.mysql.cj.jdbc.Driver";
        String url="jdbc:mysql://hosting2128384.online.pro:3306/00504526_bookjardatabase";
        String uname="00504526_bookjardatabase";
        String pass="_9CHmpXxNgqMs8W";
        Class.forName(driver);
        Connection c =(Connection) DriverManager.getConnection(url,uname,pass);
        Statement s=c.createStatement();
        
        String queryCheck1 = "SELECT * from users WHERE Email = '" + user1.getEmail() + "'";
        
        ResultSet rs = s.executeQuery(queryCheck1);
 
        if(rs.next()) {
            actual = true;
        }
        
        if (actual != true)
            fail("Hiba a feltöltésben");
        
        else
            assertTrue(actual);
    }

    /**
     * Test of SendButtonPush method, of class Regisztracio_AblakController.
     */
    /*@Test
    public void testSendButtonPush() throws Exception {
        System.out.println("SendButtonPush");
        ActionEvent event = null;
        Regisztracio_AblakController instance = new Regisztracio_AblakController();
        instance.SendButtonPush(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Registration_BackButton_Pushed method, of class Regisztracio_AblakController.
     */
    /*@Test
    public void testRegistration_BackButton_Pushed() {
        System.out.println("Registration_BackButton_Pushed");
        ActionEvent event = null;
        Regisztracio_AblakController instance = new Regisztracio_AblakController();
        instance.Registration_BackButton_Pushed(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of initialize method, of class Regisztracio_AblakController.
     */
    /*@Test
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
    /*@Test
    public void testSetSQLInstance() {
        System.out.println("setSQLInstance");
        MysqlCon sqlInstance = null;
        Regisztracio_AblakController instance = new Regisztracio_AblakController();
        instance.setSQLInstance(sqlInstance);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */
    
}
