package proyecto_final_veterinaria;

public class Mascota {
    private String idMascota;
    private String nombre;
    private String especie;
    private String raza;
    private int edad; //Si es 0 se le concidera cachorro
    private String nombreDueno;
    private String apellidoPaternoDueno;
    private String apellidoMaternoDueno;
    private String telefonoDueno;
    private Dueño dueño;

    public Mascota() {
        
    }
    
    public Mascota(String idMascota, String nombre, String especie, String raza, int edad, String nombreDueno, String apellidoPaternoDueno, String apellidoMaternoDueno, String telefonoDueno) {
        this.idMascota = idMascota;
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.edad = edad;
        this.nombreDueno = nombreDueno;
        this.apellidoPaternoDueno = apellidoPaternoDueno;
        this.apellidoMaternoDueno = apellidoMaternoDueno;
        this.telefonoDueno = telefonoDueno;
    }

    public String getNombreDueno() {
        return nombreDueno;
    }

    public void setNombreDueno(String nombreDueno) {
        this.nombreDueno = nombreDueno;
    }

    public String getApellidoPaternoDueno() {
        return apellidoPaternoDueno;
    }

    public void setApellidoPaternoDueno(String apellidoPaternoDueno) {
        this.apellidoPaternoDueno = apellidoPaternoDueno;
    }

    public String getApellidoMaternoDueno() {
        return apellidoMaternoDueno;
    }

    public void setApellidoMaternoDueno(String apellidoMaternoDueno) {
        this.apellidoMaternoDueno = apellidoMaternoDueno;
    }

    public String getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(String idMascota) {
        this.idMascota = idMascota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTelefonoDueno() {
        return telefonoDueno;
    }

    public void setTelefonoDueno(String telefonoDueno) {
        this.telefonoDueno = telefonoDueno;
    }

    public void mostrarDatos() {
        System.out.println("ID Mascota: " + idMascota);
        System.out.println("Nombre: " + nombre);
        System.out.println("Especie: " + especie);
        System.out.println("Raza: " + raza);
        System.out.println("Edad: " + edad + " años");
    }
}
