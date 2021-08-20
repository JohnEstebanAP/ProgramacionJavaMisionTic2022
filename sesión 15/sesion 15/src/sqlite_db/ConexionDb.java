/**
 * 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

  //++++++++++++++++++Código para la conexión con la base de datos+++++++++++++++++++++
    public static void connect(){
        Connection conexion= null;
        try{
            //ruta donde está la base de datos que creamos
            String url= "jdbc:sqlite:C:/Users/Asus/Desktop/project/mydatabase.db";
            String user= "john";
            String password = "123";
            conexion = DriverManager.getConnection(url, user, password);
    
            System.out.println("Connection to SQlite has been established.");
        } catch (SQLException e){
            System.out.println(e.getMessage());
        } finally{
            try{
                if(conexion != null){
                    conexion.close();
                }
            }catch (SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
    }
 */
package sqlite_db;

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
    public  static void Opendb() throws Exception{
        try{
            url= "jdbc:sqlite:/home/john/Desarrollo/ProgramacionJavaMisionTic2022/sesión 15/sesion 15/src/sqlite_db/Almacen.db";
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
