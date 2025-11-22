package modelo;

public class Cliente {
    
    private String nombre, cif, representante, nif, sector, telefono, email, ventas, observaciones;

    public Cliente() {
    }

    public Cliente(String nombre, String cif, String representante, String nif, String sector, String telefono, String email, String ventas, String observaciones) {
        this.nombre = nombre;
        this.cif = cif;
        this.representante = representante;
        this.nif = nif;
        this.sector = sector;
        this.telefono = telefono;
        this.email = email;
        this.ventas = ventas;
        this.observaciones = observaciones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getRepresentante() {
        return representante;
    }

    public void setRepresentante(String representante) {
        this.representante = representante;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
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

    public String getVentas() {
        return ventas;
    }

    public void setVentas(String ventas) {
        this.ventas = ventas;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nombre=" + nombre + ", cif=" + cif + ", representante=" + representante + ", nif=" + nif + ", sector=" + sector + ", telefono=" + telefono + ", email=" + email + ", ventas=" + ventas + ", observaciones=" + observaciones + '}';
    }
    
    
    
}
