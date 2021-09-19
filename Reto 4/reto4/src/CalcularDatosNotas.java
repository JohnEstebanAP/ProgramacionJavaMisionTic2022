import java.util.List;

public abstract class CalcularDatosNotas {

    // ¿Cuántos de los exámenes tienen una calificación mayor a la del promedio del
    // grupo?
    public static int contarMayoresPromedio(int cantidadNotas, double[] listNotas) {

        double promedio = 0;
        int cantidadNotasMayorPromedio = 0;
        for (int i = 0; i < cantidadNotas; i++) {
            promedio = promedio + listNotas[i];
        }

        promedio = promedio / cantidadNotas;
        for (int i = 0; i < cantidadNotas; i++) {
            if (listNotas[i] > promedio) {
                cantidadNotasMayorPromedio++;
            }
        }
        return cantidadNotasMayorPromedio;
    }

    // ¿Qué porcentaje de los exámenes fueron Excelentes?
    public static double porsentajeExcelentes(int cantidadNotas, double[] listNotas) {
        double porsentajeExcelente = 0;
        for (int i = 0; i < cantidadNotas; i++) {
            if (listNotas[i] > 90 && listNotas[i] <= 100) {
                porsentajeExcelente++;
            }
        }
        porsentajeExcelente = (porsentajeExcelente) / cantidadNotas;
        return porsentajeExcelente;
    }

    // ¿Cuál es la materia con el peor desempeño promedio para todo el grupo?
    public static String promedioMateriaPeor(int cantidadNotas, double[] listNotas, int[] listIdMateria) {

        int contadorMatematicas = 0;
        int contadorInformatica = 0;
        int contadorFisica = 0;
        double promedioMatematicas = 0;
        double promedioInformatica = 0;
        double promedioFisica = 0;

        for (int i = 0; i < cantidadNotas; i++) {
            if (listIdMateria[i] == 1.0) {
                contadorMatematicas++;
                promedioMatematicas = promedioMatematicas + listNotas[i];

            } else if (listIdMateria[i] == 2.0) {
                contadorInformatica++;
                promedioInformatica = promedioInformatica + listNotas[i];

            } else if (listIdMateria[i] == 3.0) {
                contadorFisica++;
                promedioFisica = promedioFisica + listNotas[i];
            }
        }

        promedioMatematicas = promedioMatematicas / contadorMatematicas;
        promedioInformatica = promedioInformatica / contadorInformatica;
        promedioFisica = promedioFisica / contadorFisica;

        double[] vectorPromedios = new double[3];
        vectorPromedios[0] = promedioMatematicas;
        vectorPromedios[1] = promedioInformatica;
        vectorPromedios[2] = promedioFisica;

        double peorDesempenio = vectorPromedios[0];
        int materia = 1;
        String desempenioMaterioP = "matematicas";
        for (int i = 0; i < 3; i++) {
            if (peorDesempenio > vectorPromedios[i]) {
                peorDesempenio = vectorPromedios[i];
                materia = i + 1;
            }
        }

        switch (materia) {
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

    // ¿Cuál es el estudiante con el mejor desempeño para la materia matemáticas?
    public static String estudianteMejorMatematicas(List<Estudiante> listEstudiantes) {
        // Le asignamos un tamaño o dimencion a las Listas.
        int idMateria;
        double nota;

        double notaMayor=0;
        String nomEstudiante = "";

        for (Estudiante estudiante : listEstudiantes) {
            List<Asignatura> listNotas = estudiante.getMateriasNotas();
         
            for (int i = 0; i < listNotas.size(); i++) {                
                nota = listNotas.get(i).getNota();
                idMateria = listNotas.get(i).getIdMateria();
                if (idMateria == 1.0) {
                    if (notaMayor < nota) {
                        notaMayor = nota;
                        nomEstudiante = estudiante.getNombre();
                    }
                }
            }
        }
        return nomEstudiante;
    }

}