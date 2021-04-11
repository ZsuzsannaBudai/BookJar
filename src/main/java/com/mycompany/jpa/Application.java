package com.mycompany.jpa;

import java.sql.SQLException;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.h2.tools.Server;

public class Application {

    public static void main(String[] args) throws SQLException {
        startDatabase();                                        // Adatbázis elindítása
        
        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("br.com.fredericci.pu");
        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        System.out.println("Open your browser and navigate to http://localhost:8082/");
        System.out.println("JDBC URL: jdbc:h2:file:~/db_h2");
        System.out.println("User Name: sa");                    // Bejelentkezési adatok
        System.out.println("Password: ");
        
        Regisztralt_Ember admin1 = new Regisztralt_Ember();     // Adminok létrehozása
        admin1.setName("Zsuzsi");
        admin1.setEmail("budaizsuzsanna@gmail.com");
        admin1.setPassword("admin123");
        admin1.setRole(RoleType.ADMIN);
        
        Regisztralt_Ember admin2 = new Regisztralt_Ember();
        admin1.setName("Lajos");
        admin1.setEmail("dankalajos@gmail.com");
        admin1.setPassword("admin123");
        admin1.setRole(RoleType.ADMIN);
        
        Regisztralt_Ember admin3 = new Regisztralt_Ember();
        admin1.setName("Kristof");
        admin1.setEmail("vargakristof@gmail.com");
        admin1.setPassword("admin123");
        admin1.setRole(RoleType.ADMIN);
        
        Regisztralt_Ember admin4 = new Regisztralt_Ember();
        admin1.setName("Gábor");
        admin1.setEmail("geregabor07@gmail.com");
        admin1.setPassword("admin123");
        admin1.setRole(RoleType.ADMIN);
        
        String name;
        String email;
        String password;
        
        Regisztralt_Ember user = new Regisztralt_Ember();       // Egy új user létrehozása
        Scanner in = new Scanner(System.in);                    // User adatainak beolvasása -- Későbbiekben adatok a front-endről?
        name = in.next();       
        email = in.next();
        password = in.next();
        
        
        user.setName(name);                                     // A beolvasott / bekért adatok feltöltése a user classba
        user.setEmail(email);
        user.setPassword(password);
        user.setRole(RoleType.USER);
        

        entityManager.getTransaction().begin();
        entityManager.persist(user);                            // Adatok feltöltése az adatbázisba
        entityManager.getTransaction().commit();
        
        System.out.println("A program hibamentesen a végére ért");
    }

    private static void startDatabase() throws SQLException {
        new Server().runTool("-tcp", "-web", "-ifNotExists");
    }
}
