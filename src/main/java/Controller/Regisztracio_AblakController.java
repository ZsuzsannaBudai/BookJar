package Controller;

import Model.Model;
import com.mycompany.jpa.MysqlCon;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
    void SendButtonPush(ActionEvent event) throws IOException, ClassNotFoundException, SQLException {
        Model model = new Model();
        model.setSQLInstance(this.dbCon);
        model.register(Email_TextField.getText(), Email_TextField.getText(), Password_TextField.getText());
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/fxml/Bejelentkezo_Ablak.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Bejelentkezés");
        stage.setScene(new Scene(loader.load(), 1000, 500));
        Bejelentkezo_AblakController controller = loader.getController();
        controller.setDolgozo(false);
        controller.setSQLInstance(this.dbCon);
        stage.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    void Registration_BackButton_Pushed(ActionEvent event) {
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void setSQLInstance(MysqlCon sqlInstance) {
        this.dbCon = sqlInstance;
    }
}
