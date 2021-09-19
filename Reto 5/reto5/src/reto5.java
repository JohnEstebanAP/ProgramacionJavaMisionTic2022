
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.RadioButton;
import javafx.event.ActionEvent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;


public class reto5 extends Application {
/*
    @FXML
    private TextField txtIdEst;
    @FXML
    private TextField txtNombreEst;
    @FXML
    private TextField txtNotaEst;
    @FXML
    private Button btnGuardarEst;
    @FXML
    private RadioButton rbtnIdGeneroFEst;
    @FXML
    private ToggleGroup rbtnIdGenero;
    @FXML
    private RadioButton rbtnIdGeneroMEst;
    @FXML
    private TextField txtApellidoEst;
    @FXML
    private TextField txtTelefonoEst;
    @FXML
    private TextField txtEdadEst;
    @FXML
    private TextField txtCCEst;
    @FXML
    private ChoiceBox<?> ccbxIdAsignaturaEst;
    @FXML
    private ComboBox<?> cbxAsignaturaEst;
    @FXML
    private TextField txtIdNombrePro;
    @FXML
    private TextField txtNombrePro;
    @FXML
    private TextField txtApellidoPro;
    @FXML
    private TextField txtTelefonoPro;
    @FXML
    private TextField txtCCpro;
    @FXML
    private TextField txtEdadPro;
    @FXML
    private ChoiceBox<?> ccbxIdAsignaturaPro;
    @FXML
    private ComboBox<?> cbxAsignaturaPro;
    @FXML
    private RadioButton rbtnIdGeneroFPro;
    @FXML
    private ToggleGroup rbtnIdGeneroPro;
    @FXML
    private RadioButton rbtnIdGeneroMpro;
    @FXML
    private Button btnGuardarPro;
    @FXML
    private Button btnObtenerDatos;
    @FXML
    private TextArea txtAreaDatos;
    @FXML
    private TextArea txtAreaDatosProcesados;
    @FXML
    private Button btnProcesar;
    @FXML
    private Button btnObtenerDatosPro;
    @FXML
    private TextArea txtAreaDatosPro;
    @FXML
    private TextField txtIdConsultaPro;
    @FXML
    private Button btnConsultarPro;
    @FXML
    private TextArea txtAreaDatosConPro;
    @FXML
    private TextField txtIdNombreConsulta;
    @FXML
    private TextField txtIdMateriaConsulta;
    @FXML
    private Button btnConsultar;
    @FXML
    private TextField txtNombreCon;
    @FXML
    private TextField txtMateriaCon;
    @FXML
    private TextField txtNotaCon;
    @FXML
    private Button btnEditar;
    @FXML
    private Button btnEliminar;
    @FXML
    private RadioButton rbtnGeneroFCon;
    @FXML
    private ToggleGroup rbtnIdGeneroCon;
    @FXML
    private RadioButton rbtnGeneroMCon;
    @FXML
    private TextArea txtAreaConEst;
*/

    static String[] lista = new String[4];
    static double[][] matrizEstudiantes = new double[100][4];
    static int itemMatriz = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader reto4 = new FXMLLoader(getClass().getResource("reto4.fxml"));
        Parent root = reto4.load();
        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
/*
    @FXML
    private void OnActionGuardar(ActionEvent event) throws SQLException {

        // crea conexion a la DB
        ConexionDb.Opendb();

        String idNombre = txtIdNombre.getText();
        String nombre = txtNombre.getText();
        String idGenero = "";
        String idMateria = txtIdMateria.getText();
        try {
            int numMateria = (Integer.parseInt(idMateria));
            switch (numMateria) {
                case 1:
                    txtMateria.setText("matematicas");
                    txtMateria.setPromptText("matematicas");

                    break;
                case 2:
                    txtMateria.setText("informatica");
                    txtMateria.setPromptText("informatica");
                    break;
                case 3:
                    txtMateria.setText("fisica");
                    txtMateria.setPromptText("fisica");
                    break;
            }
        } catch (Exception e) {

        }

        String materia = txtMateria.getText();
        String nota = txtNota.getText();
        if (rbtnIdGeneroF.isSelected()) {
            idGenero = "1";
        }
        if (rbtnIdGeneroM.isSelected()) {
            idGenero = "0";
        }

        // Insertamos los datos
        String insertar = "INSERT INTO Estudiantes (nombre,IdEstudiante,idGenero,materia,idMateria,Nota) VAlUES(" + "'"
                + nombre + "'" + "," + idNombre + "," + idGenero + "," + "'" + materia + "'" + "," + idMateria + ","
                + nota + ");";

        if (idNombre.isEmpty() || nombre.isEmpty() || idGenero.isEmpty() || idGenero.isEmpty() || idMateria.isEmpty()
                || materia.isEmpty() || nota.isEmpty()) {
            mostrarAlert1();
        } // Ejecutmos instruccion de insert en la BD 
        else if (ConexionDb.Ejecute(insertar)) {
            System.out.println("insercion del registro " + insertar + "exitoso");
            clear();
        } else {
            System.err.println("Error en la inserción del registro en la base de datos");
            mostrarAlert2();
        }
    }
*/

/*
    @FXML
    private void OnActionObtenerDatos(ActionEvent event) throws SQLException {
        txtAreaDatos.setText("");
        // abrir base de Datos
        ConexionDb.Opendb();
        // Crear query Sql para ejecutar
        String query = "SELECT * FROM Estudiantes;";
        // Ejecutamos instruciones SQL de Consulta en la ConexionDb
        // ConexionDB.Consulta(query);
        // String sql= "SELECT * FROM Productos;";

        ResultSet reg = ConexionDb.Consulta(query);// ejecutamos la consulta
        try {
            while (reg.next()) {
                // recorre cada fila
                String genero;
                if (reg.getString("idGenero").equals("0")) {
                    genero = "M";
                } else {
                    genero = "F";
                }
                txtAreaDatos.appendText("id: " + reg.getString("id") + "    Nombre: " + reg.getString("nombre")
                        + "     idEstudiante: " + reg.getString("IdEstudiante") + "     Genero: " + genero
                        + "      Materia: " + reg.getString("Materia") + "       IdMateria: "
                        + reg.getString("idMateria") + "   Nota: " + reg.getString("Nota") + "\n");

            } // endWhile
        } catch (SQLException e) {
            System.err.println("Error consulta " + e.getMessage());
        } // catch
    }

    */
    /*
    @FXML
    private void OnActionProcesar(ActionEvent event) throws SQLException {

        txtAreaDatosProcesados.setText("");// Limpiamos el textFieldArea
        int cantidadNotas = itemMatriz; // itemMatriz tiene la cantidad de notas ingresadas en la matriz

        //Implementación de la instancia Estudiante
        Estudiante estudiante = new Estudiante();

        estudiante.contarExcelentes();

        // ¿Cuántos de los exámenes tienen una calificación mayor a la del promedio del
        // grupo?
        txtAreaDatosProcesados.appendText(
                "# exámenes con calificación mayor al promedio: \n" + estudiante.contarMayoresPromedio() + "\n");

        // ¿Qué porcentaje de los exámenes fueron Excelentes?
        String excelentes = String.format("%.2f", estudiante.porsentajeExcelentes());
        txtAreaDatosProcesados.appendText("% exámenes excelentes: \n" + excelentes + "\n");

        // ¿Cuál es la materia con el peor desempeño promedio para todo el grupo?
        txtAreaDatosProcesados
                .appendText("MateriaPeor desempeño promedio: \n" + estudiante.promedioMateriaPeor() + "\n");

        // ¿Cuál es el estudiante con el mejor desempeño para la materia matemáticas?
        txtAreaDatosProcesados.appendText(
                "Estudiante con Mejor desempeño en Matemáticas: \n" + estudiante.estudianteMejorMatematicas() + "\n");
    }
*/
    /*
    @FXML
    void OnActionConsultar(ActionEvent event) throws SQLException {

        String idEstudiante = txtIdNombreConsulta.getText();
        String idMateria = txtIdMateriaConsulta.getText();

        // abrir base de Datos
        ConexionDb.Opendb();
        // Crear query Sql para ejecutar
        String query = "SELECT * FROM Estudiantes  WHERE IdEstudiante=" + idEstudiante + " and idMateria=" + idMateria
                + ";";
        // Ejecutamos instruciones SQL de Consulta en la ConexionDb
        // ConexionDB.Consulta(query);
        // String sql= "SELECT * FROM Productos;";

        if (idEstudiante.isEmpty() || idMateria.isEmpty()) {
            mostrarAlert1();
        } else {
            try {
                ResultSet reg = ConexionDb.Consulta(query);// ejecutamos la consulta

                // verifico que la consulta si tenga contenido si no se muestra una alerta y se
                // limpian los campos.
                try {
                    if (reg.getString("id") == null) {
                    }
                } catch (SQLException e) {
                    clearCon();
                    mostrarAlertNotReg();
                }

                // Recorremos el resultado de la consulta y se lo asignamos a los campos de
                // TextField
                try {
                    while (reg.next()) {
                        txtNombreCon.setText(reg.getString("nombre"));
                        txtMateriaCon.setText(reg.getString("materia"));
                        txtNotaCon.setText(reg.getString("Nota"));
                        int idGenero = reg.getInt("idGenero");
                        if (idGenero == 0) {
                            rbtnGeneroMCon.setSelected(true);
                        } else {
                            rbtnGeneroFCon.setSelected(true);
                        }

                    } // endWhile
                } catch (SQLException e) {
                    System.err.println("Error consulta " + e.getMessage());
                    mostrarAlert2();
                } // catch
            } catch (NullPointerException e) {
                System.err.println("tiene letras en lo campos numericos id.Nombre o id.Materia: " + e.getMessage());
                mostrarAlert2();
            }
        }
    }

    */
    /*
    @FXML
    private void OnActionEditar(ActionEvent event) throws SQLException {
        String idEstudiante = txtIdNombreConsulta.getText();
        String idMateria = txtIdMateriaConsulta.getText();
        String nombre = txtNombreCon.getText();
        String idGenero = "";
        try {
            int numMateria = (Integer.parseInt(idMateria));
            switch (numMateria) {
                case 1:
                    txtMateriaCon.setText("matematicas");
                    txtMateriaCon.setPromptText("matematicas");
                    break;
                case 2:
                    txtMateriaCon.setText("informatica");
                    txtMateriaCon.setPromptText("informatica");
                    break;
                case 3:
                    txtMateriaCon.setText("fisica");
                    txtMateriaCon.setPromptText("fisica");
                    break;
            }
        } catch (Exception e) {

        }

        String materia = txtMateriaCon.getText();
        String nota = txtNotaCon.getText();
        if (rbtnGeneroMCon.isSelected()) {
            idGenero = "0";
        }
        if (rbtnGeneroFCon.isSelected()) {
            idGenero = "1";
        }
        // crea conexion a la DB
        ConexionDb.Opendb();
        //Cremos queri de eliminacion
        String editar ="UPDATE Estudiantes SET nombre='"+nombre+"', idGenero="+idGenero+", materia='"+materia+"',Nota="+nota+" WHERE IdEstudiante="+idEstudiante+" and idMateria="+idMateria+";";

        if (idEstudiante.isEmpty() || nombre.isEmpty() || idGenero.isEmpty() || idMateria.isEmpty() || materia.isEmpty() || nota.isEmpty()) {
            mostrarAlert1();
        }else{
            if(ConexionDb.Ejecute(editar)){
                clearCon();
            }
        }
    }
*/
/*  
    @FXML
    private void OnActionEliminar(ActionEvent event) throws SQLException {
        String idEstudiante = txtIdNombreConsulta.getText();
        String idMateria = txtIdMateriaConsulta.getText();
        // crea conexion a la DB
        ConexionDb.Opendb();
        if(idEstudiante.isEmpty() || idMateria.isEmpty()){
            mostrarAlert1();
        }else{
            // Cremos queri de eliminacion
            String eliminar = " DELETE From Estudiantes  WHERE IdEstudiante=" + idEstudiante + " and idMateria=" + idMateria
                    + ";";
            if(ConexionDb.Ejecute(eliminar)){
                clearCon();
            }else{
                mostrarAlert2();
            }
        }
    }

    */
    /*
    public void clear() {
        txtIdNombre.setText("");
        txtNombre.setText("");
        rbtnIdGeneroF.setSelected(false);
        rbtnIdGeneroM.setSelected(false);
        txtIdMateria.setText("");
        txtMateria.setText("");
        txtNota.setText("");
    }

    public void clearCon() {
        txtIdNombreConsulta.setText("");
        txtIdMateriaConsulta.setText("");
        txtNombreCon.setText("");
        rbtnGeneroFCon.setSelected(false);
        rbtnGeneroMCon.setSelected(false);
        txtMateriaCon.setText("");
        txtNotaCon.setText("");
    }

    private void mostrarAlert1() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Alerta");
        alert.setResizable(true);
        alert.setContentText("Por favor llene todos los Campos");
        alert.showAndWait();
    }

    private void mostrarAlert2() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Alerta");
        alert.setResizable(true);
        alert.setContentText(
                "Por favor revise que no aya ingresado un texto en un campo que espera un valor numérico.");
        alert.showAndWait();
    }

    private void mostrarAlertNotReg() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("");
        alert.setHeaderText("Alerta");
        alert.setResizable(true);
        alert.setContentText("El registró a consultar no existe.");
        alert.showAndWait();
    }
    */
}
