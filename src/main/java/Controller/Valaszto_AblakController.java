package Controller;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Valaszto_AblakController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    public void Dolgozoi_Bejelentkezes_Action(ActionEvent event) throws IOException {
        //Parent root = FXMLLoader.load(getClass().getResource("/fxml/Bejelentkezo_Ablak.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/fxml/Bejelentkezo_Ablak.fxml"));
        Stage stage = new Stage();
            stage.setTitle("Bejelentkezés");
            stage.setScene(new Scene(loader.load(), 600, 400));
            
            Bejelentkezo_AblakController controller = loader.getController();
            controller.setDolgozo(true);
            
            stage.show();
    }

    @FXML
    public void OlvasoiBejelentkezes_Action(ActionEvent event) throws IOException {
        //Parent root = FXMLLoader.load(getClass().getResource("/fxml/Bejelentkezo_Ablak.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/fxml/Bejelentkezo_Ablak.fxml"));
        Stage stage = new Stage();
            stage.setTitle("Bejelentkezés");
            stage.setScene(new Scene(loader.load(), 600, 400));
            
            Bejelentkezo_AblakController controller = loader.getController();
            controller.setDolgozo(false);
            
            stage.show();
    }

    @FXML
    public void Regisztracio_Action(ActionEvent event) throws IOException {
        //Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("/fxml/Regisztracio_Ablak.fxml"), resources);
        Parent root = FXMLLoader.load(getClass().getResource("/View/fxml/Regisztracio_Ablak.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Regisztráció");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }
    
    
}