/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Model;
import com.mycompany.jpa.MysqlCon;
import com.mycompany.jpa.Regisztralt_Ember;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
        System.out.println("TESTING -- register() --");
        boolean actual = false;
        
        LocalDate localdate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = localdate.format(formatter);
        
        
        Regisztralt_Ember user1 = new Regisztralt_Ember();
        user1.setName("Istvan");
        user1.setEmail("istvan@gmail.com");
        user1.setPassword("istvan123");
        user1.setRole(1);
        user1.setDate(formattedDate);
        
        Model model = new Model();
        
        model.register(user1.getName(), user1.getEmail(), user1.getPassword());
         
        String driver="com.mysql.cj.jdbc.Driver";
        String url="jdbc:mysql://hosting2128384.online.pro:3306/00504526_bookjardatabase";
        String uname="00504526_bookjardatabase";
        String pass="_9CHmpXxNgqMs8W";
        Class.forName(driver);
        Connection c =(Connection) DriverManager.getConnection(url,uname,pass);
        Statement s=c.createStatement();
        
        String queryCheck1 = ("SELECT * FROM users WHERE Email= " + "'" + user1.getEmail() + "'" +  
                    "AND Password= " + "'" + user1.getPassword() + "'" + 
                    "AND RoleType= " + "'" + user1.getRole() +"'" +  
                    "AND Date= " + "'" + user1.getDate() + "'" +  
                    "AND Name= " + "'" + user1.getName() + "';");
        
        ResultSet rs = s.executeQuery(queryCheck1);
 
        if(rs.next()) {
            actual = true;
        }
        
        PreparedStatement st = c.prepareStatement("DELETE FROM users WHERE Email = '" + user1.getEmail() + "'");
        st.executeUpdate();
        
        assertEquals(true, actual);
    }
    
    @Test
    public void testLogin_user() throws IOException{
        System.out.println("TESTING -- login_user() --");
        boolean actual = false;
        
        Model model = new Model();
        
        if ((model.login_user("tesztfelhasznalo@gmail.com", "tesztteszt123", 1)) != null)
        {
            actual = true;
        }
        
        assertEquals(true, actual);
    }
    
    @Test
    public void testLogin_admin() throws IOException{
        System.out.println("TESTING -- login_admin --");
        boolean actual = false;
        
        Model model = new Model();
        
        if ((model.login_admin("geregabor@bookjar.com", "admin123", 0)) != null)
        {
            actual = true;
        }
        
        assertEquals(true, actual);
    }
    
    @Test
    public void testFetchData() throws IOException, SQLException {
        System.out.println("TESTING -- FetchData() --");
        boolean actual = false;
        
        ArrayList<Regisztralt_Ember> lista = new ArrayList<>();
        Model model = new Model();
        
        lista = model.FetchData();
        
        if (("Kristof".equals(lista.get(2).getName())) && ("Gabi".equals(lista.get(1).getName())))
        {
            actual = true;
        }
        
        assertEquals(true, actual);
    }
    
}
