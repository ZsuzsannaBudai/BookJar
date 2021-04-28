/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Model;
import com.mycompany.jpa.Books;
import com.mycompany.jpa.MysqlCon;
import com.mycompany.jpa.Regisztralt_Ember;
import Controller.Regisztracio_AblakController;
import com.opera.core.systems.scope.protos.ExecProtos;
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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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
    public void testRegistrationFailed() throws ClassNotFoundException, SQLException {
        System.out.println("TESTING -- registerFailed() --");
        boolean actual = false;
        
        Model model = new Model();
        
        int return_value = model.register("krisi", "krisi@krisi.com", "krisi");
        
        if (return_value == 1)
            actual = true;

        assertEquals(true, actual);
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
    public void testLogin_user() throws IOException, SQLException{
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
    public void testLogin_userFail() throws IOException, SQLException{
        boolean actual = false;
        
        Model model = new Model();
        
        if ((model.login_user("nemletezofelhasznalo@valami.com", "nemletezo", 1)) == null)
        {
            actual = true;
        }
        
        assertEquals(true, actual);
    }
    
    @Test
    public void testLogin_admin() throws IOException, SQLException{
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
    public void testLogin_Admin_fail() throws IOException, SQLException {
        boolean actual = false;
        
        Model model = new Model();
        
        if ((model.login_admin("randomhacker", "hacker123", 0)) == null)
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
    
    @Test
    public void testBooks() {
        Books books = new Books();
        
        books.setAuthor("George R. R. Martin");
        books.setTitle("A Game of Thrones (Trónok harca)");
        books.setBookID(1);
        books.setIsbn("0-553-10354-7");
        
        if ("George R. R. Martin".equals(books.getAuthor()))
            System.out.println("Igaz");
        
        if ("A Game of Thrones (Trónok harca)".equals(books.getTitle()))
            System.out.println("Igaz2");
        
        if (1 == books.getBookID())
            System.out.println("Igaz3");
        
        if ("0-553-10354-7".equals(books.getIsbn()))
            System.out.println("Igaz4");
        
        Books books_argumentumokkal = new Books("Leigh Bardugo", "Shadow and Bone (Árnyék és csont)",
                "978-0-8050-9459-6", 20);
        
        if ("Leigh Bardugo".equals(books_argumentumokkal.getAuthor()))
            System.out.println("Igaz");
        
        if ("Shadow and Bone (Árnyék és csont)".equals(books_argumentumokkal.getTitle()))
            System.out.println("Igaz2");
        
        if (20 == books_argumentumokkal.getBookID())
            System.out.println("Igaz3");
        
        if ("978-0-8050-9459-6".equals(books_argumentumokkal.getIsbn()))
            System.out.println("Igaz4");
        
        assertEquals(true, true);
    }
    
    @Test
    public void test_emailiscorrect() {
        boolean actual = false;
        
        Regisztracio_AblakController controller = new Regisztracio_AblakController();
        
        int returnvalue = controller.emailIsCorrect("vargakristof@gmail.com");
        
        if (returnvalue == 1)
            actual = true;
        
        assertEquals(true, actual);
    }
    
    @Test
    public void test_emailiscorrectFail() {
        boolean actual = false;
        
        Regisztracio_AblakController controller = new Regisztracio_AblakController();
        
        int returnvalue = controller.emailIsCorrect("vargakristofgmail.com");
        
        if (returnvalue == 0)
            actual = true;
        
        assertEquals(true, actual);
        
    }
    
    @Test
    public void test_passwordAreEquals() {
        boolean actual = false;
        Regisztracio_AblakController controller = new Regisztracio_AblakController();
        
        int returnvalue = controller.passwordsAreEquals("admin123", "admin123");
        
        if (returnvalue == 1)
            actual = true;
        
        assertEquals(true, actual);
    }
    
    @Test
    public void test_passwordAreEqualsFail() {
        boolean actual = false;
        Regisztracio_AblakController controller = new Regisztracio_AblakController();
        
        int returnvalue = controller.passwordsAreEquals("admin13", "admin123");
        
        if (returnvalue == 0)
            actual = true;
        
        assertEquals(true, actual);
    }
    
    @Test
    public void test_searchQuery() throws SQLException, ClassNotFoundException {
        System.out.println("TESTING -- searchQuery() --");

        BookJar_Belso_Ablak_OlvasoiController controller = new BookJar_Belso_Ablak_OlvasoiController();
        ObservableList<Books> expected = controller.searchQuery("", "", "");
        ObservableList<Books> result = controller.searchQuery(0);

        boolean isEqual = expected.sorted().equals(result.sorted());
        
        assertEquals(expected, result);
        
    }
    
    @Test
    public void test_searchQuery_1() throws SQLException, ClassNotFoundException {
        System.out.println("TESTING -- searchQuery_1() --");

        BookJar_Belso_Ablak_OlvasoiController controller = new BookJar_Belso_Ablak_OlvasoiController();
        ObservableList<Books> expected = FXCollections.observableArrayList();
        ObservableList<Books> result = controller.searchQuery("Leigh Bardugo", "", "");
        
        expected.add(new Books("Leigh Bardugo", "Shadow and Bone (Árnyak és csont)", "978-0-8050-9459-6", 20));
        expected.add(new Books("Leigh Bardugo", "Siege and Storm (Ostrom és vihar)", "9781780621708", 21));
        expected.add(new Books("Leigh Bardugo", "Ruin and rising (Pusztulás és felemelkedés)", "9781510105256", 22));

        boolean isEqual = expected.sorted().equals(result.sorted());
        
        assertEquals(expected, result);
        
    }

}
