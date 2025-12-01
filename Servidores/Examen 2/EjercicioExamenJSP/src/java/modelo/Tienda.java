package modelo;

public class Tienda {

    private String idtienda, nombre, direcion, poblacion;

    public Tienda() {

    }

    public Tienda(String idtienda, String nombre, String direcion, String poblacion) {
        this.idtienda = idtienda;
        this.nombre = nombre;
        this.direcion = direcion;
        this.poblacion = poblacion;
    }

    public String getIdtienda() {
        return idtienda;
    }

    public void setIdtienda(String idtienda) {
        this.idtienda = idtienda;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirecion() {
        return direcion;
    }

    public void setDirecion(String direcion) {
        this.direcion = direcion;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

}
