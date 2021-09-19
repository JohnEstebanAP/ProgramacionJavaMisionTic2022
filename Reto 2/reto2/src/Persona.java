public class Persona {
    double      promedio                    = 0;
    int         cantidadExelentes           = 0;
    double[][]  matrizEstudiantes;
    int         cantidadNotas               = 0;
    public Persona(double[][] matrizEstudiantes, int cantidadNotas) {
        this.matrizEstudiantes = matrizEstudiantes;
        this.cantidadNotas = cantidadNotas;
    }

    public int contarExcelentes(){

    //¿Qué porcentaje de los exámenes fueron Excelentes?
    for(int i = 0 ; i < cantidadNotas ; i++ ){
        if (matrizEstudiantes[i][3] > 90 && matrizEstudiantes[i][3] <= 100){
            cantidadExelentes ++;
        }
    }
    return cantidadExelentes;  
    }

}
