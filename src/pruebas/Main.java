package pruebas;

import conector.Conexion;
import entidades.Libros;
import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        
        Conexion.obtenerConexion();
        
        Libros.ConsultarTitulo("heroes");        
        
    }    
}
