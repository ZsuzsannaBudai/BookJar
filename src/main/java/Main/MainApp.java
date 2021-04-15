package Main;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/View/fxml/Valaszto_Ablak.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setTitle("BookJar");
        stage.setScene(scene);
        stage.show();
    }
        
    public static void main(String[] args) {
        launch(args);
    }
}