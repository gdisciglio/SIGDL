package entidades;

import conector.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Autor {

    private String nombre;

    private String apellido;

    public Autor() {
    }

    public Autor(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static int buscarAutorId (String apellido) throws IllegalAccessException, SQLException, ClassNotFoundException, InstantiationException{
    
        //creo una conexion
    
    Connection unaConexion = Conexion.obtenerConexion();
                
    //creo la consulta sql a ejecutar 
    String consulta = "SELECT * FROM autor WHERE apellido = '"+apellido+"'";

    
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
        
    //retorno el dato buscado
    return busqueda;
    
    }
    
    @Override
    public String toString() {
        return "nombre = " + nombre + ", apellido = " + apellido;
    }

}
