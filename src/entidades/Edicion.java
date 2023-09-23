package entidades;

import conector.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Edicion {

    private int year;

    public Edicion() {
    }

    public Edicion(int year) {
        this.year = year;
    }

    

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    
    public static int buscarEdicionId (int ano) throws IllegalAccessException, SQLException, ClassNotFoundException, InstantiationException{
    
        //creo una conexion
    
    Connection unaConexion = Conexion.obtenerConexion();
                
    //creo la consulta sql a ejecutar 
    String consulta = "SELECT * FROM edicion WHERE anio = '"+ano+"'";
    
    
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
        return  "year = " + year;
    }

    

}
