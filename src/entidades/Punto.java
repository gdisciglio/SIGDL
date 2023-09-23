package entidades;

public class Punto extends Libros {

    private String formato;
    private String direccion;
    private String telefono;
    private String email;

    public Punto() {
    }

    public Punto(String formato, String direccion, String telefono, String email, int libros_id, String titulo, int autor_id, int genero_id, int paginas, int edicion_id, int precio, int stock) {
        super(libros_id, titulo, autor_id, genero_id, paginas, edicion_id, precio, stock);
        this.setFormato(formato);
        this.setDireccion(direccion);
        this.setTelefono(telefono);
        this.setEmail(email);
    }

    
    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
  //metodos
    
public void Consulta() {        
    }

    @Override
    public String toString() {
        return super.toString() + "formato = " + formato + ", direccion = " + direccion + ", telefono = " + telefono + 
                ", email = " + email;
    }

    
}
