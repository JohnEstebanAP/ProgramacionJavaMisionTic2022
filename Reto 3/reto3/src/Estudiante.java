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


    // ¿Cuántos de los exámenes tienen una calificación mayor a la del promedio del grupo?
    public int contarMayoresPromedio(){
        double promedio = 0;   
        int cantidadNotasMayorPromedio = 0;
        for(int i = 0 ; i < cantidadNotas ; i++ ){
            promedio = promedio + matrizEstudiantes[i][3];
            }
         
            promedio = promedio / cantidadNotas;
            for(int i = 0 ; i < cantidadNotas ; i++ ){
                if (matrizEstudiantes[i][3] > promedio){
                    cantidadNotasMayorPromedio++;
                }
            }
        return cantidadNotasMayorPromedio;
    }


    //¿Qué porcentaje de los exámenes fueron Excelentes?
    public double porsentajeExcelentes(){
        double porsentajeExcelente = 0;
        for(int i = 0 ; i < cantidadNotas ; i++ ){
            if (matrizEstudiantes[i][3] > 90 && matrizEstudiantes[i][3] <= 100){
                porsentajeExcelente ++;
            }
        }
        porsentajeExcelente = (porsentajeExcelente)/cantidadNotas;
        return porsentajeExcelente;
    } 

    
    //¿Cuál es la materia con el peor desempeño promedio para todo el grupo?
    public String promedioMateriaPeor(){
        int         contadorMatematicas = 0;
        int         contadorInformatica = 0;
        int         contadorFisica = 0;
        double      promedioMatematicas = 0;
        double      promedioInformatica = 0;
        double      promedioFisica = 0;

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

        return desempenioMaterioP;
    }


    //¿Cuál es el estudiante con el mejor desempeño para la materia matemáticas?
    public String estudiantePeorMatematicas(){
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

        return nomEstudainte;
    }
}
