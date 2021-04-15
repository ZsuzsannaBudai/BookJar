package Controller;

import com.mycompany.jpa.MysqlCon;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;

public class BookJar_Belso_AblakController implements Initializable {

    MysqlCon dbCon;
    
    @FXML
    private Tab BookJar_Requests;

    @FXML
    private Label BookJar_Main_Label;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        StringBuilder sb = new StringBuilder();
        sb.append("Szia, ").append(">username<").append("! Válassz az alábbi menüpontok közül!");
        BookJar_Main_Label.setText(sb.toString());
    }    
    
    public void setTab(boolean dolgozo){
        BookJar_Requests.setDisable(!dolgozo);
    }
    
    public void setSQLInstance(MysqlCon sqlInstance) {
        this.dbCon = sqlInstance;
    }
}
