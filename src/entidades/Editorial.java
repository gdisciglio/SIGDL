package entidades;

public class Editorial extends Libros{

    private String editorial;

    
    public Editorial() {
    }

    public Editorial(String editorial, int libros_id, String titulo, int autor_id, int genero_id, int paginas, int edicion_id, int precio, int stock) {
        super(libros_id, titulo, autor_id, genero_id, paginas, edicion_id, precio, stock);
        this.setEditorial(editorial);
    }

    
    public String getEditorial() {
        return editorial;
    }
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    @Override
    public String toString() {
        return super.toString()  + "editorial = " + editorial;
    }
    
    
    
}
