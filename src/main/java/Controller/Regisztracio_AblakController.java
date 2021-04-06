package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class Regisztracio_AblakController implements Initializable {

    @FXML
    private TextField Name_TextField;

    @FXML
    private TextField Email_TextField;

    @FXML
    private PasswordField Password_TextField;

    @FXML
    private PasswordField PasswordAgain_TextField;

    @FXML
    void SendButtonPush(ActionEvent event) throws IOException {
        CharSequence s = "@";
        if(Password_TextField.getText().equals(PasswordAgain_TextField.getText()) && !Name_TextField.getText().isEmpty() && Email_TextField.getText().contains(s)){
            System.out.println("Név: " + Name_TextField.getText() + "\nEmail: " + Email_TextField.getText() + "\nJelszó: " + Password_TextField.getText());
            
        //Parent root = FXMLLoader.load(getClass().getResource("/fxml/Bejelentkezo_Ablak.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/fxml/Bejelentkezo_Ablak.fxml"));
        Stage stage = new Stage();
            stage.setTitle("Bejelentkezés");
            stage.setScene(new Scene(loader.load(), 600, 400));
            
            Bejelentkezo_AblakController controller = loader.getController();
            controller.setDolgozo(false);
            
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }
        else{
            System.out.println("Hibás jelszó vagy egyéb jellegű hiba!");
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
