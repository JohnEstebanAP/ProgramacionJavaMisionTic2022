public class  Persona {
     private String    nombre;
     private String    apellidos;
     private long      numeroTelefonico;
     private long      documentoIdentidad;
     private int       edad;
     private int       idGenero;

     public void Persona(String nombre,String apellidos, long numeroTelefonico, long documentoIdentidad, int edad,int idGenero){
          this.nombre = nombre;
          this.apellidos = apellidos;
          this.numeroTelefonico = numeroTelefonico;
          this.documentoIdentidad = documentoIdentidad;
          this.edad = edad;
          this.idGenero = idGenero;
     }

     public void setNombre(String nombre){
          this.nombre = nombre;
     }

     public void setApellidos(String apellido){
          this.apellidos = apellidos;
     }

     public void setNumeroTelefonico(long numeroTelefonico){
          this.numeroTelefonico = numeroTelefonico;
     }

     public void setDocumentoIdentidad(long documentoIdentidad){
          this.documentoIdentidad = documentoIdentidad;
     }

     public void setedad(int edad){
          this.edad = edad;
     }

     public void setIdGenero(int idGenero){
          this.idGenero = idGenero;
     }

     public String getNombre(){
          return nombre;
     }

     public String getApellidos(){
          return apellidos;
     }

     public long getNumeroTelefonico(){
          return numeroTelefonico;
     } 

     public long getDocumentoIdentidad(){
          return documentoIdentidad;
     }

     public int getEdad(){
          return edad;
     }

     public int getIdGenero() {
          return idGenero;
     }
}
