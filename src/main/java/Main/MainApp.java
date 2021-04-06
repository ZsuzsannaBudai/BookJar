package Main;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/View/fxml/Scene.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/View/styles/Styles.css");
        stage.setTitle("BookJar");
        stage.setScene(scene);
        stage.show();
    }
        
    public static void main(String[] args) {
        launch(args);
    }
}
