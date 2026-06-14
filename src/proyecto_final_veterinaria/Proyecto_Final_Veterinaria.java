package proyecto_final_veterinaria;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Proyecto_Final_Veterinaria {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Listas para almacenar los datos
        ArrayList<Mascota> listaMascotas = new ArrayList<>();
        ArrayList<Veterinario> listaVeterinarios = new ArrayList<>();
        ArrayList<ServicioMedico> listaServicios = new ArrayList<>();
        ArrayList<Consulta> listaConsultas = new ArrayList<>();
        ArrayList<Factura> listaFacturas = new ArrayList<>();
        Mascota mascota = new Mascota();

        // Datos Predefinidos
        // 1. Veterinarios //Se le agregará así al sistema
        listaVeterinarios.add(new Veterinario("V001", "Dr. Chesster Benhinthon", "chester.benhinthon@veterinaria.com", "1234", "Cirugía", "450987"));
        listaVeterinarios.add(new Veterinario("V002", "Dra. Amy Lee", "amy.lee@veterinaria.com", "5678", "Dermatología", "121452"));
        listaVeterinarios.add(new Veterinario("V003", "Dr. James Root", "james.root@veterinaria.com", "7066", "Cardiología", "750024"));
        listaVeterinarios.add(new Veterinario("V004", "Dr. Mick Thomson", "mick.thomson@veterinaria.com", "0777", "Cirugía", "015464"));
        listaVeterinarios.add(new Veterinario("V005", "Dra. Treisy Clavo", "trisy.clavo@veterinaria.com", "0555", "Neurología", "301105"));
        listaVeterinarios.add(new Veterinario("V006", "Dra. Emily Amstron", "emily.amstron@veterinaria.com", "0545", "Anestesiología", "487641"));
        // 2. Servicios Médicos
        listaServicios.add(new ServicioMedico("S001", "Consulta General", 30.0));
        listaServicios.add(new ServicioMedico("S002", "Vacunación", 25.0));
        listaServicios.add(new ServicioMedico("S003", "Desparasitación", 15.0));
        listaServicios.add(new ServicioMedico("S004", "Ecografía", 50.0));
        listaServicios.add(new ServicioMedico("S004", "Esteralización", 100.0));
        listaServicios.add(new ServicioMedico("S006", "Cirugía", 120.0));
        listaServicios.add(new ServicioMedico("S007", "Hospitalización", 200.0));
        listaServicios.add(new ServicioMedico("S008", "Emergencia", 20.0));
        

        // Administrador del sistema
        Administrador admin = new Administrador("Director General", "ADMIN01", "Admin Clinica", "admin@veterinaria.com", "admin123");

        System.out.println("");
        System.out.println(" Bienvenido al Sistema de la Clínica Veterinaria");
        System.out.println("");
        admin.iniciarSesion();

        int opcion;
        int idConsultaCounter = 1;
        int idFacturaCounter = 1;

        do {
            System.out.println("\n===== BENVENIDO A VETERINARIA CLAVO=====");
            System.out.println("1. Registrar Mascota");
            System.out.println("2. Agendar Servicio (Consulta)");
            System.out.println("3. Atender Consulta (Registrar Diagnóstico)");
            System.out.println("4. Cobrar (Generar Factura)");
            System.out.println("5. Ver Reporte del Administrador");
            System.out.println("6. Ver Lista de Mascotas");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();
            sc.nextLine(); // Consumir salto de línea

            switch (opcion) {
                case 1:
                    System.out.println("\n--- 1. REGISTRAR MASCOTA ---");
                    System.out.print("ID Mascota: ");
                    String idMas = sc.nextLine();
                    System.out.print("Nombre de la mascota: ");
                    String nomMas = sc.nextLine();
                    System.out.print("Especie: ");
                    String espMas = sc.nextLine();
                    System.out.print("Raza: ");
                    String razMas = sc.nextLine();
                    System.out.print("Edad (años): ");
                    int edadMas = sc.nextInt();
                    sc.nextLine(); // Consumir salto de línea
                    System.out.print("Nombre del dueño: ");
                    String dueno = sc.nextLine();
                    System.out.print("Teléfono del dueño: ");
                    String telDueno = sc.nextLine();

                    Mascota nuevaMascota = new Mascota(idMas, nomMas, espMas, razMas, edadMas, dueno, telDueno);
                    listaMascotas.add(nuevaMascota);
                    System.out.println("¡Mascota registrada correctamente!");
                    admin.gestionarMascotas();
                    
                    mascota.setIdMascota(idMas);
                    mascota.setNombre(nomMas);
                    mascota.setEspecie(espMas);
                    mascota.setRaza(razMas);
                    mascota.setEdad(edadMas);
                    mascota.setNombreDueno(dueno);
                    mascota.setTelefonoDueno(telDueno);
                    
                    break;

                case 2:
                    System.out.println("\n--- 2. AGENDAR CITA (CONSULTA) ---");
                    if (listaMascotas.isEmpty()) {
                        System.out.println("No hay mascotas registradas. Registre una mascota primero.");
                        break;
                    }

                    // Seleccionar Mascota
                    System.out.println("Seleccione una mascota:");
                    for (int i = 0; i < listaMascotas.size(); i++) {
                        System.out.println("[" + (i + 1) + "] " + listaMascotas.get(i).getNombre() + " (Dueño: " + listaMascotas.get(i).getNombreDueno() + ")");
                    }
                    System.out.print("Opción: ");
                    int idxMascota = sc.nextInt() - 1;
                    if (idxMascota < 0 || idxMascota >= listaMascotas.size()) {
                        System.out.println("Opción inválida.");
                        break;
                    }
                    Mascota mascotaSeleccionada = listaMascotas.get(idxMascota);

                    // Seleccionar Servicio
                    System.out.println("Seleccione el servicio médico:");
                    for (int i = 0; i < listaServicios.size(); i++) {
                        System.out.println("[" + (i + 1) + "] " + listaServicios.get(i).getNombreServicio() + " - $" + listaServicios.get(i).getPrecio());
                    }
                    System.out.print("Opción: ");
                    int idxServicio = sc.nextInt() - 1;
                    if (idxServicio < 0 || idxServicio >= listaServicios.size()) {
                        System.out.println("Opción inválida.");
                        break;
                    }
                    ServicioMedico servicioSeleccionado = listaServicios.get(idxServicio);

                    // Seleccionar Veterinario
                    System.out.println("Seleccione el veterinario:");
                    for (int i = 0; i < listaVeterinarios.size(); i++) {
                        System.out.println("[" + (i + 1) + "] " + listaVeterinarios.get(i).getNombre_Usuario() + " - " + listaVeterinarios.get(i).getEspecialidad());
                    }
                    System.out.print("Opción: ");
                    int idxVet = sc.nextInt() - 1;
                    if (idxVet < 0 || idxVet >= listaVeterinarios.size()) {
                        System.out.println("Opción inválida.");
                        break;
                    }
                    Veterinario veterinarioSeleccionado = listaVeterinarios.get(idxVet);

                    // Crear Consulta
                    Consulta nuevaConsulta = new Consulta(idConsultaCounter++, mascotaSeleccionada, veterinarioSeleccionado, servicioSeleccionado);
                    listaConsultas.add(nuevaConsulta);
                    System.out.println("¡Servicio agendado con éxito!");
                    nuevaConsulta.mostrarDatos();
                    break;

                case 3:
                    System.out.println("\n--- 3. ATENCIÓN DE CITA (REGISTRAR DIAGNÓSTICO) ---");
                    ArrayList<Consulta> agendadas = new ArrayList<>();
                    for (Consulta c : listaConsultas) {
                        if (c.getEstado().equals("Agendada")) {
                            agendadas.add(c);
                        }
                    }

                    if (agendadas.isEmpty()) {
                        System.out.println("No hay citas agendadas pendientes de atención.");
                        break;
                    }

                    System.out.println("Seleccione la consulta a atender:");
                    for (int i = 0; i < agendadas.size(); i++) {
                        Consulta c = agendadas.get(i);
                        System.out.println("[" + (i + 1) + "] ID " + c.getIdConsulta() + " - Mascota: " + c.getMascota().getNombre() + " | Servicio: " + c.getServicio().getNombreServicio());
                    }
                    System.out.print("Opción: ");
                    int idxAtender = sc.nextInt() - 1;
                    sc.nextLine(); // Consumir salto de línea

                    if (idxAtender < 0 || idxAtender >= agendadas.size()) {
                        System.out.println("Opción inválida.");
                        break;
                    }

                    Consulta consultaAAtender = agendadas.get(idxAtender);
                    System.out.print("Ingrese el diagnóstico para " + consultaAAtender.getMascota().getNombre() + ": ");
                    String diag = sc.nextLine();

                    consultaAAtender.atenderConsulta(diag);
                    break;

                case 4:
                    System.out.println("\n--- 4. COBRAR (GENERAR FACTURA) ---");
                    // Filtrar consultas atendidas (pendientes de pago)
                    ArrayList<Consulta> atendidas = new ArrayList<>();
                    for (Consulta c : listaConsultas) {
                        if (c.getEstado().equals("Atendida")) {
                            atendidas.add(c);
                        }
                    }

                    if (atendidas.isEmpty()) {
                        System.out.println("No hay consultas atendidas pendientes de cobro.");
                        break;
                    }

                    System.out.println("Seleccione la consulta para cobrar:");
                    for (int i = 0; i < atendidas.size(); i++) {
                        Consulta c = atendidas.get(i);
                        System.out.println("[" + (i + 1) + "] ID " + c.getIdConsulta() + " - Mascota: " + c.getMascota().getNombre() + " | Servicio: " + c.getServicio().getNombreServicio() + " ($" + c.getServicio().getPrecio() + ")");
                    }
                    System.out.print("Opción: ");
                    int idxCobrar = sc.nextInt() - 1;
                    sc.nextLine(); // Consumir salto de línea

                    if (idxCobrar < 0 || idxCobrar >= atendidas.size()) {
                        System.out.println("Opción inválida.");
                        break;
                    }

                    Consulta consultaACobrar = atendidas.get(idxCobrar);

                    System.out.println("Seleccione método de pago:");
                    System.out.println("[1] Efectivo");
                    System.out.println("[2] Tarjeta de Crédito/Débito");
                    System.out.println("[3] Transferencia Bancaria");
                    System.out.print("Opción: ");
                    int metPagoOpt = sc.nextInt();
                    sc.nextLine(); // Consumir salto de línea

                    String metPago;
                    switch (metPagoOpt) {
                        case 1: metPago = "Efectivo"; break;
                        case 2: metPago = "Tarjeta"; break;
                        case 3: metPago = "Transferencia"; break;
                        default: metPago = "Efectivo"; break;
                    }

                    // Registrar Pago y Generar Factura
                    Pago pagoFactura = new Pago(idFacturaCounter, new Date(), consultaACobrar.getServicio().getPrecio(), metPago);
                    pagoFactura.registrarPago();

                    Factura nuevaFactura = new Factura(idFacturaCounter++, consultaACobrar, metPago);
                    consultaACobrar.setEstado("Cobrada");
                    listaFacturas.add(nuevaFactura);

                    // Imprimir la Factura
                    nuevaFactura.imprimirFactura();

                    // Registrar en reportes del admin
                    ReporteAdministrador reporteFactura = new ReporteAdministrador(
                            "REP-" + nuevaFactura.getIdFactura(),
                            new Date(),
                            "Facturación de Consulta " + consultaACobrar.getIdConsulta() + " - " + consultaACobrar.getMascota().getNombre()
                    );
                    admin.gestionarReporte(reporteFactura);
                    break;

                case 5:
                    System.out.println("\n--- 5. REPORTE DEL ADMINISTRADOR ---");
                    admin.mostrarReportes();
                    break;

                case 6:
                    System.out.println("\n--- Lista de Mascotas ---");
                    if (listaMascotas.isEmpty()) {
                        System.out.println("No hay mascotas registradas en el sistema.");
                    } else {
                        // Recorremos la lista completa para mostrar todas las mascotas
                        for (Mascota m : listaMascotas) {
                            m.mostrarDatos();
                            System.out.println("-----------------------------------");
                        }
                    }
                    break;
                    
                case 7: 
                    admin.cerrarSesion();
                    System.out.println("Saliendo del sistema de la Clínica Veterinaria. ¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }

        } while (opcion != 7);

        sc.close();
    }
}
