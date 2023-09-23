package entidades;

public class Idiomas extends Libros {
    
        private String idioma;

    public Idiomas() {
    }

    public Idiomas(String idioma, int libros_id, String titulo, int autor_id, int genero_id, int paginas, int edicion_id, int precio, int stock) {
        super(libros_id, titulo, autor_id, genero_id, paginas, edicion_id, precio, stock);
        this.setIdioma(idioma);
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    @Override
    public String toString() {
        return super.toString() + "idioma = " + idioma;
    }
    
    
}
