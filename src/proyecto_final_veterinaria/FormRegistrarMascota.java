/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_final_veterinaria;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 *
 * @author Jean Purizaga
 */
public class FormRegistrarMascota extends JFrame {

    private ArrayList<Mascota> listaMascotas;

    private JTextField txtId, txtNombre, txtEspecie, txtRaza, txtEdad, txtDueno, txtTelefono;

    public FormRegistrarMascota(ArrayList<Mascota> listaMascotas) {
        this.listaMascotas = listaMascotas;

        setTitle("Registrar Mascota");
        setSize(420, 420);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Panel principal
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(240, 248, 255));

        // Header
        JPanel header = new JPanel();
        header.setBackground(new Color(33, 97, 140));
        header.setBorder(BorderFactory.createEmptyBorder(12, 20, 12, 20));
        JLabel lblTitulo = new JLabel("🐾 Registrar Nueva Mascota");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        lblTitulo.setForeground(Color.WHITE);
        header.add(lblTitulo);

        // Formulario
        JPanel formulario = new JPanel(new GridLayout(7, 2, 10, 10));
        formulario.setBackground(new Color(240, 248, 255));
        formulario.setBorder(BorderFactory.createEmptyBorder(20, 30, 10, 30));

        txtId       = new JTextField();
        txtNombre   = new JTextField();
        txtEspecie  = new JTextField();
        txtRaza     = new JTextField();
        txtEdad     = new JTextField();
        txtDueno    = new JTextField();
        txtTelefono = new JTextField();

        formulario.add(new JLabel("ID Mascota:"));        formulario.add(txtId);
        formulario.add(new JLabel("Nombre:"));            formulario.add(txtNombre);
        formulario.add(new JLabel("Especie:"));           formulario.add(txtEspecie);
        formulario.add(new JLabel("Raza:"));              formulario.add(txtRaza);
        formulario.add(new JLabel("Edad (años):"));       formulario.add(txtEdad);
        formulario.add(new JLabel("Nombre del dueño:"));  formulario.add(txtDueno);
        formulario.add(new JLabel("Teléfono del dueño:")); formulario.add(txtTelefono);

        // Botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        panelBotones.setBackground(new Color(240, 248, 255));

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBackground(new Color(39, 174, 96));
        btnGuardar.setForeground(Color.WHITE);
        btnGuardar.setFocusPainted(false);
        btnGuardar.setFont(new Font("Arial", Font.BOLD, 13));
        btnGuardar.setCursor(new Cursor(Cursor.HAND_CURSOR));

        JButton btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setBackground(new Color(231, 76, 60));
        btnLimpiar.setForeground(Color.WHITE);
        btnLimpiar.setFocusPainted(false);
        btnLimpiar.setFont(new Font("Arial", Font.BOLD, 13));
        btnLimpiar.setCursor(new Cursor(Cursor.HAND_CURSOR));

        panelBotones.add(btnGuardar);
        panelBotones.add(btnLimpiar);

        // Acción Guardar
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id     = txtId.getText().trim();
                String nombre = txtNombre.getText().trim();
                String especie= txtEspecie.getText().trim();
                String raza   = txtRaza.getText().trim();
                String dueno  = txtDueno.getText().trim();
                String tel    = txtTelefono.getText().trim();
                String edadTxt= txtEdad.getText().trim();

                if (id.isEmpty() || nombre.isEmpty() || especie.isEmpty() ||
                    raza.isEmpty() || dueno.isEmpty() || tel.isEmpty() || edadTxt.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor complete todos los campos.", "Campos vacíos", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                int edad;
                try {
                    edad = Integer.parseInt(edadTxt);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "La edad debe ser un número.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Mascota nueva = new Mascota(id, nombre, especie, raza, edad, dueno, tel);
                listaMascotas.add(nueva);
                JOptionPane.showMessageDialog(null, "¡Mascota registrada correctamente!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                limpiarCampos();
            }
        });

        // Acción Limpiar
        btnLimpiar.addActionListener(e -> limpiarCampos());

        panel.add(header, BorderLayout.NORTH);
        panel.add(formulario, BorderLayout.CENTER);
        panel.add(panelBotones, BorderLayout.SOUTH);

        add(panel);
    }

    private void limpiarCampos() {
        txtId.setText("");
        txtNombre.setText("");
        txtEspecie.setText("");
        txtRaza.setText("");
        txtEdad.setText("");
        txtDueno.setText("");
        txtTelefono.setText("");
    }

    // Para probar solo este formulario
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new FormRegistrarMascota(new ArrayList<>()).setVisible(true);
        });
    }
}
