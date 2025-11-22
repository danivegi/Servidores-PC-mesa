package modelo;

public class Producto {
    
    private String ref;
    private String nombre;
    private String descripcion;
    private double precio;
    private int dto;

    public Producto() {
        
    }

    public Producto(String ref, String nombre, String descripcion, double precio, int dto) {
        this.ref = ref;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.dto = dto;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getDto() {
        return dto;
    }

    public void setDto(int dto) {
        this.dto = dto;
    }

    @Override
    public String toString() {
        return "Producto{" + "ref=" + ref + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio + ", dto=" + dto + '}';
    }
    
}
