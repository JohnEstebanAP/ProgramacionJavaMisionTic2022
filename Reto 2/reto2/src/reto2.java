/**  Reto 2
 * 
 * creado por John Esteban Alvarez Piedrahita
 * Identificado con la cedula de ciudadania numero:
 * 1017272663.
 */
import java.util.Scanner;
public class reto2 {
    public static void main(String[] args) {
        
        String []   lista                       = new String[4];
        double[][]  matrizEstudiantes           = new double[100][4];
        String      linea                       ="";
        int         cantidadNotas               = 0;
        double      promedio                    = 0;
        int         cantidadNotasMayorPromedio  = 0;
        double      porsentajeExcelente         = 0;
        int         contadorMatematicas         = 0;
        int         contadorInformatica         = 0;
        int         contadorFisica              = 0;
        double      promedioMatematicas         = 0;
        double      promedioInformatica         = 0;
        double      promedioFisica              = 0;
      

        //inicialiso en la variable leer el escaner para capturar las repuestas por teclado
        Scanner leer = new Scanner(System.in);

        //Leemos la cantidad de Notas.
        cantidadNotas = Integer.parseInt(leer.nextLine());
        /**  el orden de las columnas es: nombre, género, materia y calificación,
         *  las columnas están separadas por un espacio. Se recomienda copiar
         */  
       
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

        // ¿Cuántos de los exámenes tienen una calificación mayor a la del promedio del grupo?
        for(int i = 0 ; i < cantidadNotas ; i++ ){
            promedio = promedio + matrizEstudiantes[i][3];
            }
     
            promedio = promedio / cantidadNotas;
            for(int i = 0 ; i < cantidadNotas ; i++ ){
                if (matrizEstudiantes[i][3] > promedio){
                    cantidadNotasMayorPromedio++;
                }
            }
        // System.out.println("promedio "+promedio);
            System.out.println(cantidadNotasMayorPromedio);
       
        //¿Qué porcentaje de los exámenes fueron Excelentes?
        for(int i = 0 ; i < cantidadNotas ; i++ ){
            if (matrizEstudiantes[i][3] > 90 && matrizEstudiantes[i][3] <= 100){
                porsentajeExcelente ++;
            }
        }
        porsentajeExcelente = (porsentajeExcelente)/cantidadNotas;
        System.out.printf("%.2f\n", porsentajeExcelente);

     

        //¿Cuál es la materia con el peor desempeño promedio para todo el grupo?
        for(int i = 0 ; i < cantidadNotas ; i++ ){
            if (matrizEstudiantes[i][2] == 1.0){
                contadorMatematicas++;
                promedioMatematicas = promedioMatematicas + matrizEstudiantes[i][3];
           
            }else if(matrizEstudiantes[i][2] == 2.0){
                contadorInformatica++;
                promedioInformatica = promedioInformatica + matrizEstudiantes[i][3];
           
            }else if(matrizEstudiantes[i][2] == 3.0){
                contadorFisica++;
                promedioFisica      = promedioFisica      + matrizEstudiantes[i][3];
            
            }
        }

        promedioMatematicas     = promedioMatematicas  / contadorMatematicas;
        promedioInformatica     = promedioInformatica  / contadorInformatica;
        promedioFisica          = promedioFisica       / contadorFisica;

        double [] vectorPromedios = new double[3];
        vectorPromedios[0] = promedioMatematicas;
        vectorPromedios[1] = promedioInformatica;
        vectorPromedios[2] = promedioFisica;

        double peorDesempenio = vectorPromedios[0];
        int materia = 1;
        String desempenioMaterioP = "matematicas";
        for(int i = 0; i < 3; i++){
            if( peorDesempenio > vectorPromedios[i]){
                peorDesempenio = vectorPromedios[i];
                materia = i+1;
            }
        }

        switch(materia){
            case 1:
                desempenioMaterioP = "matematicas";
                break;
            case 2:
                desempenioMaterioP = "informatica";
                break;
            case 3:
                desempenioMaterioP = "fisica";
                break;
        }

        System.out.println(desempenioMaterioP);


        //¿Cuál es el estudiante con el mejor desempeño para la materia matemáticas?
    
        double notaMayor = 0;
        int numEstudiante = 0;
        for(int i = 0 ; i < cantidadNotas ; i++ ){
            if(matrizEstudiantes[i][2] == 1.0){
                if(notaMayor < matrizEstudiantes[i][3]){
                    notaMayor = matrizEstudiantes[i][3];
                    numEstudiante = (int)matrizEstudiantes[i][0];
                }
            }
        }

        String nomEstudainte ="";
        switch(numEstudiante){
            case 1:
                nomEstudainte = "armando";
                break;
            case 2:
                nomEstudainte = "nicolas";
                break;
            case 3:
                nomEstudainte = "daniel";
                break;
            case 4:
                nomEstudainte = "maria";
                break;
            case 5:
                nomEstudainte = "marcela";
                break;
            case 6:
                nomEstudainte = "alexandra";
                break;
        }

        //System.out.println("nomta mayor "+ notaMayor);
        System.out.println(nomEstudainte);


        //**********************Implementación de la instancia Persona***********************/
        Persona persona = new Persona(matrizEstudiantes,cantidadNotas);
        persona.contarExcelentes();
       //***********************************************************************************/

    }

}



