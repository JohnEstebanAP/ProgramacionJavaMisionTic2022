import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

public class Estudiante extends Persona {

    private int idEstudiante;
    private List<Asignatura> materiasNotas = new ArrayList<Asignatura>();


    public Estudiante(int idEstudiante, String nombre, String apellidos, long numeroTelefonico,
            long documentoIdentidad, int edad, int idGenero) {
        super(nombre, apellidos, numeroTelefonico, documentoIdentidad, edad, idGenero);
        this.idEstudiante = idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public void setMateriasNotas(Asignatura materiasNotas) {
        this.materiasNotas.add(materiasNotas);
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public List<Asignatura> getMateriasNotas() {
        return materiasNotas;
    }

    // cantidad de exámenes que tienen una calificación excelente
    public int contarExcelentes() {
        int cantidadExelentes = 0;
        for (Asignatura asignatura : materiasNotas) {
                if (asignatura.getNota() > 90 && asignatura.getNota() <= 100) {
                    cantidadExelentes++;
                }
        }
        return cantidadExelentes;
    }
    
}
