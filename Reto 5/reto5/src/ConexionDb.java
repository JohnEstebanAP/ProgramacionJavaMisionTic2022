

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexionDb {
    public static String url; // Direccion absolita del ODBC
    public static String nombredb; //Nombre de la base de Datos
    public static Statement instruc; //Variable para crear la conexion
    public static Connection conexion = null;


    //Metodo para abrir conexion
    public  static void Opendb() throws SQLException{
        try{
            //Por favor ajusta dirección URL la base de datos a su diresion actual par que funcione
            url= "jdbc:sqlite:DB_SistemaEstadistico.db";
            conexion = DriverManager.getConnection(url);
            instruc = conexion.createStatement();

            System.out.println("Conexion DB OK");
        } catch (SQLException e){
            System.err.println("Error: "+ e.getMessage());
        }
        // Final Opendb()
    }

    //Para consultar DB
    public static ResultSet Consulta(String ConSQL) throws SQLException {
        try{
            ResultSet cursor = instruc.executeQuery(ConSQL);
            return cursor;
        }
        // Si hay error
        catch (SQLException exc){
            System.err.println("Error generado en consulta: "+ exc.getMessage());
            return null;
        }
        // final Consulta
    }
    
    // para operaciones INSERT, DELETE, Y UPDATE
    public static boolean Ejecute(String registro) throws SQLException{
        boolean ok = true;
        try{
            instruc.executeUpdate(registro);
        }catch (SQLException exc){
           System.err.println("Error actual (INS, DEL, UPD): " + exc.getMessage());
           ok = false; 
        }
        return ok;
    }//final ejecute
}
