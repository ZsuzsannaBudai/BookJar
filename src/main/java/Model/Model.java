

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import com.mycompany.jpa.MysqlCon;
import com.mycompany.jpa.Regisztralt_Ember;
import com.mycompany.jpa.RoleType;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author bzse9
 */
public class Model {

    MysqlCon dbCon;

    public Regisztralt_Ember login(String email, String password, boolean dolgozo) {
        try {
            ResultSet rs = dbCon.executeQuery("SELECT * FROM users WHERE Email= " + "'" + email + "'" +  
                    "AND Password= " + "'" + password + "'" + 
                    "AND RoleType= " + "'" + ((dolgozo == true) ? RoleType.ADMIN : RoleType.USER) +"';");
            if (rs.next()) {
                Regisztralt_Ember re = new Regisztralt_Ember();
                re.setEmail(rs.getString("Email"));
                re.setPassword(rs.getString("Password"));
                re.setName(rs.getString("Name"));
                re.setId(rs.getInt("UserID"));
                re.setRole(rs.getInt("RoleType") == 0 ? RoleType.ADMIN : RoleType.USER);                
                return re;
            }
        } catch (SQLException e) {
            
        }
        return null;
    }

    public void setSQLInstance(MysqlCon sqlInstance) {
        this.dbCon = sqlInstance;
    }
}
