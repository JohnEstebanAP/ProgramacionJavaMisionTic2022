import java.sql.SQLException;
import java.sql.ResultSet;

public class Estudiante extends Persona {

    private int idEstudiante;
    private double[][] idMateriasNotas;
    private int cantidadNotas;

    private double[] listNotas;
    private double[] listIdMateria;
    private String[] listNombreEstudiante;

/*
    public void Estudiante(int idEstudiante, int idGenero, double[][] idMateriasNotas, int cantidadNotas, S
    tring nombre, String apellidos, long numeroTelefonico, long documentoIdentidad, int edad) {
      
        super(nombre, apellidos, numeroTelefonico, documentoIdentidad, edad);
        this.idEstudiante = idEstudiante;
        this.idGenero = idGenero;
        this.idMateriasNotas = idMateriasNotas;
        this.cantidadNotas = cantidadNotas;
    }*/

    // cantidad de exámenes que tienen una calificación excelente
    public int contarExcelentes() {
        int cantidadExelentes = 0;
        for (int i = 0; i < cantidadNotas; i++) {
            if (idMateriasNotas[i][1] > 90 && idMateriasNotas[i][1] <= 100) {
                cantidadExelentes++;
            }
        }
        return cantidadExelentes;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public void setIdMateriaNotas(double [][] idMateriasNotas) {
        this.idMateriasNotas = idMateriasNotas;
    }

    public void setCantidadNotas(int cantidadNotas) {
        this.cantidadNotas = cantidadNotas;
    }


    public int getIdEstudiante() {
        return idEstudiante;
    }


    public double[][] getIdMateriasNotas() {
        return idMateriasNotas;
    }

    public int getCantidadNotas() {
        return cantidadNotas;
    }



    
    // ¿Cuántos de los exámenes tienen una calificación mayor a la del promedio del
    // grupo?
    public int contarMayoresPromedio() throws SQLException {
        // crea conexion a la DB
        ConexionDb.Opendb();

        // Consultamos la cantidad de elemntos o de notas reguistradas
        String query = "SELECT count(id) FROM Estudiantes;";
        ResultSet reg = ConexionDb.Consulta(query);// ejecutamos la consulta
        try {
            listNotas = new double[(int) reg.getDouble("count(id)")];
            listIdMateria = new double[(int) reg.getDouble("count(id)")];
            listNombreEstudiante = new String[(int) reg.getDouble("count(id)")];
            // listNomMateria = new String[(int) reg.getDouble("count(id)")];
        } catch (SQLException e) {
            System.err.println("Error consulta " + e.getMessage());
        } // catch

        // Crear query Sql para ejecutar
        query = "SELECT Nota FROM Estudiantes;";
        // Ejecutamos instruciones SQL de Consulta en la ConexionDb
        // ConexionDB.Consulta(query);
        // String sql= "SELECT * FROM Productos;";

        reg = ConexionDb.Consulta(query);// ejecutamos la consulta
        try {
            cantidadNotas = 0;
            while (reg.next()) {
                // recorre cada fila
                listNotas[cantidadNotas] = reg.getDouble("Nota");
                cantidadNotas++;
            } // endWhile
        } catch (SQLException e) {
            System.err.println("Error consulta " + e.getMessage());
        } // catch

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
    public double porsentajeExcelentes() {
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
    public String promedioMateriaPeor() throws SQLException {
        // abrir base de Datos
        ConexionDb.Opendb();
        // Crear query Sql para ejecutar
        String query = "SELECT idMateria,materia,Nota,nombre FROM Estudiantes;";
        // Ejecutamos instruciones SQL de Consulta en la ConexionDb
        // ConexionDB.Consulta(query);
        // String sql= "SELECT * FROM Productos;";

        ResultSet reg = ConexionDb.Consulta(query);// ejecutamos la consulta
        try {
            cantidadNotas = 0;
            while (reg.next()) {
                // recorre cada fila
                listIdMateria[cantidadNotas] = reg.getDouble("idMateria");
                // listNomMateria[cantidadNotas] = reg.getString("materia");
                listNotas[cantidadNotas] = reg.getDouble("Nota");
                listNombreEstudiante[cantidadNotas] = reg.getString("nombre");

                cantidadNotas++;
            } // endWhile
        } catch (SQLException e) {
            System.err.println("Error consulta " + e.getMessage());
        } // catch

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
    public String estudianteMejorMatematicas() {
        double notaMayor = listNotas[0];
        String nomEstudiante = listNombreEstudiante[0];

        for (int i = 0; i < cantidadNotas; i++) {
            if (listIdMateria[i] == 1.0) {
                if (notaMayor < listNotas[i]) {
                    notaMayor = listNotas[i];
                    nomEstudiante = listNombreEstudiante[i];
                }
            }
        }
        return nomEstudiante;
    }
}
