/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_final_veterinaria;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
/**
 *
 * @author Jean Purizaga
 */
public class VentanaPrincipal extends JFrame{

    private ArrayList<Mascota> listaMascotas = new ArrayList<>();
    private ArrayList<Veterinario> listaVeterinarios = new ArrayList<>();
    private ArrayList<ServicioMedico> listaServicios = new ArrayList<>();
    private ArrayList<Consulta> listaConsultas = new ArrayList<>();
    private ArrayList<Factura> listaFacturas = new ArrayList<>();
    private int[] idConsultaCounter = {1};
    private int[] idFacturaCounter = {1};

    public VentanaPrincipal() {
        // Datos predefinidos
        listaVeterinarios.add(new Veterinario("V001", "Dr. Carlos Mendoza", "carlos@veterinaria.com", "1234", "Cirugía", "CM0987"));
        listaVeterinarios.add(new Veterinario("V002", "Dra. Ana Gómez", "ana@veterinaria.com", "5678", "Dermatología", "AG6543"));
        listaServicios.add(new ServicioMedico("S001", "Consulta General", 30.0));
        listaServicios.add(new ServicioMedico("S002", "Vacunación Anual", 25.0));
        listaServicios.add(new ServicioMedico("S003", "Desparasitación", 15.0));
        listaServicios.add(new ServicioMedico("S004", "Ecografía", 50.0));
        listaServicios.add(new ServicioMedico("S005", "Cirugía Menor", 120.0));
        listaMascotas.add(new Mascota("M001", "Toby", "Perro", "Golden Retriever", 3, "Juan Pérez", "987654321"));
        listaMascotas.add(new Mascota("M002", "Luna", "Gato", "Siamés", 2, "María López", "912345678"));

        setTitle("Clínica Veterinaria - Sistema de Gestión");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.setBackground(new Color(240, 248, 255));

        // Header
        JPanel panelHeader = new JPanel();
        panelHeader.setBackground(new Color(33, 97, 140));
        panelHeader.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        JLabel lblTitulo = new JLabel("Clínica Veterinaria");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitulo.setForeground(Color.WHITE);
        panelHeader.add(lblTitulo);

        // Botones
        JPanel panelBotones = new JPanel(new GridLayout(5, 1, 10, 10));
        panelBotones.setBackground(new Color(240, 248, 255));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(30, 80, 30, 80));

        JButton btn1 = crearBoton("1. Registrar Mascota");
        JButton btn2 = crearBoton("2. Agendar Servicio (Consulta)");
        JButton btn3 = crearBoton("3. Atender Consulta");
        JButton btn4 = crearBoton("4. Cobrar (Generar Factura)");
        JButton btn5 = crearBoton("5. Ver Reporte del Administrador");

        btn1.addActionListener(e -> new FormRegistrarMascota(listaMascotas).setVisible(true));
        btn2.addActionListener(e -> new FormAgendarConsulta(listaMascotas, listaVeterinarios, listaServicios, listaConsultas, idConsultaCounter).setVisible(true));
        btn3.addActionListener(e -> new FormAtenderConsulta(listaConsultas).setVisible(true));

        panelBotones.add(btn1);
        panelBotones.add(btn2);
        panelBotones.add(btn3);
        panelBotones.add(btn4);
        panelBotones.add(btn5);

        // Footer
        JPanel panelFooter = new JPanel();
        panelFooter.setBackground(new Color(33, 97, 140));
        JLabel lblFooter = new JLabel("Sistema de Gestión Veterinaria v1.0");
        lblFooter.setForeground(Color.WHITE);
        lblFooter.setFont(new Font("Arial", Font.ITALIC, 11));
        panelFooter.add(lblFooter);

        panelPrincipal.add(panelHeader, BorderLayout.NORTH);
        panelPrincipal.add(panelBotones, BorderLayout.CENTER);
        panelPrincipal.add(panelFooter, BorderLayout.SOUTH);

        add(panelPrincipal);
    }

    private JButton crearBoton(String texto) {
        JButton btn = new JButton(texto);
        btn.setFont(new Font("Arial", Font.PLAIN, 14));
        btn.setBackground(new Color(52, 152, 219));
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));
        return btn;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new VentanaPrincipal().setVisible(true);
        });
    }
}
