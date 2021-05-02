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
    private Label ErrorMessage_Label;

    @FXML
    void LoginWindow_Button_Pushed(ActionEvent event) throws IOException, SQLException {
        Model model = new Model();

        if (dolgozo) {
            if (model.login_admin(LoginWindow_Email.getText(), LoginWindow_Password.getText(), 0) != null) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/fxml/BookJar_Belso_Ablak_Dolgozoi.fxml"));
                Stage stage = new Stage();
                stage.setTitle("BookJar - Dolgozoi");
                stage.setScene(new Scene(loader.load(), 1000, 500));
                BookJar_Belso_Ablak_DolgozoiController controller = loader.getController();
                stage.show();
                ((Node) (event.getSource())).getScene().getWindow().hide();
            } else {
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
        } else {
            if (model.login_user(LoginWindow_Email.getText(), LoginWindow_Password.getText(), 1) != null) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/fxml/BookJar_Belso_Ablak_Olvasoi.fxml"));
                Stage stage = new Stage();
                stage.setTitle("BookJar - Olvasoi");
                stage.setScene(new Scene(loader.load(), 1000, 500));
                BookJar_Belso_Ablak_OlvasoiController controller = loader.getController();
                stage.show();
                ((Node) (event.getSource())).getScene().getWindow().hide();
            } else {
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

    }

    @FXML
    void LoginWindow_BackButton_Pushed(ActionEvent event) {
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.dbCon = MysqlCon.getInstance();
        ErrorMessage_Label.setVisible(false);
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
}
