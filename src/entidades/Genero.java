package entidades;

import conector.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Genero{

    private String genero;

    public Genero() {
    }

    public Genero(String genero) {
        this.genero = genero;
    }  

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    public static int buscarGeneroId (String genero) throws IllegalAccessException, SQLException, ClassNotFoundException, InstantiationException{
    
        //creo una conexion
    
    Connection unaConexion = Conexion.obtenerConexion();
                
    //creo la consulta sql a ejecutar 
    String consulta = "SELECT * FROM genero WHERE genero = '"+genero+"'";
    
    //creo la sentencia a ejecutar

    Statement unaSentencia = unaConexion.createStatement();

    //ejecuto la sentencia (Query) y guardo el resultado
    // en un objeto de tipo Result

    ResultSet unResultado = unaSentencia.executeQuery(consulta);
    
    int busqueda = 0;
        if (unResultado.isBeforeFirst()) {
            unResultado.next(); // Mover el cursor al primer registro
            busqueda = unResultado.getInt(1);
        }
   
    return busqueda;
    }

    @Override
    public String toString() {
        return "genero=" + genero;
    }

}
