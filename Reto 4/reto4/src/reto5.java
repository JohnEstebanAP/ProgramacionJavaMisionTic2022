
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;
import javafx.scene.control.RadioButton;
import javafx.event.ActionEvent;

public class reto5 extends Application {

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
    private ComboBox<String> cbxAsignaturaEst;
    @FXML
    private ComboBox<String> cbxIdAsignaturaEst;
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
    private ComboBox<String> cbxIdAsignaturaPro;
    @FXML
    private ComboBox<String> cbxAsignaturaPro;
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

    static List<Estudiante> listEstudiantes = new ArrayList<Estudiante>();
    static List<Profesor> lisProfesores = new ArrayList<Profesor>();


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader reto4 = new FXMLLoader(getClass().getResource("reto.fxml"));
        Parent root = reto4.load();
        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    private void OnActionlistarIdAsignatura() {
        if (cbxAsignaturaPro.getValue() == null) {
            cbxIdAsignaturaPro.getItems().add("1");
            cbxIdAsignaturaPro.getItems().add("2");
            cbxIdAsignaturaPro.getItems().add("3");
        }
    }

    @FXML
    private void OnActionlistarIdMateria() {
        if (cbxAsignaturaEst.getValue() == null) {
            cbxIdAsignaturaEst.getItems().add("1");
            cbxIdAsignaturaEst.getItems().add("2");
            cbxIdAsignaturaEst.getItems().add("3");
        }

    }

    @FXML
    private void OnActionCargarMateria(ActionEvent event) {
        try {
            int numMateria = (Integer.parseInt(cbxIdAsignaturaEst.getValue()));

            switch (numMateria) {
                case 1:
                    cbxAsignaturaEst.setValue("matematicas");
                    break;
                case 2:
                    cbxAsignaturaEst.setValue("informatica");
                    // txtMateria.setPromptText("informatica");
                    break;
                case 3:
                    cbxAsignaturaEst.setValue("fisica");
                    // txtMateria.setPromptText("fisica");
                    break;
            }
        } catch (Exception e) {

        }
    }

    @FXML
    private void OnActionCargarAsignatura(ActionEvent event) {
        try {
            int numMateria = (Integer.parseInt(cbxIdAsignaturaPro.getValue()));

            switch (numMateria) {
                case 1:
                    cbxAsignaturaPro.setValue("matematicas");
                    break;
                case 2:
                    cbxAsignaturaPro.setValue("informatica");
                    // txtMateria.setPromptText("informatica");
                    break;
                case 3:
                    cbxAsignaturaPro.setValue("fisica");
                    // txtMateria.setPromptText("fisica");
                    break;
            }
        } catch (Exception e) {

        }
    }

    @FXML
    private void OnActionGuardar(ActionEvent event) throws SQLException {
        // crea conexion a la DBs
        // ConexionDb.Opendb();

        String idEstudiante = txtIdEst.getText();
        String nombre = txtNombreEst.getText();
        String apellidos = txtApellidoEst.getText();
        String numTelefono = txtTelefonoEst.getText();
        String edad = txtEdadEst.getText();
        String CC = txtCCEst.getText();
        String nota = txtNotaEst.getText();
        String idMateria = "";
        String materia = "";
        int idGenero = -1;

        if (rbtnIdGeneroFEst.isSelected()) {
            idGenero = 1;
        } else if (rbtnIdGeneroMEst.isSelected()) {
            idGenero = 0;
        }

        if (cbxAsignaturaEst.getValue() != null) {
            materia = cbxAsignaturaEst.getValue();
            idMateria = cbxIdAsignaturaEst.getValue();
        }

        int id = 0;
        long tel = 0;
        int yearsOld = 0;
        long cc = 0;
        double not = 0;
        int idMat = 0;

        if (idEstudiante.isEmpty() || nombre.isEmpty() || apellidos.isEmpty() || numTelefono.isEmpty() || edad.isEmpty()
                || idGenero == -1 || CC.isEmpty() || materia.isEmpty() || nota.isEmpty() || idMateria.isEmpty()) {
            mostrarAlert1();
        } else {
            boolean continuar = false;
            try {
                id = Integer.parseInt(txtIdEst.getText());
                tel = Long.parseLong(txtTelefonoEst.getText());
                yearsOld = Integer.parseInt(txtEdadEst.getText());
                cc = Long.parseLong(txtCCEst.getText());
                not = Double.parseDouble(txtNotaEst.getText());
                idMat = Integer.parseInt(idMateria);
                if (id <= 0 || tel <= 0 || yearsOld <= 0 || yearsOld > 100 || cc <= 0 || not <= 0 || not > 100) {
                    continuar = false;
                    mostrarAlert3();
                }
                continuar = true;
            } catch (Exception e) {
                mostrarAlert2();
            }

            if (continuar) {

                boolean PuedoContinuar = false;
                for (Estudiante estudiante : listEstudiantes) {
                    if (id == estudiante.getIdEstudiante()) {
                        PuedoContinuar = true;
                    }
                }

                if (PuedoContinuar) {
                    for (Estudiante estudiante : listEstudiantes) {
                        if (id == estudiante.getIdEstudiante()) {
                            Asignatura materiasNotas = new Asignatura(idMat, materia, not);
                            estudiante.setMateriasNotas(materiasNotas);
                            limpiarEstudiante();
                        }
                    }
                } else {
                    Estudiante estudiante = new Estudiante(id, nombre, apellidos, tel, cc, yearsOld, idGenero);
                    listEstudiantes.add(estudiante);

                    Asignatura materiasNotas = new Asignatura(idMat, materia, not);
                    estudiante.setMateriasNotas(materiasNotas);
                    limpiarEstudiante();
                }
            }
        }

        // Insertamos los datos
        /*
         * String insertar =
         * "INSERT INTO Estudiantes (nombre,IdEstudiante,idGenero,materia,idMateria,Nota) VAlUES("
         * + "'" + nombre + "'" + "," + idNombre + "," + idGenero + "," + "'" + materia
         * + "'" + "," + idMateria + "," + nota + ");";
         * 
         * if (idNombre.isEmpty() || nombre.isEmpty() || apellidos.isEmpty() ||
         * numTelefono.isEmpty() || edad.isEmpty() || idGenero.isEmpty() || CC.isEmpty()
         * || materia.isEmpty() || nota.isEmpty()) { mostrarAlert1(); } //++++++
         * Ejecutmos instruccion de insert en la BD +++++/ else if
         * (ConexionDb.Ejecute(insertar)) { System.out.println("insercion del registro "
         * + insertar + "exitoso"); clear(); } else {
         * System.err.println("Error en la inserción del registro en la base de datos");
         * mostrarAlert2(); }
         */
    }

    @FXML
    private void OnActionLlenadoAutomaticoEstudiante(KeyEvent event) {

        if(txtIdEst.getText().isEmpty()){
            //Significa que el campo esta basido pero no copiamos ningun error para no generar problemas al usiario
        }else{
            int id = Integer.parseInt(txtIdEst.getText());
        boolean Puedocontinuar = false;
        for (Estudiante estudiante : listEstudiantes) {
            if (id == estudiante.getIdEstudiante()) {
                Puedocontinuar = true;
            }
        }

        if (Puedocontinuar) {
            for (Estudiante estudiante : listEstudiantes) {
                if (id == estudiante.getIdEstudiante()) {
                    txtNombreEst.setText(estudiante.getNombre());
                    txtApellidoEst.setText(estudiante.getApellidos());
                    txtEdadEst.setText(estudiante.getEdad() + "");
                    txtCCEst.setText(estudiante.getDocumentoIdentidad() + "");
                    cbxIdAsignaturaEst.setValue(null);
                    cbxAsignaturaEst.setValue(null);
                    txtNotaEst.setText("");
                    txtTelefonoEst.setText(estudiante.getNumeroTelefonico() + "");

                    if (estudiante.getIdGenero() == 0) {
                        rbtnIdGeneroMEst.setSelected(true);
                    } else {
                        rbtnIdGeneroFEst.setSelected(true);
                    }
                } 
            }
        }else{
            txtNombreEst.setText("");
            txtApellidoEst.setText("");
            txtEdadEst.setText("");
            txtCCEst.setText("");
            cbxIdAsignaturaEst.setValue(null);
            cbxAsignaturaEst.setValue(null);
            txtNotaEst.setText("");
            txtTelefonoEst.setText("");
            rbtnIdGeneroFEst.setSelected(false);
            rbtnIdGeneroMEst.setSelected(false);
        }
        }
    }

    @FXML
    public void onActionAutoDectetaProfesor(KeyEvent event) {
        int id = Integer.parseInt(txtIdNombrePro.getText());
        for (Profesor profesor : lisProfesores) {
            if (id == profesor.getIdProfesor()) {
                mostrarAlertProfesor();
            }
        }
    }

    @FXML
    private void OnActionGuardarProfesor(ActionEvent event) throws SQLException {
        // crea conexion a la DBs
        // ConexionDb.Opendb();

        String ID = txtIdNombrePro.getText();
        String nombre = txtNombrePro.getText();
        String apellidos = txtApellidoPro.getText();
        String numTelefono = txtTelefonoPro.getText();
        String edad = txtEdadPro.getText();
        String CC = txtCCpro.getText();

        String idMateria = "";
        String materia = "";
        int idGenero = -1;

        if (rbtnIdGeneroFPro.isSelected()) {
            idGenero = 1;
        } else if (rbtnIdGeneroMpro.isSelected()) {
            idGenero = 0;
        }

        if (cbxAsignaturaPro.getValue() != null) {
            materia = cbxAsignaturaPro.getValue();
            idMateria = cbxIdAsignaturaPro.getValue();
        }

        int id = 0;
        long tel = 0;
        int yearsOld = 0;
        long cc = 0;
        int idMat = 0;

        if (ID.isEmpty() || nombre.isEmpty() || apellidos.isEmpty() || numTelefono.isEmpty() || edad.isEmpty()
                || idGenero == -1 || CC.isEmpty() || materia.isEmpty() || idMateria.isEmpty()) {
            mostrarAlert1();
        } else {
            boolean continuar = false;
            try {
                id = Integer.parseInt(txtIdNombrePro.getText());
                tel = Long.parseLong(txtTelefonoPro.getText());
                yearsOld = Integer.parseInt(txtEdadPro.getText());
                cc = Long.parseLong(txtCCpro.getText());
                idMat = Integer.parseInt(idMateria);
                if (id <= 0 || tel <= 0 || yearsOld <= 0 || yearsOld > 100 || cc <= 0) {
                    continuar = false;
                    mostrarAlert3();
                }
                continuar = true;
            } catch (Exception e) {
                mostrarAlert2();
            }
            if (continuar) {
                boolean PuedoContinuar = true;
                for (Profesor profesor : lisProfesores) {
                    if (id == profesor.getIdProfesor()) {
                        PuedoContinuar = false;
                    }
                }

                if (PuedoContinuar) {
                    Profesor profesor = new Profesor(id, idMat, materia, nombre, apellidos, tel, cc, yearsOld,
                            idGenero);
                    lisProfesores.add(profesor);
                    limpiarProfesor();
                } else {
                    mostrarAlertProfesor();
                }
            }
        }
    }

    @FXML
    private void OnActionConsultarProfesores(ActionEvent event) {
        txtAreaDatosPro.setText("");
        for (Profesor profesor : lisProfesores) {
            txtAreaDatosPro.appendText("id: " + profesor.getIdProfesor() + "    Nombre: " + profesor.getNombre()
                    + "    Apellidos: " + profesor.getApellidos() + "     Edad: " + profesor.getEdad()
                    + "    Id.Asignatura:" + profesor.getIdAsignatura() + "      Asignatura: "
                    + profesor.getNombreAsignatura() + "\n\n");
        }
    }

    @FXML
    private void OnActionConsultarMateriaProfesor(ActionEvent event) {
        txtAreaDatosConPro.setText("");
        if (txtIdConsultaPro.getText().isEmpty()) {
            mostrarAlert1();
        } else {
            try {
                int id = Integer.parseInt(txtIdConsultaPro.getText());
                if (id <= 0) {
                    mostrarAlert3();
                } else {
                    boolean PuedoContinuar = false;
                    for (Profesor profesor : lisProfesores) {
                        if (id == profesor.getIdProfesor()) {
                            PuedoContinuar = true;
                        }
                    }

                    if (PuedoContinuar) {
                        for (Profesor profesor : lisProfesores) {
                            if (id == profesor.getIdProfesor()) {
                                txtAreaDatosConPro.appendText("id: " + profesor.getIdProfesor() + "    \nNombre: "
                                        + profesor.getNombre() + "    \nApellidos: " + profesor.getApellidos()
                                        + "    \nId.Asignatura:" + profesor.getIdAsignatura() + "      \nAsignatura: "
                                        + profesor.getNombreAsignatura() + "\n\n");
                            }
                        }
                    } else {
                        txtAreaDatosConPro.appendText("No se tiene registrado ningun profesor con este id: " + id);
                        mostrarAlertNotReg();
                    }
                }
            } catch (NumberFormatException e) {
                mostrarAlert2();
            }
        }
    }

    @FXML
    private void OnActionObtenerDatos(ActionEvent event) throws SQLException {
        txtAreaDatos.setText("");

        for (int i = 0; i < listEstudiantes.size(); i++) {
            Estudiante estudiante = listEstudiantes.get(i);

            List<Asignatura> notas = estudiante.getMateriasNotas();
            for (int j = 0; j < notas.size(); j++) {
                Asignatura nota = notas.get(j);
                String texto = estudiante.getIdEstudiante() + " - " + estudiante.getNombre() + " - "
                        + estudiante.getApellidos() + " -Edad: " + estudiante.getEdad() + " -CC: "
                        + estudiante.getDocumentoIdentidad() + " - Materia :" + nota.imprimirNotas();
                txtAreaDatos.appendText(texto + "\n\n");
            }
        }

        /*
         * // abrir base de Datos ConexionDb.Opendb(); // Crear query Sql para ejecutar
         * String query = "SELECT * FROM Estudiantes;"; // Ejecutamos instruciones SQL
         * de Consulta en la ConexionDb ConexionDB.Consulta(query); String sql=
         * "SELECT * FROM Productos;";
         * 
         * //ResultSet reg = ConexionDb.Consulta(query);// ejecutamos la consulta try {
         * while (reg.next()) { // recorre cada fila String genero; if
         * (reg.getString("idGenero").equals("0")) { genero = "M"; } else { genero =
         * "F"; } txtAreaDatos.appendText("id: " + reg.getString("id") + "    Nombre: "
         * + reg.getString("nombre") + "     idEstudiante: " +
         * reg.getString("IdEstudiante") + "     Genero: " + genero + "      Materia: "
         * + reg.getString("Materia") + "       IdMateria: " +
         * reg.getString("idMateria") + "   Nota: " + reg.getString("Nota") + "\n");
         * 
         * } // endWhile } catch (SQLException e) { System.err.println("Error consulta "
         * + e.getMessage()); } // catch
         */
    }

    @FXML
    private void OnActionProcesar(ActionEvent event) throws SQLException {

        txtAreaDatosProcesados.setText("");// Limpiamos el textFieldArea
        // Calculamos la cantidad de notas
        int cantidadNotas = 0;
        for (Estudiante estudiante : listEstudiantes) {
            List<Asignatura> listNotas = estudiante.getMateriasNotas();
            for (int i = 0; i < listNotas.size(); i++) {
                cantidadNotas++;
            }
        }
        // Le asignamos un tamaño o dimencion a las Listas.
        double[] ListNotas = new double[cantidadNotas];
        int[] listIdMateria = new int[cantidadNotas];
        int contador = 0;
        for (Estudiante estudiante : listEstudiantes) {
            List<Asignatura> listNotas = estudiante.getMateriasNotas();

            for (int i = 0; i < listNotas.size(); i++) {
                ListNotas[contador] = listNotas.get(i).getNota();
                listIdMateria[contador] = listNotas.get(i).getIdMateria();
                contador++;
            }
        }

        // ¿Cuántos de los exámenes tienen una calificación mayor a la del promedio del
        // grupo?
        txtAreaDatosProcesados.appendText("# exámenes con calificación mayor al promedio: \n"
                + CalcularDatosNotas.contarMayoresPromedio(cantidadNotas, ListNotas) + "\n");

        // ¿Qué porcentaje de los exámenes fueron Excelentes?
        String excelentes = String.format("%.2f", CalcularDatosNotas.porsentajeExcelentes(cantidadNotas, ListNotas));
        txtAreaDatosProcesados.appendText("% exámenes excelentes: \n" + excelentes + "\n");

        // ¿Cuál es la materia con el peor desempeño promedio para todo el grupo?
        txtAreaDatosProcesados.appendText("MateriaPeor desempeño promedio: \n"
                + CalcularDatosNotas.promedioMateriaPeor(cantidadNotas, ListNotas, listIdMateria) + "\n");

        // ¿Cuál es el estudiante con el mejor desempeño para la materia matemáticas?
        txtAreaDatosProcesados.appendText("Estudiante con Mejor desempeño en Matemáticas: \n"
                + CalcularDatosNotas.estudianteMejorMatematicas(listEstudiantes) + "\n");
    }

    @FXML
    void OnActionConsultar(ActionEvent event) throws SQLException {
        String IdEstudiante = txtIdNombreConsulta.getText();
        String IdMateria = txtIdMateriaConsulta.getText();

        if (IdEstudiante.isEmpty() || IdMateria.isEmpty()) {
            mostrarAlert1();
        } else {
            try {

                int idEstudiante = Integer.parseInt(txtIdNombreConsulta.getText());
                int idMateria = Integer.parseInt(txtIdMateriaConsulta.getText());

                // verifico que la consulta si tenga contenido si no se muestra una alerta y se
                // limpian los campos.
                if (idEstudiante <= 0) {
                    mostrarAlert3();
                } else {
                    boolean PuedoContinuar = false;
                    for (Estudiante estudiante : listEstudiantes) {
                        if (idEstudiante == estudiante.getIdEstudiante()) {
                            PuedoContinuar = true;
                        }
                    }

                    if (PuedoContinuar) {
                        for (Estudiante estudiante : listEstudiantes) {
                            if (idEstudiante == estudiante.getIdEstudiante()) {
                                List<Asignatura> asignaturas = estudiante.getMateriasNotas();
                                boolean puedoContinuar = false;
                                for (Asignatura asignatura : asignaturas) {
                                    if (idMateria == asignatura.getIdMateria()) {
                                        puedoContinuar = true;
                                    }
                                }
                                if (puedoContinuar) {
                                    for (Asignatura asignatura : asignaturas) {
                                        if (idMateria == asignatura.getIdMateria()) {
                                            // Recorremos el resultado de la consulta y se lo asignamos a los campos de
                                            // TextField
                                            txtNombreCon.setText(estudiante.getNombre());
                                            txtMateriaCon.setText(asignatura.getNombre());
                                            txtNotaCon.setText(asignatura.getNota() + "");
                                            int idGenero = estudiante.getIdGenero();
                                            if (idGenero == 0) {
                                                rbtnGeneroMCon.setSelected(true);
                                            } else {
                                                rbtnGeneroFCon.setSelected(true);
                                            }
                                            txtAreaConEst.setText(
                                                    "cantidad de exámenes que tienen una calificación excelente: "
                                                            + estudiante.contarExcelentes());

                                        }
                                    }
                                } else {
                                    mostrarAlertNotReg();
                                }
                            }
                        }
                    } else {
                        mostrarAlertNotReg();
                    }
                }

            } catch (NullPointerException e) {
                // System.err.println("tiene letras en lo campos numericos id.Nombre o
                // id.Materia: " + e.getMessage());
                mostrarAlert2();
            }
        }
    }

    /*
     * @FXML private void OnActionEditar(ActionEvent event) throws SQLException {
     * String idEstudiante = txtIdNombreConsulta.getText(); String idMateria =
     * txtIdMateriaConsulta.getText(); String nombre = txtNombreCon.getText();
     * String idGenero = ""; try { int numMateria = (Integer.parseInt(idMateria));
     * switch (numMateria) { case 1: txtMateriaCon.setText("matematicas");
     * txtMateriaCon.setPromptText("matematicas"); break; case 2:
     * txtMateriaCon.setText("informatica");
     * txtMateriaCon.setPromptText("informatica"); break; case 3:
     * txtMateriaCon.setText("fisica"); txtMateriaCon.setPromptText("fisica");
     * break; } } catch (Exception e) {
     * 
     * }
     * 
     * String materia = txtMateriaCon.getText(); String nota = txtNotaCon.getText();
     * if (rbtnGeneroMCon.isSelected()) { idGenero = "0"; } if
     * (rbtnGeneroFCon.isSelected()) { idGenero = "1"; } // crea conexion a la DB
     * ConexionDb.Opendb(); // Cremos queri de eliminacion String editar =
     * "UPDATE Estudiantes SET nombre='" + nombre + "', idGenero=" + idGenero +
     * ", materia='" + materia + "',Nota=" + nota + " WHERE IdEstudiante=" +
     * idEstudiante + " and idMateria=" + idMateria + ";";
     * 
     * if (idEstudiante.isEmpty() || nombre.isEmpty() || idGenero.isEmpty() ||
     * idMateria.isEmpty() || materia.isEmpty() || nota.isEmpty()) {
     * mostrarAlert1(); } else { if (ConexionDb.Ejecute(editar)) { clearCon(); } } }
     * 
     * @FXML private void OnActionEliminar(ActionEvent event) throws SQLException {
     * String idEstudiante = txtIdNombreConsulta.getText(); String idMateria =
     * txtIdMateriaConsulta.getText(); // crea conexion a la DB ConexionDb.Opendb();
     * if (idEstudiante.isEmpty() || idMateria.isEmpty()) { mostrarAlert1(); } else
     * { // Cremos queri de eliminacion String eliminar =
     * " DELETE From Estudiantes  WHERE IdEstudiante=" + idEstudiante +
     * " and idMateria=" + idMateria + ";"; if (ConexionDb.Ejecute(eliminar)) {
     * clearCon(); } else { mostrarAlert2(); } } }
     */
    public void limpiarEstudiante() {
        txtIdEst.setText("");
        txtNombreEst.setText("");
        txtApellidoEst.setText("");
        txtEdadEst.setText("");
        txtCCEst.setText("");
        cbxIdAsignaturaEst.setValue(null);
        cbxAsignaturaEst.setValue(null);
        txtNotaEst.setText("");
        txtTelefonoEst.setText("");
        rbtnIdGeneroFEst.setSelected(false);
        rbtnIdGeneroMEst.setSelected(false);
    }

    public void limpiarProfesor() {
        txtIdNombrePro.setText("");
        txtNombrePro.setText("");
        txtApellidoPro.setText("");
        txtTelefonoPro.setText("");
        txtEdadPro.setText("");
        txtCCpro.setText("");
        cbxIdAsignaturaPro.setValue(null);
        cbxAsignaturaPro.setValue(null);
        rbtnIdGeneroFPro.setSelected(false);
        rbtnIdGeneroMpro.setSelected(false);
    }

    /*
     * public void clearCon() { txtIdNombreConsulta.setText("");
     * txtIdMateriaConsulta.setText(""); txtNombreCon.setText("");
     * rbtnGeneroFCon.setSelected(false); rbtnGeneroMCon.setSelected(false);
     * txtMateriaCon.setText(""); txtNotaCon.setText(""); }
     */
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

    private void mostrarAlert3() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Alerta");
        alert.setResizable(true);
        alert.setContentText("Por favor revise que no aya ingresado un numero negativo o invalido.");
        alert.showAndWait();
    }

    private void mostrarAlertProfesor() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("");
        alert.setHeaderText("Alerta");
        alert.setResizable(true);
        alert.setContentText("El Id del profesor ya tiene una Materia Asignada");
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
}
