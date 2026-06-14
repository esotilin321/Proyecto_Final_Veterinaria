package proyecto_final_veterinaria;

public class Consulta {
    private int idConsulta;
    private Mascota mascota;
    private Veterinario veterinario;
    private ServicioMedico servicio;
    private String diagnostico;
    private String estado; // "Agendada", "Atendida", "Cobrada"

    public Consulta(int idConsulta, Mascota mascota, Veterinario veterinario, ServicioMedico servicio) {
        this.idConsulta = idConsulta;
        this.mascota = mascota;
        this.veterinario = veterinario;
        this.servicio = servicio;
        this.diagnostico = "Pendiente de atención";
        this.estado = "Agendada";
    }

    public int getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }

    public ServicioMedico getServicio() {
        return servicio;
    }

    public void setServicio(ServicioMedico servicio) {
        this.servicio = servicio;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void atenderConsulta(String diagnostico) {
        this.diagnostico = diagnostico;
        this.estado = "Atendida";
        System.out.println("Consulta atendida correctamente. Diagnóstico registrado.");
    }

    public void mostrarDatos() {
        System.out.println("ID Consulta: " + idConsulta);
        System.out.println("Mascota: " + mascota.getNombre() + " (" + mascota.getEspecie() + ")");
        System.out.println("Veterinario: " + veterinario.getNombre_Usuario());
        System.out.println("Servicio: " + servicio.getNombreServicio() + " - $" + servicio.getPrecio());
        System.out.println("Diagnóstico: " + diagnostico);
        System.out.println("Estado: " + estado);
    }
}
