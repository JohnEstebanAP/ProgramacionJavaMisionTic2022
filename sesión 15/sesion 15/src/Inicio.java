import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sqlite_db.ConexionDb;

import java.sql.ResultSet;
import java.sql.SQLException;
public class Inicio {

    @FXML
    private Label lbInicio;

    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtPCompra;

    @FXML
    private TextField txtPVenta;

    @FXML
    private TextField txtCanBodega;

    @FXML
    private TextField txtCanMinBod;

    @FXML
    private TextField txtCanMaxPer;

    @FXML
    private Button createButton;

    @FXML
    private TextArea txtArea;

    @FXML
    private Button viewButton;

    @FXML
    public void createProduct(ActionEvent event) throws Exception{
        int code = Integer.parseInt(txtCodigo.getText());
        String name = txtNombre.getText(); 
        int pCompra = Integer.parseInt(txtPCompra.getText());
        int pVenta = Integer.parseInt(txtPVenta.getText());
        int cBodega = Integer.parseInt(txtCanBodega.getText());
        int cMin = Integer.parseInt(txtCanMinBod.getText());
        int cMax = Integer.parseInt(txtCanMaxPer.getText());

        //crea conexion a la DB
        ConexionDb.Opendb();

        //Insertamos los datos
        String insertar = "INSERT INTO Productos VAlUES("
        +code+","+"'"+name+"'"+","+pCompra+","+pVenta+","+cBodega+","+cMin+","+cMax+");";
   
        //Ejecutmos instruccion de insert en la BD
        ConexionDb.Ejecute(insertar);
        Limpiar();
    }

    @FXML
    public void viewProduct(ActionEvent event) throws Exception{
        txtArea.setText("");
        //abrir base de Datos
        ConexionDb.Opendb();
        //Crear query Sql para ejecutar
        String query = "SELECT * FROM Productos;";
        //Ejecutamos instruciones SQL de Consulta en la ConexionDb
        //ConexionDB.Consulta(query);
        //String sql= "SELECT * FROM Productos;";

        ResultSet reg = ConexionDb.Consulta(query);//ejecutamos la consulta
        try{
            while (reg.next()){
                // recorre cada fila
                txtArea.appendText(reg.getString("codigo")+"-"+reg.getString("nombre")+"-"+reg.getString("pcompra")+"-"+reg.getString("pventa")+"-"+reg.getString("canbodega")+"-"+reg.getString("canminreq")+"-"+reg.getString("canmaxper")+"\n");
              
            } //endWhile
        }catch (SQLException e){
            System.err.println("Error consulta "+ e.getMessage());
        }//catch 
    }// Fin OnviewProduct

    public void Limpiar(){
        txtCodigo.setText("");
        txtNombre.setText("");
        txtPCompra.setText("");
        txtPVenta.setText("");
        txtCanBodega.setText("");
        txtCanMinBod.setText("");
        txtCanMaxPer.setText("");
        txtCodigo.requestFocus();
    }

}