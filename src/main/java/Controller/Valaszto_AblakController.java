package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.mycompany.jpa.MysqlCon;
import java.sql.SQLException;

public class Valaszto_AblakController implements Initializable {
    
    MysqlCon dbCon;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.dbCon = new MysqlCon();
    }
    
    @FXML
    public void Dolgozoi_Bejelentkezes_Action(ActionEvent event) throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/fxml/Bejelentkezo_Ablak.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Bejelentkezés");
        stage.setScene(new Scene(loader.load(), 1000, 500));
        Bejelentkezo_AblakController controller = loader.getController();
        controller.setDolgozo(true);
        controller.setSQLInstance(this.dbCon);
        stage.show();

    }

    @FXML
    public void OlvasoiBejelentkezes_Action(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/fxml/Bejelentkezo_Ablak.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Bejelentkezés");
        stage.setScene(new Scene(loader.load(), 1000, 500));
        Bejelentkezo_AblakController controller = loader.getController();
        controller.setDolgozo(false);
        controller.setSQLInstance(this.dbCon);
        stage.show();
    }

    @FXML
    public void Regisztracio_Action(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/fxml/Regisztracio_Ablak.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Regisztráció");
        stage.setScene(new Scene(loader.load(), 1000, 500));
        Regisztracio_AblakController controller = loader.getController();
        controller.setSQLInstance(this.dbCon);
        stage.show();
    }  
}
