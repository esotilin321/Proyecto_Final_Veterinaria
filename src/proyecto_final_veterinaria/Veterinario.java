package proyecto_final_veterinaria;

public class Veterinario extends Usuario {
    private String especialidad;
    private String nroColegiatura;

    public Veterinario(String idUsuario, String nombre_Usuario, String correo_Usuario, String contraseña_Usuario, String especialidad, String nroColegiatura) {
        super(idUsuario, nombre_Usuario, correo_Usuario, contraseña_Usuario);
        this.especialidad = especialidad;
        this.nroColegiatura = nroColegiatura;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getNroColegiatura() {
        return nroColegiatura;
    }

    public void setNroColegiatura(String nroColegiatura) {
        this.nroColegiatura = nroColegiatura;
    }

    @Override
    public void iniciarSesion() {
        System.out.println("El Veterinario " + getNombre_Usuario() + " ha iniciado sesión.");
    }

    @Override
    public void cerrarSesion() {
        System.out.println("El Veterinario " + getNombre_Usuario() + " ha cerrado sesión.");
    }

    public void mostrarDatos() {
        System.out.println("ID Veterinario: " + getIdUsuario());
        System.out.println("Nombre: " + getNombre_Usuario());
        System.out.println("Correo: " + getCorreo_Usuario());
        System.out.println("Especialidad: " + especialidad);
        System.out.println("Nro. Colegiatura: " + nroColegiatura);
    }
}
