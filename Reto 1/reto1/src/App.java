import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {           
        String []lista = new String[4];
        String linea = "";
        int cantidadEstudiantes = 0;
        //inicialiso en la variable leer el escaner para capturar las repuestas por teclado
        Scanner leer = new Scanner(System.in);

        //Leemos la cantidad de estudiantes.

        System.out.println("Por favor ingrese la cantidad de estudiantes: ");
        //cantidadEstudiantes = leer.nextInt();
        /**  el orden de las columnas es: nombre, género, materia y calificación,
         *  las columnas están separadas por un espacio. Se recomienda copiar
         */  
        int [][] matrizEstudiantes = new int[cantidadEstudiantes][4];
      //  for(int i = 0 ; i < cantidadEstudiantes; i++ ){
         
       //     System.out.println("siclo " +i);
            System.out.println("Ingresa los datos: ");
            linea = leer.nextLine();      
            lista = linea.split(" ");  
            //System.out.println(lista);
          //  leer.nextInt();  //limpiamos el buffer de teclado
          //  for(int j =0; j < lista.length; j++){
          //     matrizEstudiantes[0][j] = Integer.parseInt(lista[j]);
          //}
      //  }

       // for(int i = 0 ; i < 4; i++ ){
          //  for(int j =0; j < cantidadEstudiantes; j++){
             //   System.out.println(matrizEstudiantes[i][j]);
           //    
           // }
       //}
    }
}
