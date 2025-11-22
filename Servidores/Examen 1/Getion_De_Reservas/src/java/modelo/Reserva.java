package modelo;

public class Reserva implements Comparable<Reserva> {

    private String nombre, apellidos, dni, ss, telefono, email, provincia, fechaEntrada, fechaSalida, alojamiento;
    private String[] extras;

    public Reserva(String nombre, String apellidos, String dni, String ss, String telefono, String email, String provincia, String fechaEntrada, String fechaSalida, String alojamiento, String[] extras) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.ss = ss;
        this.telefono = telefono;
        this.email = email;
        this.provincia = provincia;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.alojamiento = alojamiento;
        this.extras = extras;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getSs() {
        return ss;
    }

    public void setSs(String ss) {
        this.ss = ss;
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

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
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

    public String getAlojamiento() {
        return alojamiento;
    }

    public void setAlojamiento(String alojamiento) {
        this.alojamiento = alojamiento;
    }

    public String getExtras() {
        String cadena = "";

        if (extras == null) {
            cadena = "Sin Servicios";
        } else {
            for (int x = 0; x < extras.length; x++) {
                if (x == extras.length - 1) {
                    cadena += extras[x];
                } else {
                    cadena += extras[x] + ", ";
                }
            }
        }
        return cadena;
    }

    public void setExtras(String[] extras) {
        this.extras = extras;
    }

    @Override
    public String toString() {
        return "Reserva{" + "nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni + ", ss=" + ss + ", telefono=" + telefono + ", email=" + email + ", provincia=" + provincia + ", fechaEntrada=" + fechaEntrada + ", fechaSalida=" + fechaSalida + ", alojamiento=" + alojamiento + ", extras=" + extras + '}';
    }

    @Override
    public int compareTo(Reserva o) {
        return fechaEntrada.compareTo(o.getFechaEntrada());
    }

}