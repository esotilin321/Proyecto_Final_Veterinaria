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
public class FormAtenderConsulta extends JFrame {

    private ArrayList<Consulta> listaConsultas;
    private JComboBox<String> cbConsultas;
    private JTextArea txtDiagnostico;

    public FormAtenderConsulta(ArrayList<Consulta> listaConsultas) {
        this.listaConsultas = listaConsultas;

        setTitle("Atender Consulta");
        setSize(450, 350);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(240, 248, 255));

        // Header
        JPanel header = new JPanel();
        header.setBackground(new Color(33, 97, 140));
        header.setBorder(BorderFactory.createEmptyBorder(12, 20, 12, 20));
        JLabel lblTitulo = new JLabel("🩺 Atender Consulta");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        lblTitulo.setForeground(Color.WHITE);
        header.add(lblTitulo);

        // Formulario
        JPanel formulario = new JPanel(new GridLayout(4, 1, 10, 10));
        formulario.setBackground(new Color(240, 248, 255));
        formulario.setBorder(BorderFactory.createEmptyBorder(20, 30, 10, 30));

        // ComboBox con consultas agendadas
        cbConsultas = new JComboBox<>();
        cargarConsultasAgendadas();

        JLabel lblConsulta = new JLabel("Seleccione la consulta a atender:");
        lblConsulta.setFont(new Font("Arial", Font.PLAIN, 13));

        JLabel lblDiag = new JLabel("Diagnóstico:");
        lblDiag.setFont(new Font("Arial", Font.PLAIN, 13));

        txtDiagnostico = new JTextArea(3, 20);
        txtDiagnostico.setLineWrap(true);
        txtDiagnostico.setWrapStyleWord(true);
        txtDiagnostico.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        JScrollPane scroll = new JScrollPane(txtDiagnostico);

        formulario.add(lblConsulta);
        formulario.add(cbConsultas);
        formulario.add(lblDiag);
        formulario.add(scroll);

        // Botón
        JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        panelBoton.setBackground(new Color(240, 248, 255));

        JButton btnAtender = new JButton("Registrar Diagnóstico");
        btnAtender.setBackground(new Color(39, 174, 96));
        btnAtender.setForeground(Color.WHITE);
        btnAtender.setFocusPainted(false);
        btnAtender.setFont(new Font("Arial", Font.BOLD, 13));
        btnAtender.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btnAtender.addActionListener(e -> {
            // Filtrar consultas agendadas
            ArrayList<Consulta> agendadas = new ArrayList<>();
            for (Consulta c : listaConsultas) {
                if (c.getEstado().equals("Agendada")) agendadas.add(c);
            }

            if (agendadas.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No hay consultas agendadas pendientes.", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }

            String diagnostico = txtDiagnostico.getText().trim();
            if (diagnostico.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor ingrese un diagnóstico.", "Campo vacío", JOptionPane.WARNING_MESSAGE);
                return;
            }

            Consulta consulta = agendadas.get(cbConsultas.getSelectedIndex());
            consulta.atenderConsulta(diagnostico);

            JOptionPane.showMessageDialog(null,
                "¡Consulta atendida correctamente!\n" +
                "Mascota: " + consulta.getMascota().getNombre() + "\n" +
                "Diagnóstico: " + diagnostico,
                "Consulta Atendida", JOptionPane.INFORMATION_MESSAGE);

            txtDiagnostico.setText("");
            cargarConsultasAgendadas();
        });

        panelBoton.add(btnAtender);

        panel.add(header, BorderLayout.NORTH);
        panel.add(formulario, BorderLayout.CENTER);
        panel.add(panelBoton, BorderLayout.SOUTH);

        add(panel);
    }

    private void cargarConsultasAgendadas() {
        cbConsultas.removeAllItems();
        for (Consulta c : listaConsultas) {
            if (c.getEstado().equals("Agendada")) {
                cbConsultas.addItem("ID " + c.getIdConsulta() + " - " + c.getMascota().getNombre() + " | " + c.getServicio().getNombreServicio());
            }
        }
    }
}
