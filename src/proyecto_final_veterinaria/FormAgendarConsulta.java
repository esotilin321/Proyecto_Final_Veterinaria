/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_final_veterinaria;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 *
 * @author Jean Purizaga
 */
public class FormAgendarConsulta extends JFrame {

    private ArrayList<Mascota> listaMascotas;
    private ArrayList<Veterinario> listaVeterinarios;
    private ArrayList<ServicioMedico> listaServicios;
    private ArrayList<Consulta> listaConsultas;
    private int[] idConsultaCounter;

    private JComboBox<String> cbMascota, cbServicio, cbVeterinario;

    public FormAgendarConsulta(ArrayList<Mascota> listaMascotas,
    ArrayList<Veterinario> listaVeterinarios,
    ArrayList<ServicioMedico> listaServicios,
    ArrayList<Consulta> listaConsultas,
    int[] idConsultaCounter) {
        this.listaMascotas = listaMascotas;
        this.listaVeterinarios = listaVeterinarios;
        this.listaServicios = listaServicios;
        this.listaConsultas = listaConsultas;
        this.idConsultaCounter = idConsultaCounter;

        setTitle("Agendar Consulta");
        setSize(420, 320);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(240, 248, 255));

        // Header
        JPanel header = new JPanel();
        header.setBackground(new Color(33, 97, 140));
        header.setBorder(BorderFactory.createEmptyBorder(12, 20, 12, 20));
        JLabel lblTitulo = new JLabel("📋 Agendar Servicio / Consulta");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        lblTitulo.setForeground(Color.WHITE);
        header.add(lblTitulo);

        // Formulario
        JPanel formulario = new JPanel(new GridLayout(3, 2, 10, 15));
        formulario.setBackground(new Color(240, 248, 255));
        formulario.setBorder(BorderFactory.createEmptyBorder(25, 30, 15, 30));

        // ComboBox Mascotas
        cbMascota = new JComboBox<>();
        for (Mascota m : listaMascotas) {
            cbMascota.addItem(m.getNombre() + " (" + m.getNombreDueno() + ")");
        }

        // ComboBox Servicios
        cbServicio = new JComboBox<>();
        for (ServicioMedico s : listaServicios) {
            cbServicio.addItem(s.getNombreServicio() + " - $" + s.getPrecio());
        }

        // ComboBox Veterinarios
        cbVeterinario = new JComboBox<>();
        for (Veterinario v : listaVeterinarios) {
            cbVeterinario.addItem(v.getNombre_Usuario() + " - " + v.getEspecialidad());
        }

        formulario.add(new JLabel("Mascota:"));      formulario.add(cbMascota);
        formulario.add(new JLabel("Servicio:"));     formulario.add(cbServicio);
        formulario.add(new JLabel("Veterinario:"));  formulario.add(cbVeterinario);

        // Botón Agendar
        JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        panelBoton.setBackground(new Color(240, 248, 255));

        JButton btnAgendar = new JButton("Agendar Consulta");
        btnAgendar.setBackground(new Color(39, 174, 96));
        btnAgendar.setForeground(Color.WHITE);
        btnAgendar.setFocusPainted(false);
        btnAgendar.setFont(new Font("Arial", Font.BOLD, 13));
        btnAgendar.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btnAgendar.addActionListener(e -> {
            if (listaMascotas.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No hay mascotas registradas. Registre una primero.", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }

            int idxMascota = cbMascota.getSelectedIndex();
            int idxServicio = cbServicio.getSelectedIndex();
            int idxVeterinario = cbVeterinario.getSelectedIndex();

            if (idxMascota == -1) {
                JOptionPane.showMessageDialog(null, "Por favor, seleccione una mascota.", "Falta selección", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (idxServicio == -1) {
                JOptionPane.showMessageDialog(null, "Por favor, seleccione un servicio.", "Falta selección", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (idxVeterinario == -1) {
                JOptionPane.showMessageDialog(null, "Por favor, seleccione un veterinario.", "Falta selección", JOptionPane.WARNING_MESSAGE);
                return;
            }

            Mascota mascota = listaMascotas.get(idxMascota);
            ServicioMedico servicio = listaServicios.get(idxServicio);
            Veterinario veterinario = listaVeterinarios.get(idxVeterinario);

            Consulta nueva = new Consulta(idConsultaCounter[0]++, mascota, veterinario, servicio);
            listaConsultas.add(nueva);

            JOptionPane.showMessageDialog(null,
                "¡Consulta agendada con éxito!\n" +
                "Mascota: " + mascota.getNombre() + "\n" +
                "Servicio: " + servicio.getNombreServicio() + "\n" +
                "Veterinario: " + veterinario.getNombre_Usuario(),
                "Consulta Agendada", JOptionPane.INFORMATION_MESSAGE);
        });

        panelBoton.add(btnAgendar);

        panel.add(header, BorderLayout.NORTH);
        panel.add(formulario, BorderLayout.CENTER);
        panel.add(panelBoton, BorderLayout.SOUTH);

        add(panel);
    }
}
