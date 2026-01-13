package modelo;

public class Pizza {
    
    private int id, idpizza;
    private String nombre;
    private double precio;

    public Pizza() {
        
    }

    public Pizza(int id, String nombre, int idpizza, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.idpizza = idpizza;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdpizza() {
        return idpizza;
    }

    public void setIdpizza(int idpizza) {
        this.idpizza = idpizza;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Pizza{" + "id=" + id + ", nombre=" + nombre + ", idpizza=" + idpizza + ", precio=" + precio + '}';
    }
    
}
