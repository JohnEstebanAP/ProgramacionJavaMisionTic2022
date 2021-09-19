public class Estudiante extends Persona{

    double[][]  matrizEstudiantes;
    int cantidadNotas;
    
    public Estudiante(double[][] matrizEstudiantes, int cantidadNotas) {
        this.matrizEstudiantes = matrizEstudiantes;
        this.cantidadNotas = cantidadNotas;
    }

    //cantidad de exámenes que tienen una calificación excelente 
    @Override
    public int contarExcelentes() {
        int cantidadExelentes = 0;
        for(int i = 0 ; i < cantidadNotas ; i++ ){
            if (matrizEstudiantes[i][3] > 90 && matrizEstudiantes[i][3] <= 100){
                cantidadExelentes ++;
            }
        }
        return cantidadExelentes; 
    } 

}
