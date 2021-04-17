package Controller;

import Model.Model;
import com.mycompany.jpa.MysqlCon;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Regisztracio_AblakController implements Initializable {

    MysqlCon dbCon;

    public boolean dolgozo;
    
    @FXML
    private TextField Name_TextField;

    @FXML
    private TextField Email_TextField;

    @FXML
    private PasswordField Password_TextField;

    @FXML
    private PasswordField PasswordAgain_TextField;
    
    @FXML
    private Label ErrorMessage_Label;

    @FXML
    void SendButtonPush(ActionEvent event) throws IOException, ClassNotFoundException, SQLException {
        Model model = new Model();
        
        if((model.register(Name_TextField.getText(), Email_TextField.getText(), Password_TextField.getText())) == 0){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/fxml/Bejelentkezo_Ablak.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Bejelentkezés");
            stage.setScene(new Scene(loader.load(), 1000, 500));
            Bejelentkezo_AblakController controller = loader.getController();
            controller.setDolgozo(false);
            stage.show();
            ((Node) (event.getSource())).getScene().getWindow().hide();
        }
        else
        {
            ErrorMessage_Label.setVisible(true);

                Task<Void> sleeper = new Task<Void>() {
                    @Override
                    protected Void call() throws Exception {
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException k) {
                        }
                        return null;
                    }
                };

                new Thread(sleeper).start();
                sleeper.setOnSucceeded(b -> {
                    ErrorMessage_Label.setVisible(false);
                });
        }
        
    }
    
    @FXML
    void Registration_BackButton_Push(ActionEvent event) {
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.dbCon = MysqlCon.getInstance();
        ErrorMessage_Label.setVisible(false);
    }
}
