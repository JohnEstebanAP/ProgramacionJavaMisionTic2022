/**  Reto 3 
 * creado por John Esteban Alvarez Piedrahita
 * Identificado con la cedula de ciudadania numero:
 * 1017272663.
 */

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import java.util.Scanner;

public class reto3{
/*    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtGenero;
    @FXML
    private TextField txtMateria;
    @FXML
    private TextField txtNota;
    @FXML
    private Button btnProcesar;
    @FXML
    private Button btnIngresar;
    @FXML
    private TextArea txtAreaEntrada;
    @FXML
    private TextArea txtAreaSalida;
*/
    static String []   lista                       = new String[4];
    static double[][]  matrizEstudiantes           = new double[100][4];
    static int itemMatriz=0;

    public static void main(String[] args) throws Exception{
        //launch(args);
   
        String linea;
        int cantidadNotas;
        
        //inicialiso en la variable leer el escaner para capturar las repuestas por teclado
        Scanner leer = new Scanner(System.in);

        //Leemos la cantidad de Notas.
        cantidadNotas = Integer.parseInt(leer.nextLine());
        //  el orden de las columnas es: nombre, género, materia y calificación,
        //  las columnas están separadas por un espacio. Se recomienda copiar
           
       
        for(int i = 0 ; i < cantidadNotas; i++ ){
          //  System.out.println("siclo " +i);
          //  System.out.println("Ingresa los datos: ");
            linea = leer.nextLine();      
            lista = linea.split(" ");  
            //  leer.nextInt();  //limpiamos el buffer de teclado
            for(int j =0; j < lista.length; j++){
                matrizEstudiantes[i][j] = Double.parseDouble(lista[j]);
            }
        }


        //**********************Implementación de la instancia Estudiante***********************/
        Estudiante estudiante = new Estudiante(matrizEstudiantes,cantidadNotas);
        //cantidad de exámenes que tienen una calificación excelente 
        estudiante.contarExcelentes();
        //**************************************************************************************/
    
        // ¿Cuántos de los exámenes tienen una calificación mayor a la del promedio del grupo?
        System.out.println(estudiante.contarMayoresPromedio());
       
        //¿Qué porcentaje de los exámenes fueron Excelentes?
        System.out.printf("%.2f\n", estudiante.porsentajeExcelentes());

        //¿Cuál es la materia con el peor desempeño promedio para todo el grupo?
        System.out.println(estudiante.promedioMateriaPeor());
 
        //¿Cuál es el estudiante con el mejor desempeño para la materia matemáticas?
        System.out.println(estudiante.estudiantePeorMatematicas());

    }
/*
    @Override
    public void start(Stage primaryStage) throws Exception {
        
            FXMLLoader reto3 = new FXMLLoader(getClass().getResource("reto3.fxml"));
            Parent root = reto3.load();
            Scene scene = new Scene(root);

            primaryStage.setScene(scene);
            primaryStage.show();
    }
*/
/*
    @FXML
    private void OnActionIngresar(ActionEvent event){

        String nombre = txtNombre.getText();
        String genero = txtGenero.getText();
        String materia = txtMateria.getText();
        String nota = txtNota.getText();


        if(nombre.isEmpty() || genero.isEmpty() || materia.isEmpty() || nota.isEmpty()){

        }else{
            lista[0] = nombre;
            lista[1] = genero;
            lista[2] = materia;
            lista[3] = nota;
    
            for(int j =0; j < lista.length; j++){
                matrizEstudiantes[itemMatriz][j] = Double.parseDouble(lista[j]);
                    
            }
            for(int i = 0; i < lista.length; i++){         
                txtAreaEntrada.appendText((matrizEstudiantes[itemMatriz][i])+" ");
            }
            txtAreaEntrada.appendText("\n");    
            itemMatriz ++;  
            clear();
        }
    }
*/
/*
    @FXML
    private void OnActionProcesar(ActionEvent event){
                txtAreaSalida.setText("");//Limpiamos el textFieldArea
                int cantidadNotas= itemMatriz; //itemMatriz tiene la cantidad de notas ingresadas en la matriz

                //Implementación de la instancia Estudiante
                Estudiante estudiante = new Estudiante(matrizEstudiantes,cantidadNotas);
                estudiante.contarExcelentes();
                
                // ¿Cuántos de los exámenes tienen una calificación mayor a la del promedio del grupo?
                txtAreaSalida.appendText(estudiante.contarMayoresPromedio()+"\n");
              
                //¿Qué porcentaje de los exámenes fueron Excelentes?
                String excelentes = String.format("%.2f",estudiante.porsentajeExcelentes());
                txtAreaSalida.appendText(excelentes+"\n");
    
                //¿Cuál es la materia con el peor desempeño promedio para todo el grupo?
                txtAreaSalida.appendText(estudiante.promedioMateriaPeor()+"\n");
         
                //¿Cuál es el estudiante con el mejor desempeño para la materia matemáticas?
                txtAreaSalida.appendText(estudiante.estudiantePeorMatematicas()+"\n");
    }
*/ /*
    public void clear(){
        txtNombre.setText("");
        txtGenero.setText("");
        txtMateria.setText("");
        txtNota.setText("");
    }
    */
}



