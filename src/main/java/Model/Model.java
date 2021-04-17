package Model;

import com.mycompany.jpa.MysqlCon;
import com.mycompany.jpa.Regisztralt_Ember;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
                
                System.out.println(passLoginUserName);
                
                return re;
            }
        } catch (SQLException e) {
            
        }
        return null;
    }
    
    public int register(String name, String email, String password) throws ClassNotFoundException, SQLException {
        Statement stmt = dbCon.mysqlconnection.createStatement();
        int rolevalue = 1;
        
        ResultSet rs = dbCon.executeQuery("SELECT * FROM users WHERE Email= " 
                + "'" + email + "'" + "AND Name= " + "'" + name + "';");

        if(rs.next()) 
            return 1;
        else
            stmt.executeUpdate("INSERT INTO users(Name, Email, Password, RoleType) VALUE ('"
                    +name+"','"+email+"','"+password+"','"+rolevalue+"');");
        
        return 0;
    }
}