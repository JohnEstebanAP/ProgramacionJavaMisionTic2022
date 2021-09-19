import javafx.scene.paint.Material;

public class Asignatura {
    
    private int idMateria;
    private String nombre;
    private double nota;

    Asignatura(int idMateria, String nombre, double nota){
        this.idMateria=idMateria;
        this.nombre=nombre;
        this.nota = nota;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setNota(double nota) {
        this.nota = nota;
    }

    public int getIdMateria() {
        return idMateria;
    }

    public String getNombre() {
        return nombre;
    }
    public double getNota() {
        return nota;
    }

    public String imprimirNotas(){
        return ("Id.Materia: "+idMateria+" "+nombre+" Nota: "+nota);
    }
}
