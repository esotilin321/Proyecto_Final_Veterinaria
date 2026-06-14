package proyecto_final_veterinaria;

public class ServicioMedico {
    private String idServicio;
    private String nombreServicio;
    private double precio;

    public ServicioMedico(String idServicio, String nombreServicio, double precio) {
        this.idServicio = idServicio;
        this.nombreServicio = nombreServicio;
        this.precio = precio;
    }

    public String getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(String idServicio) {
        this.idServicio = idServicio;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void mostrarDatos() {
        System.out.println("ID Servicio: " + idServicio + " | Nombre: " + nombreServicio + " | Precio: $" + precio);
    }
}
