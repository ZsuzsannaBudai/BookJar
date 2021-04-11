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
        
        String first_name;
        String last_name;
        String email;
        String password;
        
        Regisztralt_Ember user = new Regisztralt_Ember();       // Egy új user létrehozása
        Scanner in = new Scanner(System.in);                    // User adatainak beolvasása -- Későbbiekben adatok a front-endről?
        first_name = in.next();       
        last_name = in.next(); 
        email = in.next();
        password = in.next();
        
        
        user.setFirstName(first_name);                          // A beolvasott / bekért adatok feltöltése a user classba
        user.setLastName(last_name);
        user.setEmail(email);
        user.setPassword(password);
        user.setRole(RoleType.USER);
        

        entityManager.getTransaction().begin();
        entityManager.persist(user);                            // Adatok feltöltése az adatbázisba
        entityManager.getTransaction().commit();

        System.out.println("Open your browser and navigate to http://localhost:8082/");
        System.out.println("JDBC URL: jdbc:h2:file:~/db_h2");
        System.out.println("User Name: sa");                    // Bejelentkezési adatok
        System.out.println("Password: ");

    }

    private static void startDatabase() throws SQLException {
        new Server().runTool("-tcp", "-web", "-ifNotExists");
    }
}
