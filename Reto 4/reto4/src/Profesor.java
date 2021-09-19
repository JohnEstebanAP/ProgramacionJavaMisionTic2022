public class Profesor extends Persona {

    private int idProfesor;
    private int idAsignatura;
    private String nombreAsignatura;

    public Profesor(int idProfesor, int idAsignatura, String nombreAsignatura, String nombre, String apellidos, long numeroTelefonico, long documentoIdentidad, int edad, int idGenero) {
        super(nombre, apellidos, numeroTelefonico, documentoIdentidad, edad, idGenero);

        this.idProfesor = idProfesor; 
        this.idAsignatura= idAsignatura;
        this.nombreAsignatura = nombreAsignatura; 
    }
  
     
    public void setIdAsignatura(int idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public void setNombreAsignatura(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }

    public int getIdProfesor(){
        return idProfesor;
    }

    public int getIdAsignatura() {
        return idAsignatura;
    }

    public String getNombreAsignatura() {
        return nombreAsignatura;
    }
}
