package Controller;

import Model.Model;
import com.mycompany.jpa.MysqlCon;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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

public class Bejelentkezo_AblakController implements Initializable {

    MysqlCon dbCon;

    public boolean dolgozo;
    @FXML
    private Label LoginLabel;

    @FXML
    private TextField LoginWindow_Email;

    @FXML
    private PasswordField LoginWindow_Password;

    @FXML
    void LoginWindow_Button_Pushed(ActionEvent event) throws IOException {
        Model model = new Model();
        model.setSQLInstance(this.dbCon);
        if (model.login(LoginWindow_Email.getText(), LoginWindow_Password.getText(), dolgozo) != null) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/fxml/BookJar_Belso_Ablak.fxml"));
            Stage stage = new Stage();
            stage.setTitle("BookJar");
            stage.setScene(new Scene(loader.load(), 1000, 500));
            BookJar_Belso_AblakController controller = loader.getController();
            controller.setTab(dolgozo);
            controller.setSQLInstance(this.dbCon);
            stage.show();
            ((Node) (event.getSource())).getScene().getWindow().hide();
        } else {
            System.out.println("Hibas felhasznalo v jelszo");
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    public void setDolgozo(boolean dolgozo) {
        this.dolgozo = dolgozo;
        Init();
    }

    private void Init() {
        if (dolgozo) {
            LoginLabel.setText("Dolgozói bejelentkezés");
        } else {
            LoginLabel.setText("Olvasói bejelentkezés");
        }
    }

    public void setSQLInstance(MysqlCon sqlInstance) {
        this.dbCon = sqlInstance;
    }
}
