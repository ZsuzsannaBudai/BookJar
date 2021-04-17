package Controller;

import com.mycompany.jpa.MysqlCon;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import Model.Model;

public class BookJar_Belso_Ablak_DolgozoiController implements Initializable {

    MysqlCon dbCon;

    @FXML
    private Label BookJar_Main_Label;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.dbCon = MysqlCon.getInstance();
        
        Model model = new Model();
        
        StringBuilder sb = new StringBuilder();
        sb.append("Szia, ").append(model.passLoginUserName).append("! Válassz az alábbi menüpontok közül!");
        BookJar_Main_Label.setText(sb.toString());
    }    
    
}