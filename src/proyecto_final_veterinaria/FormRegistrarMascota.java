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

    private JTextField txtId, txtNombre, txtEspecie, txtRaza, txtEdad, txtDueno, txtPaterno, txtMaterno, txtTelefono;

    public FormRegistrarMascota(ArrayList<Mascota> listaMascotas) {
        this.listaMascotas = listaMascotas;

        setTitle("Registrar Mascota");
        setSize(600, 350);
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
        JLabel lblTitulo = new JLabel(" Registrar Nueva Mascota");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        lblTitulo.setForeground(Color.WHITE);
        header.add(lblTitulo);

        // Formulario
        JPanel formulario = new JPanel(new GridLayout(1, 2, 15, 10));
        formulario.setBackground(new Color(240, 248, 255));
        formulario.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));

        JPanel panelMascota = new JPanel(new GridLayout(5, 2, 10, 10));
        panelMascota.setBackground(new Color(240, 248, 255));
        panelMascota.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY), "Datos de la Mascota", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new Font("Arial", Font.BOLD, 12), Color.BLACK));

        JPanel panelDueno = new JPanel(new GridLayout(4, 2, 10, 10));
        panelDueno.setBackground(new Color(240, 248, 255));
        panelDueno.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY), "Datos del Dueño", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new Font("Arial", Font.BOLD, 12), Color.BLACK));
        
        JPanel panelDuenoWrapper = new JPanel(new BorderLayout());
        panelDuenoWrapper.setBackground(new Color(240, 248, 255));
        panelDuenoWrapper.add(panelDueno, BorderLayout.NORTH);

        txtId       = new JTextField();
        txtNombre   = new JTextField();
        txtEspecie  = new JTextField();
        txtRaza     = new JTextField();
        txtEdad     = new JTextField();
        txtDueno    = new JTextField();
        txtPaterno  = new JTextField();
        txtMaterno  = new JTextField();
        txtTelefono = new JTextField();

        panelMascota.add(new JLabel("ID Mascota:"));        panelMascota.add(txtId);
        panelMascota.add(new JLabel("Nombre:"));            panelMascota.add(txtNombre);
        panelMascota.add(new JLabel("Especie:"));           panelMascota.add(txtEspecie);
        panelMascota.add(new JLabel("Raza:"));              panelMascota.add(txtRaza);
        panelMascota.add(new JLabel("Edad (años):"));       panelMascota.add(txtEdad);

        panelDueno.add(new JLabel("Nombre:"));              panelDueno.add(txtDueno);
        panelDueno.add(new JLabel("Ap. Paterno:"));         panelDueno.add(txtPaterno);
        panelDueno.add(new JLabel("Ap. Materno:"));         panelDueno.add(txtMaterno);
        panelDueno.add(new JLabel("Teléfono:"));            panelDueno.add(txtTelefono);

        formulario.add(panelMascota);
        formulario.add(panelDuenoWrapper);

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
                String paterno= txtPaterno.getText().trim();
                String materno= txtMaterno.getText().trim();
                String tel    = txtTelefono.getText().trim();
                String edadTxt= txtEdad.getText().trim();

                if (id.isEmpty() || nombre.isEmpty() || especie.isEmpty() ||
                    raza.isEmpty() || dueno.isEmpty() || paterno.isEmpty() || materno.isEmpty() || tel.isEmpty() || edadTxt.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor complete todos los campos.", "Campos vacíos", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                // Validar que el ID de la mascota sea alfanumérico
                if (!id.matches("^[a-zA-Z0-9]+$")) {
                    JOptionPane.showMessageDialog(null, "El ID de la mascota debe ser alfanumérico (letras y números sin espacios).", "Error de validación", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Validar que el nombre de la mascota contenga solo letras y espacios
                if (!nombre.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
                    JOptionPane.showMessageDialog(null, "El nombre de la mascota solo debe contener letras y espacios.", "Error de validación", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Validar que la especie contenga solo letras y espacios
                if (!especie.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
                    JOptionPane.showMessageDialog(null, "La especie solo debe contener letras y espacios.", "Error de validación", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Validar que la raza contenga solo letras y espacios
                if (!raza.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
                    JOptionPane.showMessageDialog(null, "La raza solo debe contener letras y espacios.", "Error de validación", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Validar que el nombre del dueño contenga solo letras y espacios
                if (!dueno.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
                    JOptionPane.showMessageDialog(null, "El nombre del dueño solo debe contener letras y espacios.", "Error de validación", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (!paterno.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
                    JOptionPane.showMessageDialog(null, "El apellido paterno del dueño solo debe contener letras y espacios.", "Error de validación", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (!materno.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
                    JOptionPane.showMessageDialog(null, "El apellido materno del dueño solo debe contener letras y espacios.", "Error de validación", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Validar que el número de celular del dueño tenga exactamente 9 dígitos
                if (tel.length() != 9 || !tel.matches("\\d+")) {
                    JOptionPane.showMessageDialog(null, "El número de celular debe tener exactamente 9 dígitos.", "Error de validación", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Validar que el ID de la mascota no esté duplicado
                for (Mascota m : listaMascotas) {
                    if (m.getIdMascota().equalsIgnoreCase(id)) {
                        JOptionPane.showMessageDialog(null, "El ID de la mascota ya está registrado. Por favor, use otro ID.", "ID Duplicado", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }

                int edad;
                try {
                    edad = Integer.parseInt(edadTxt);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "La edad debe ser un número entero.", "Error de validación", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Validar rango lógico para la edad de la mascota
                if (edad < 0 || edad > 35) {
                    JOptionPane.showMessageDialog(null, "La edad de la mascota debe estar entre 0 y 35 años.", "Error de validación", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Mascota nueva = new Mascota(id, nombre, especie, raza, edad, dueno, paterno, materno, tel);
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
        txtPaterno.setText("");
        txtMaterno.setText("");
        txtTelefono.setText("");
    }

    // Para probar solo este formulario
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new FormRegistrarMascota(new ArrayList<>()).setVisible(true);
        });
    }
}