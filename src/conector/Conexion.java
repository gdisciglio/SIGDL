package conector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
    public static Connection obtenerConexion() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        
        String cadena = null;
        String usuario = null;
        String clave = null;
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            cadena = "jdbc:mysql://db4free.net:3306/proyect_library";
            
            usuario = "***PEDIR_INFORMACION***";
            
            clave = "***PEDIR_INFORMACION***";
//            
//            cadena = "jdbc:mysql://127.0.0.1:3307/proyecto_libreria";
//            usuario = "root";
//            clave= "";

            //creo un objeto de la clase Driver por Reflection
            Class.forName(driver).newInstance();
            
            
        } catch (ClassNotFoundException classNotFoundException) {
            System.out.println("No encuentra la Clase");
        } catch (InstantiationException instantiationException) {
            System.out.println("error de instanciamiento");
        } catch (IllegalAccessException illegalAccessException) {
            System.out.println("acceso ilegal");
        }
        //retorno el objeto de tipo Connection
        
        return DriverManager.getConnection(cadena, usuario, clave);
        
        
        
    }  
}
