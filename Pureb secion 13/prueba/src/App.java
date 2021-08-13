import javafx.application.Application;
import javafx.event.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;


public class App extends Application{
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
       primaryStage.setTitle("Hello World!");
       Button btn = new Button();
       btn.setText("Say 'Hello Word'");
       btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                // TODO Auto-generated method stub
                System.out.println("Hello Word!");
                
            }
       });

       StackPane root = new StackPane();
       root.getChildren().add(btn);
       primaryStage.setScene(new Scene(root, 300, 250));
       primaryStage.show();
    }
}
