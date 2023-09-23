package entidades;

import conector.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Borrar {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID para realizar el borrado: ");
        int id = scanner.nextInt();
        scanner.close();

        try
        {
            deleteData(id);
        } catch (ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static void deleteData(int id) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        // Establecer la conexión a la base de datos
        Connection connection = null;

        try
        {
            // Obtener la conexión desde la clase Conexion
            connection = Conexion.obtenerConexion();

            // Crear un mapa que contenga el nombre de la tabla y el nombre de la columna correspondiente a 'libros_id'
            Map<String, String> tableColumnMap = new LinkedHashMap<>();
            tableColumnMap.put("editorial_has_libros", "libros_id");
            tableColumnMap.put("idiomas_has_libros", "libros_id");
            tableColumnMap.put("punto_venta_has_libros", "libros_id");
            tableColumnMap.put("autor_has_libros", "libros_id");
            tableColumnMap.put("edicion_has_libros", "libros_id");
            tableColumnMap.put("genero_has_libros", "libros_id");
            tableColumnMap.put("titulo", "libros_id");

            // Añadir las demás tablas y columnas según la estructura de su base de datos
            // Eliminar los registros relacionados en las tablas
            for (Map.Entry<String, String> entry : tableColumnMap.entrySet())
            {
                String table = entry.getKey();
                String column = entry.getValue();

                String deleteSql = "DELETE FROM " + table + " WHERE " + column + " = ?";
                try (PreparedStatement deleteStatement = connection.prepareStatement(deleteSql))
                {
                    // Establecer el parámetro de la sentencia
                    deleteStatement.setInt(1, id);

                    // Ejecutar la sentencia de eliminación
                    int deletedRows = deleteStatement.executeUpdate();

                    // Imprimir el resultado de lo que se borró
                    System.out.println("Se borraron " + deletedRows + " registros de la tabla " + table);
                }
            }

            // Mostrar el resultado del borrado
            System.out.println("La sentencia query se ejecutó correctamente.");

        } finally
        {
            // Cerrar la conexión
            if (connection != null)
            {
                connection.close();
            }
        }
    }
}

//    public static void deleteData(int id) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
//        // Establecer la conexión a la base de datos
//        Connection connection = null;
//
//        try
//        {
//            // Obtener la conexión desde la clase Conexion
//            connection = Conexion.obtenerConexion();
//
//            // Crear la consulta SQL para borrar los registros
//            // Arreglo de nombres de tablas
//            String[] tables =
//            {
//                "editorial_has_libros", "idiomas_has_libros", "punto_venta_has_libros", "autor", "edicion", "genero", "editorial", "idioma", "punto_venta", "Titulo"
//            };
//
//// Eliminar los registros relacionados en las tablas
//            for (String table : tables)
//            {
//                String deleteSql = "DELETE FROM " + table + " WHERE libros_id = ?";
//                try ( PreparedStatement deleteStatement = connection.prepareStatement(deleteSql))
//                {
//                    // Establecer el parámetro de la sentencia
//                    deleteStatement.setInt(1, id);
//
//                    // Ejecutar la sentencia de eliminación
//                    deleteStatement.executeUpdate();
//
//                    // Imprimir el resultado de lo que se borró
//                    System.out.println("Se borraron los registros de la tabla " + table);
//                }
//            }
//
//            // Mostrar el resultado del borrado
//            System.out.println("La sentencia query se ejecutó correctamente.");
//
//            // Ejecutar una consulta adicional para mostrar los datos restantes en la tabla
//String selectSql = "SELECT * FROM titulo";
//try (PreparedStatement selectStatement = connection.prepareStatement(selectSql); ResultSet resultSet = selectStatement.executeQuery()) {
//    // Mostrar los datos restantes en la tabla
//    System.out.println("Datos restantes en la tabla Titulo:");
//    while (resultSet.next()) {
//        System.out.println("ID: " + resultSet.getInt("id"));
//        System.out.println("Título: " + resultSet.getString("titulo"));
//        System.out.println("Páginas: " + resultSet.getInt("Paginas"));
//        System.out.println("Stock: " + resultSet.getInt("Stock"));
//        System.out.println("Precio: " + resultSet.getBigDecimal("Precio"));
//        System.out.println("Autor ID: " + resultSet.getInt("autor_id"));
//        System.out.println("Género ID: " + resultSet.getInt("genero_id"));
//        System.out.println("Edición ID: " + resultSet.getInt("edicion_id"));
//        System.out.println("--------------------");
//    }
//}
//
//
//        } finally
//        {
//            // Cerrar la conexión
//            if (connection != null)
//            {
//                connection.close();
//            }
//        }
//    }
//
//}
