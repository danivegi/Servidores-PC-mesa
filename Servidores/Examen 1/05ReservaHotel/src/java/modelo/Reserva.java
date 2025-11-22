/*
 * Clase modelo: Reserva
 * Representa una reserva de hotel con todos sus datos asociados.
 */
package modelo;

/**
 * Clase que define los datos de una reserva en el sistema.
 * Implementa la interfaz Comparable para poder ordenar reservas por fecha de entrada.
 */
public class Reserva implements Comparable<Reserva> {

    // Atributos principales que almacenan los datos del cliente y su reserva.
    private String Nombre, Apellidos, Dni, SS, telefono, email, fechaEntrada, fechaSalida, tipoPension, provincia;
    private String[] serviciosExtras; // Array con los servicios adicionales que el cliente contrata.

    /**
     * Constructor con todos los parámetros.
     * Se utiliza para crear un objeto Reserva completo con todos los datos del formulario.
     */

    public Reserva(String Nombre, String Apellidos, String Dni, String SS, String telefono, String email, String fechaEntrada, String fechaSalida, String tipoPension, String provincia, String[] serviciosExtras) {
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.Dni = Dni;
        this.SS = SS;
        this.telefono = telefono;
        this.email = email;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.tipoPension = tipoPension;
        this.provincia = provincia;
        this.serviciosExtras = serviciosExtras;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getDni() {
        return Dni;
    }

    public void setDni(String Dni) {
        this.Dni = Dni;
    }

    public String getSS() {
        return SS;
    }

    public void setSS(String SS) {
        this.SS = SS;
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

    public String getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getTipoPension() {
        return tipoPension;
    }

    public void setTipoPension(String tipoPension) {
        this.tipoPension = tipoPension;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    /**
     * Devuelve los servicios extra como una sola cadena de texto, separados por comas.
     * Ejemplo: "Spa, Parking, Desayuno".
     */
    public String getServiciosExtras() {
        String cadena = "";

        // Recorre el array de servicios y los une en una cadena separada por comas.
        for (int x = 0; x < serviciosExtras.length; x++) {
            if (x == serviciosExtras.length - 1) {
                // Último elemento: se añade sin coma final.
                cadena += serviciosExtras[x];
            } else {
                // Cualquier otro elemento: se añade seguido de coma y espacio.
                cadena += serviciosExtras[x] + ", ";
            }
        }
        return cadena;
    }

    /**
     * Permite modificar el array de servicios extra.
     */
    public void setServiciosExtras(String[] serviciosExtras) {
        this.serviciosExtras = serviciosExtras;
    }

    /**
     * Método de comparación entre reservas.
     * Permite ordenar las reservas según la fecha de entrada (orden alfabético).
     * Si se desea ordenar cronológicamente, las fechas deberían tener formato YYYY-MM-DD.
     */
    @Override
    public int compareTo(Reserva o) {
        Reserva reserva = (Reserva) o;
        return fechaEntrada.compareTo(reserva.getFechaEntrada());
    }

}
