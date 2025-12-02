package modelo;

public class Titulo {

    private String isbn, titulo, idAutor, aEdicion, descripcion;
    private int idEditorial;

    public Titulo() {

    }

    public Titulo(String isbn, String titulo, String idAutor, String aEdicion, String descripcion, int idEditorial) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.idAutor = idAutor;
        this.aEdicion = aEdicion;
        this.descripcion = descripcion;
        this.idEditorial = idEditorial;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(String idAutor) {
        this.idAutor = idAutor;
    }

    public String getaEdicion() {
        return aEdicion;
    }

    public void setaEdicion(String aEdicion) {
        this.aEdicion = aEdicion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdEditorial() {
        return idEditorial;
    }

    public void setIdEditorial(int idEditorial) {
        this.idEditorial = idEditorial;
    }

}
