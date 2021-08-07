/*public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}*/



import java.beans.EventHandler;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.event.*;
import javafx.stage.*;
import javafx.scene.*;


public class App extends Application{

  
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader login= new FXMLLoader(getClass().getResource("Login.fxml"));
        Parent root = login.load();
        Scene scene = new Scene(root);

        primaryStage.setTitle("Login");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }

}
