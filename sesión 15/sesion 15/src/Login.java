import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Login {

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Button loginButton;

    @FXML
    private Label mensajeError;

    @FXML
    private void OnActionLogin(ActionEvent event) throws IOException{
        String usuario = username.getText();
        String contraseña = password.getText();
        String error = "";

        usuario= usuario.toUpperCase();
     //   mensajeError.setTextFill(#ff0d00);
     //   mensajeError.setTextFill(arg0);
        if(usuario.equals("PRUEBA")){
            error=("Usuario no válido | ");
        }
        
        if(contraseña.length() < 6){
            error=(error +"Contraseña debe contar con más de 6 caracteres. Intente nuevamente | ");
        }
        
        if(contraseña.equals(username.getText())){
            error=(error + "Contraseña no puede ser igual a usuario.Intente nuevamente | ");
        }
        mensajeError.setText(error);

        if(error.isEmpty()){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Inicio.fxml"));
            Parent root2 = loader.load();


            //Controlador inicio control = loader.getController();
            Scene escena = new Scene(root2);
            Stage stage = new Stage();
            stage.setScene(escena);
            stage.show();
        }else{
            mensajeError.setText(error);
        }

    }
}
