package Model;

import com.mycompany.jpa.MysqlCon;
import com.mycompany.jpa.Regisztralt_Ember;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bzse9
 */
public class Model {
    
    MysqlCon dbCon;
    
    public static String passLoginUserName;

    public Model() {
        this.dbCon = MysqlCon.getInstance();
    }

    public Regisztralt_Ember login_user(String email, String password, int dolgozo) {
        try {
            ResultSet rs = dbCon.executeQuery("SELECT * FROM users WHERE Email= " + "'" + email + "'" +  
                    "AND Password= " + "'" + password + "'" + 
                    "AND RoleType= " + "'" + dolgozo +"';");
            if (rs.next()) {
                Regisztralt_Ember re = new Regisztralt_Ember();
                re.setEmail(rs.getString("Email"));
                re.setPassword(rs.getString("Password"));
                re.setName(rs.getString("Name"));
                re.setId(rs.getInt("UserID"));
                re.setRole(rs.getInt("RoleType")); 
                
                passLoginUserName = re.getName();
                
                return re;
            }
        } catch (SQLException e) {
            
        }
        return null;
    }
    
    public Regisztralt_Ember login_admin(String email, String password, int dolgozo) {
        try {
            ResultSet rs = dbCon.executeQuery("SELECT * FROM users WHERE Email= " + "'" + email + "'" +  
                    "AND Password= " + "'" + password + "'" + 
                    "AND RoleType= " + "'" + dolgozo +"';");
            if (rs.next()) {
                Regisztralt_Ember re = new Regisztralt_Ember();
                re.setEmail(rs.getString("Email"));
                re.setPassword(rs.getString("Password"));
                re.setName(rs.getString("Name"));
                re.setId(rs.getInt("UserID"));
                re.setRole(rs.getInt("RoleType"));

                passLoginUserName = re.getName();
                
                return re;
            }
        } catch (SQLException e) {
            
        }
        return null;
    }
    
    public int register(String name, String email, String password) throws ClassNotFoundException, SQLException {
        Statement stmt = dbCon.mysqlconnection.createStatement();
        int rolevalue = 1;
        
        LocalDate localdate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = localdate.format(formatter);
        
        ResultSet rs = dbCon.executeQuery("SELECT * FROM users WHERE Email= " 
                + "'" + email + "'" + "AND Name= " + "'" + name + "';");

        if(rs.next()) 
            return 1;
        else
            stmt.executeUpdate("INSERT INTO users(Name, Email, Password, RoleType, Date) VALUE ('"
                    +name+"','"+email+"','"+password+"','"+rolevalue+"','"+formattedDate+"');");
        
        return 0;
    }
    
    public ArrayList<Regisztralt_Ember> FetchData() throws SQLException {
        Statement stmt = dbCon.mysqlconnection.createStatement();
        ArrayList<Regisztralt_Ember> lista = new ArrayList<>();
        
        String sql = "select * from users";
        ResultSet rs = dbCon.executeQuery(sql);
        
        while(rs.next()) {
            Regisztralt_Ember ember = new Regisztralt_Ember();
            int role = Integer.parseInt(rs.getString(2));
            int id = Integer.parseInt(rs.getString(1));
            
            ember.setEmail(rs.getString(4));
            ember.setName(rs.getString(3));
            ember.setPassword(rs.getString(5));
            ember.setRole(role);
            ember.setDate(rs.getString(6));
            ember.setId(id);

            lista.add(ember);            
        }

        return lista;
    }
    
    public ResultSet Catalog(int usedTextFields, String Writer, String Title, String ISBN) throws SQLException {
        ResultSet rs = null;
        
        usedTextFields = 0;
        
        switch (usedTextFields) {
            case 1:
                rs = dbCon.executeQuery("SELECT * FROM books WHERE Author LIKE " 
                        + "'" + "%" + Writer + "%" +"';");
                break;
            case 2:
                rs = dbCon.executeQuery("SELECT * FROM books WHERE Title LIKE " 
                        + "'" + "%" + Title + "%" + "';");
                break;
            case 3:
                rs = dbCon.executeQuery("SELECT * FROM books WHERE Author LIKE " 
                        + "'" + "%" + Writer + "%" + "' AND Title LIKE" 
                                + "'" + "%" + Title + "%" +"';");
                break;
            case 4:
                rs = dbCon.executeQuery("SELECT * FROM books WHERE ISBN LIKE " 
                        + "'" + "%" + ISBN + "%" +"';");
                break;
            case 5:
                rs = dbCon.executeQuery("SELECT * FROM books WHERE Author LIKE " 
                        + "'" + "%" + Writer + "%" + "' AND ISBN LIKE" 
                                + "'" + "%" + ISBN + "%" +"';");
                break;
            case 6:
                rs = dbCon.executeQuery("SELECT * FROM books WHERE Title LIKE " 
                        + "'" + "%" + Title + "%" + "' AND ISBN LIKE" 
                                + "'" + "%" + ISBN + "%" +"';");
                break;
            case 7:
                rs = dbCon.executeQuery("SELECT * FROM books WHERE Author LIKE " 
                        + "'" + "%" + Writer + "%" + "' AND Title LIKE" 
                                + "'" + "%" + Title + "%" + "' AND ISBN LIKE"
                                        + "'" + "%" + ISBN + "%" + "';");
                break;
            default:
                rs = dbCon.executeQuery("SELECT * FROM books;");
                break;
        }
        
        
        return rs;
    }
}