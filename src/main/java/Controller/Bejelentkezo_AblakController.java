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
        if (dolgozo) {
            if (model.login_admin(LoginWindow_Email.getText(), LoginWindow_Password.getText(), 0) != null) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/fxml/BookJar_Belso_Ablak_Dolgozoi.fxml"));
                Stage stage = new Stage();
                stage.setTitle("BookJar");
                stage.setScene(new Scene(loader.load(), 1000, 500));
                BookJar_Belso_Ablak_DolgozoiController controller = loader.getController();
                controller.setTab(dolgozo);
                controller.setSQLInstance(this.dbCon);
                stage.show();
                ((Node) (event.getSource())).getScene().getWindow().hide();
            } else {
                System.out.println("Hibas felhasznalo v jelszo");
            }
        } else {
            if (model.login_user(LoginWindow_Email.getText(), LoginWindow_Password.getText(), 1) != null) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/fxml/BookJar_Belso_Ablak_Olvasoi.fxml"));
                Stage stage = new Stage();
                stage.setTitle("BookJar");
                stage.setScene(new Scene(loader.load(), 1000, 500));
                BookJar_Belso_Ablak_OlvasoiController controller = loader.getController();
                controller.setTab(dolgozo);
                controller.setSQLInstance(this.dbCon);
                stage.show();
                ((Node) (event.getSource())).getScene().getWindow().hide();
            } else {
                System.out.println("Hibas felhasznalo v jelszo");
            }
        }

        /*if(LoginWindow_Email.getText().equals("email") && LoginWindow_Password.getText().equals("jelszo")){
            
            int dolgozo_int = (dolgozo ? 1 : 0);
            switch(dolgozo_int){
                case 0:
                    {
                        FXMLLoader loader = 
                                new FXMLLoader(getClass().getResource("/View/fxml/BookJar_Belso_Ablak_Olvasoi.fxml"));
                        Stage stage = new Stage();
                        stage.setTitle("BookJar - Olvaso");
                        stage.setScene(new Scene(loader.load(), 1000, 500));
                        stage.setResizable(false);
                        stage.show();
                        ((Node)(event.getSource())).getScene().getWindow().hide();
                    }
                    break;
                case 1:
                    {
                        FXMLLoader loader = 
                                new FXMLLoader(getClass().getResource("/View/fxml/BookJar_Belso_Ablak_Dolgozoi.fxml"));
                        Stage stage = new Stage();
                        stage.setTitle("BookJar - Dolgozo");
                        stage.setScene(new Scene(loader.load(), 1000, 500));
                        stage.setResizable(false);
                        stage.show();
                        ((Node)(event.getSource())).getScene().getWindow().hide();
                    }
                    break;
            }
        }
        else{
            ErrorMessage_Label.setVisible(true);
            
            Task<Void> sleeper = new Task<Void>(){
                @Override
                protected Void call() throws Exception {
                     try{
                         Thread.sleep(3000);
                     } catch(InterruptedException k){}
                     return null;
                } };
            
            new Thread(sleeper).start();
            sleeper.setOnSucceeded(b -> {
                ErrorMessage_Label.setVisible(false);  
            });
        }
    }*/
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
