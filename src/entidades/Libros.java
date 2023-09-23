package entidades;

import Gui.PHome;
import conector.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Libros {

    private int libros_id;
    private String titulo;
    private int autor_id;
    private int genero_id;
    private int paginas;
    private int edicion_id;
    private int precio;
    private int stock;

    public Libros() {
    }

    public Libros(int libros_id, String titulo, int autor_id, int genero_id, int paginas, int edicion_id, int precio, int stock) {
        this.setLibros_id(libros_id);
        this.setTitulo(titulo);
        this.setAutor_id(autor_id);
        this.setGenero_id(genero_id);
        this.setPaginas(paginas);
        this.setEdicion_id(edicion_id);
        this.setPrecio(precio);
        this.setStock(stock);
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getEdicion_id() {
        return edicion_id;
    }

    public void setEdicion_id(int edicion_id) {
        this.edicion_id = edicion_id;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public int getGenero_id() {
        return genero_id;
    }

    public void setGenero_id(int genero_id) {
        this.genero_id = genero_id;
    }

    public int getAutor_id() {
        return autor_id;
    }

    public void setAutor_id(int autor_id) {
        this.autor_id = autor_id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getLibros_id() {
        return libros_id;
    }

    public void setLibros_id(int libros_id) {
        this.libros_id = libros_id;
    }

    //Regla de negocio...
    //metodos temporales
    public static void AgregarLibro(Libros libro, int idioma) throws IllegalAccessException, SQLException, ClassNotFoundException, InstantiationException {

        Libros lb = libro;

        Connection unaConexion = Conexion.obtenerConexion(); //creo una conexion

//    String cantidad = "SELECT *  FROM titulo";
//    Statement canstate= unaConexion.createStatement();
//    ResultSet rs = canstate.executeQuery(cantidad);
//        while (rs.next()) {
//            System.out.println(rs.getInt("libros_id"));
//            System.out.println(rs.getString("titulo"));
//            System.out.println("----------------");
//            
//        }
        //  lb.setLibros_id(rs.getInt("libros_id"));
        //creo la consulta sql a ejecutar 
//    String consulta = """
//                      INSERT INTO titulo(libros_id,titulo, Paginas, Stock, Precio, autor_id, genero_id, edicion_id)
//                      VALUES(null,'"""+lb.getTitulo()+"',"+lb.getPaginas()+","+lb.getStock()+","+lb.getPrecio()+","+lb.getAutor_id()+","+lb.getGenero_id()+","+lb.getEdicion_id()+")";
        String consulta = "INSERT INTO titulo VALUES(null,'" + lb.getTitulo() + "'," + lb.getPaginas() + "," + lb.getStock() + "," + lb.getPrecio() + "," + lb.getAutor_id() + "," + lb.getGenero_id() + "," + lb.getEdicion_id() + ")";

        Statement unaSentencia = unaConexion.createStatement();

        unaSentencia.execute(consulta);

        String cantidad = "SELECT *  FROM titulo";
        Statement canstate = unaConexion.createStatement();
        ResultSet rs = canstate.executeQuery(cantidad);
        int id = 23;
        while (rs.next()) {
            
            //Obtienes la data que necesitas...
            id++;
        }
        System.out.println(id);
        

        String consulta2 = "INSERT INTO idiomas_has_libros (idiomas_id, libros_id) VALUES("+idioma+", "+id+")"+
                            "ON DUPLICATE KEY UPDATE idiomas_id=VALUES(idiomas_id),libros_id=VALUES(libros_id);";
        Statement sen = unaConexion.createStatement();
        sen.execute(consulta2);
        JOptionPane.showMessageDialog(null, "Libro agregado");

    }

    public void ModificarLibro() {
    }

    public static ResultSet ConsultarTitulo(String titulo) throws IllegalAccessException, SQLException, ClassNotFoundException, InstantiationException {

        //creo una conexion
        Connection unaConexion = Conexion.obtenerConexion();

        //creo la consulta sql a ejecutar
        //String consulta = "SELECT * FROM titulo WHERE titulo = '"+titulo+"';";
//    String consulta = "SELECT t.libros_id, t.titulo, a.nombre, a.apellido, "
//                      + "g.genero, t.paginas, e.anio, t.stock, t.precio\n" +
//                      "FROM titulo t\n" +
//                      "JOIN autor a ON t.autor_id = a.autor_id\n" +
//                      "JOIN genero g ON t.genero_id = g.genero_id\n" +
//                      "JOIN edicion e ON t.edicion_id = e.edicion_id\n" +
//                      "WHERE t.titulo LIKE '"+'%'+titulo+'%'+"';";
        String consulta = "SELECT t.libros_id, t.titulo, concat(a.apellido,' ',a.nombre) as autor, "
                + "g.genero, i.idiomas, t.paginas, e.anio, t.stock, t.precio\n"
                + "FROM titulo t\n"
                + "JOIN autor a ON t.autor_id = a.autor_id\n"
                + "INNER JOIN idiomas_has_libros ih ON ih.libros_id = t.libros_id\n"
                + "INNER JOIN idioma i ON i.idiomas_id = ih.idiomas_id\n"
                + "JOIN genero g ON t.genero_id = g.genero_id\n"
                + "JOIN edicion e ON t.edicion_id = e.edicion_id\n"
                + "WHERE t.titulo LIKE '" + '%' + titulo + '%' + "'"
                + "ORDER BY titulo;";

        //creo la sentencia a ejecutar
        Statement unaSentencia = unaConexion.createStatement();

        //ejecuto la sentencia (Query) y guardo el resultado
        // en un objeto de tipo Result
        ResultSet unResultado = unaSentencia.executeQuery(consulta);

        //cierro la conexion
        // unaConexion.close();
        return unResultado;
    }

    public static ResultSet ConsultarGenero(String genero) throws IllegalAccessException, SQLException, ClassNotFoundException, InstantiationException {

        //creo una conexion
        Connection unaConexion = Conexion.obtenerConexion();

        //creo la consulta sql a ejecutar 
        String consulta = "SELECT t.libros_id, t.titulo, concat(a.apellido,' ',a.nombre) as autor, "
                + "g.genero, i.idiomas, t.paginas, e.anio, t.stock, t.precio\n"
                + "FROM titulo t\n"
                + "JOIN autor a ON t.autor_id = a.autor_id\n"
                + "INNER JOIN idiomas_has_libros ih ON ih.libros_id = t.libros_id\n"
                + "INNER JOIN idioma i ON i.idiomas_id = ih.idiomas_id\n"
                + "JOIN genero g ON t.genero_id = g.genero_id\n"
                + "JOIN edicion e ON t.edicion_id = e.edicion_id\n"
                + "WHERE g.genero LIKE '" + '%' + genero + '%' + "'"
                + "ORDER BY titulo;";

        //creo la sentencia a ejecutar
        Statement unaSentencia = unaConexion.createStatement();

        //ejecuto la sentencia (Query) y guardo el resultado
        // en un objeto de tipo Result
        ResultSet unResultado = unaSentencia.executeQuery(consulta);

        return unResultado;
    }

    public static ResultSet ConsultarAutor(String autor) throws IllegalAccessException, SQLException, ClassNotFoundException, InstantiationException {

        //creo una conexion
        Connection unaConexion = Conexion.obtenerConexion();

        //creo la consulta sql a ejecutar
        String consulta = "SELECT t.libros_id, t.titulo, concat(a.apellido,' ',a.nombre) as autor, "
                + "g.genero, i.idiomas, t.paginas, e.anio, t.stock, t.precio\n"
                + "FROM titulo t\n"
                + "JOIN autor a ON t.autor_id = a.autor_id\n"
                + "INNER JOIN idiomas_has_libros ih ON ih.libros_id = t.libros_id\n"
                + "INNER JOIN idioma i ON i.idiomas_id = ih.idiomas_id\n"
                + "JOIN genero g ON t.genero_id = g.genero_id\n"
                + "JOIN edicion e ON t.edicion_id = e.edicion_id\n"
                + "WHERE a.apellido LIKE '" + '%' + autor + '%' + "'"
                + "ORDER BY titulo;";

        //creo la sentencia a ejecutar
        Statement unaSentencia = unaConexion.createStatement();

        //ejecuto la sentencia (Query) y guardo el resultado
        // en un objeto de tipo Result
        ResultSet unResultado = unaSentencia.executeQuery(consulta);

        return unResultado;
    }

    public void EliminarLibro() {
    }

    public static DefaultTableModel CargarTabla() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {

        //SE PUEDE alterar orden columnas sin importar orden Base de Datos, 
        //respetando nombres de campos
        String[] columnas = {"ID", "Título", "Autor", "Género", "Idioma", "Páginas", "Edición", "Stock", "Precio"};
        String[] registro = new String[9];

        //String sql = "SELECT libros_id, titulo, autor_id, genero_id, paginas, edicion_id, stock, precio FROM titulo";
        String sql = "SELECT t.libros_id, t.titulo, concat(a.apellido,' ',a.nombre) as autor, "
                + "g.genero, i.idiomas, t.paginas, e.anio, t.stock, t.precio\n"
                + "FROM titulo t\n"
                + "JOIN autor a ON t.autor_id = a.autor_id\n"
                + "INNER JOIN idiomas_has_libros ih ON ih.libros_id = t.libros_id\n"
                + "INNER JOIN idioma i ON i.idiomas_id = ih.idiomas_id\n"
                + "JOIN genero g ON t.genero_id = g.genero_id\n"
                + "JOIN edicion e ON t.edicion_id = e.edicion_id\n"
                + "ORDER BY libros_id";

        DefaultTableModel modelo = new DefaultTableModel(null, columnas);

        Connection unaConexion = Conexion.obtenerConexion();

        try {
            Statement unaSentencia = unaConexion.createStatement();
            ResultSet unResultado = unaSentencia.executeQuery(sql);

            java.sql.ResultSetMetaData metaData = unResultado.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (unResultado.next()) {
//                registro[0]=unResultado.getString("libros_id");
//                registro[1]=unResultado.getString("titulo");
//                registro[2]=unResultado.getString("autor");
//                registro[3]=unResultado.getString("genero");
//                registro[4]=unResultado.getString("idiomas");
//                registro[5]=unResultado.getString("paginas");
//                registro[6]=unResultado.getString("anio");
//                registro[7]=unResultado.getString("stock");
//                registro[8]=unResultado.getString("precio");
//                
//                modelo.addRow(registro);

                Object[] filas = new Object[columnCount]; //numeroColumnas es el número de columnas de la tabla y del ResultSet
                for (int i = 0; i < columnCount; i++) {
                    filas[i] = unResultado.getObject(i + 1); // El ResultSet comienza en 1 en vez de en 0
                }
                modelo.addRow(filas);
            }

//            cierro la sentencia y la conexion
//            unResultado.close();
//            unaSentencia.close();
//            unaConexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(PHome.class.getName()).log(Level.SEVERE, null, ex);
        }
        return modelo;
    }

    @Override
    public String toString() {
        return "libros_id = " + libros_id + ", titulo = " + titulo + ", autor_id = " + autor_id + ", genero_id = " + genero_id
                + ", paginas = " + paginas + ", edicion_id = " + edicion_id + ", precio = " + precio + ", stock = " + stock;
    }

}
