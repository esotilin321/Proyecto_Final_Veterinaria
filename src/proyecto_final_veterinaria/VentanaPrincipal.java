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
public class VentanaPrincipal extends JFrame {

    private ArrayList<Mascota> listaMascotas = new ArrayList<>();
    private ArrayList<Veterinario> listaVeterinarios = new ArrayList<>();
    private ArrayList<ServicioMedico> listaServicios = new ArrayList<>();
    private ArrayList<Consulta> listaConsultas = new ArrayList<>();
    private ArrayList<Factura> listaFacturas = new ArrayList<>();
    
    private ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    
    private int[] idConsultaCounter = {1};
    private int[] idFacturaCounter = {1};
    private JTabbedPane tabbedPane;
    private JPanel panelSistema;

    public VentanaPrincipal() {
        // Datos predefinidos
        Veterinario v1 = new Veterinario("V001", "Dr. Chesster Benhinthon", "chester.benhinthon@veterinaria.com", "1234", "Cirugía", "450987");
        Veterinario v2 = new Veterinario("V002", "Dra. Amy Lee", "amy.lee@veterinaria.com", "5678", "Dermatología", "121452");
        Veterinario v3 = new Veterinario("V003", "Dr. James Root", "james.root@veterinaria.com", "7066", "Cardiología", "750024");
        Veterinario v4 = new Veterinario("V004", "Dr. Mick Thomson", "mick.thomson@veterinaria.com", "0777", "Cirugía", "015464");
        Veterinario v5 = new Veterinario("V005", "Dra. Treisy Clavo", "trisy.clavo@veterinaria.com", "0555", "Neurología", "301105");
        Veterinario v6 = new Veterinario("V006", "Dra. Emily Amstron", "emily.amstron@veterinaria.com", "0545", "Anestesiología", "487641");
        Veterinario v7 = new Veterinario("V007", "Dr. Carlos Mendoza", "carlos.mendoza@veterinaria.com", "0654", "General", "987321");
        
        listaVeterinarios.add(v1);
        listaVeterinarios.add(v2);
        listaVeterinarios.add(v3);
        listaVeterinarios.add(v4);
        listaVeterinarios.add(v5);
        listaVeterinarios.add(v6);
        listaVeterinarios.add(v7);
        
        listaServicios.add(new ServicioMedico("S001", "Consulta General", 30.0));
        listaServicios.add(new ServicioMedico("S002", "Vacunación Anual", 25.0));
        listaServicios.add(new ServicioMedico("S003", "Desparasitación", 15.0));
        listaServicios.add(new ServicioMedico("S004", "Ecografía", 50.0));
        listaServicios.add(new ServicioMedico("S005", "Cirugía Menor", 120.0));

        setTitle("Clínica Veterinaria - Sistema de Gestión");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        tabbedPane = new JTabbedPane();

        // Pestaña 1: Acceso (Login / Registro)
        JPanel panelAcceso = crearPanelAcceso();
        tabbedPane.addTab("Acceso", panelAcceso);

        // Pestaña 2: Sistema (Menú Principal)
        panelSistema = crearPanelSistema();
        tabbedPane.addTab("Sistema", panelSistema);
        tabbedPane.setEnabledAt(1, false); // Deshabilitado hasta que inicie sesión

        add(tabbedPane);
    }
    
    private JPanel crearPanelAcceso() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(240, 248, 255));

        CardLayout cardLayout = new CardLayout();
        JPanel panelCards = new JPanel(cardLayout);
        panelCards.setBackground(new Color(240, 248, 255));

        //Selección inicial
        JPanel pnlOpciones = new JPanel(new GridBagLayout());
        pnlOpciones.setBackground(new Color(240, 248, 255));
        JButton btnIrLogin = crearBoton("Iniciar Sesión");
        JButton btnIrRegistro = crearBoton("Registrar");
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0; gbc.gridy = 0;
        pnlOpciones.add(btnIrLogin, gbc);
        gbc.gridy = 1;
        pnlOpciones.add(btnIrRegistro, gbc);

        //Login
        JPanel pnlLogin = new JPanel(new GridBagLayout());
        pnlLogin.setBackground(new Color(240, 248, 255));
        JTextField txtCorreoLogin = new JTextField(15);
        JPasswordField txtPassLogin = new JPasswordField(15);
        JButton btnEntrar = crearBoton("Entrar");
        JButton btnVolverL = crearBoton("Volver");

        GridBagConstraints gl = new GridBagConstraints();
        gl.insets = new Insets(5, 5, 5, 5);
        gl.gridx = 0; gl.gridy = 0; pnlLogin.add(new JLabel("Correo:"), gl);
        gl.gridx = 1; pnlLogin.add(txtCorreoLogin, gl);
        gl.gridx = 0; gl.gridy = 1; pnlLogin.add(new JLabel("Contraseña:"), gl);
        gl.gridx = 1; pnlLogin.add(txtPassLogin, gl);
        gl.gridx = 0; gl.gridy = 2; gl.gridwidth = 2; pnlLogin.add(btnEntrar, gl);
        gl.gridy = 3; pnlLogin.add(btnVolverL, gl);

        // Registro
        JPanel pnlRegistro = new JPanel(new BorderLayout());
        pnlRegistro.setBackground(new Color(240, 248, 255));
        
        JPanel pnlNorteReg = new JPanel();
        pnlNorteReg.setBackground(new Color(240, 248, 255));
        pnlNorteReg.add(new JLabel("Tipo de Usuario:"));
        JComboBox<String> cbTipoUsuario = new JComboBox<>(new String[]{"Dueño", "Veterinario", "Administrador"});
        pnlNorteReg.add(cbTipoUsuario);
        
        JPanel pnlCentroReg = new JPanel(new GridBagLayout());
        pnlCentroReg.setBackground(new Color(240, 248, 255));
        
        JTextField txtId = new JTextField(12);
        JComboBox<String> cbTipoDoc = new JComboBox<>(new String[]{"DNI", "CE"});
        JTextField txtNroDoc = new JTextField(12);
        JTextField txtNombre = new JTextField(12);
        JTextField txtPaterno = new JTextField(12);
        JTextField txtMaterno = new JTextField(12);
        JTextField txtTelefono = new JTextField(12);
        JTextField txtCorreo = new JTextField(12);
        JPasswordField txtPass = new JPasswordField(12);
        
        // agregar tributos específicos
        JTextField txtEspecialidad = new JTextField(12);
        JTextField txtColegiatura = new JTextField(12);
        
        JLabel lblEspecialidad = new JLabel("Especialidad:");
        JLabel lblColegiatura = new JLabel("Nro Colegiatura:");
        
        Runnable actualizarCampos = () -> {
            pnlCentroReg.removeAll();
            GridBagConstraints gr = new GridBagConstraints();
            gr.insets = new Insets(5,5,5,5);
            gr.anchor = GridBagConstraints.WEST;
            
            // Fila 0
            gr.gridx = 0; gr.gridy = 0; pnlCentroReg.add(new JLabel("ID Usuario:"), gr);
            gr.gridx = 1; pnlCentroReg.add(txtId, gr);
            gr.gridx = 2; pnlCentroReg.add(new JLabel("Tipo Doc:"), gr);
            gr.gridx = 3; pnlCentroReg.add(cbTipoDoc, gr);
            
            // Fila 1
            gr.gridx = 0; gr.gridy = 1; pnlCentroReg.add(new JLabel("Nombre:"), gr);
            gr.gridx = 1; pnlCentroReg.add(txtNombre, gr);
            gr.gridx = 2; pnlCentroReg.add(new JLabel("Nro Doc:"), gr);
            gr.gridx = 3; pnlCentroReg.add(txtNroDoc, gr);
            
            // Fila 2
            gr.gridx = 0; gr.gridy = 2; pnlCentroReg.add(new JLabel("Ap. Paterno:"), gr);
            gr.gridx = 1; pnlCentroReg.add(txtPaterno, gr);
            gr.gridx = 2; pnlCentroReg.add(new JLabel("Ap. Materno:"), gr);
            gr.gridx = 3; pnlCentroReg.add(txtMaterno, gr);
            
            // Fila 3
            gr.gridx = 0; gr.gridy = 3; pnlCentroReg.add(new JLabel("Correo:"), gr);
            gr.gridx = 1; pnlCentroReg.add(txtCorreo, gr);
            gr.gridx = 2; pnlCentroReg.add(new JLabel("Teléfono:"), gr);
            gr.gridx = 3; pnlCentroReg.add(txtTelefono, gr);
            
            // Fila 4
            gr.gridx = 0; gr.gridy = 4; pnlCentroReg.add(new JLabel("Contraseña:"), gr);
            gr.gridx = 1; pnlCentroReg.add(txtPass, gr);
            
            String tipo = (String) cbTipoUsuario.getSelectedItem();
            if ("Veterinario".equals(tipo)) {
                gr.gridx = 2; gr.gridy = 4; pnlCentroReg.add(lblEspecialidad, gr);
                gr.gridx = 3; pnlCentroReg.add(txtEspecialidad, gr);
                gr.gridx = 0; gr.gridy = 5; pnlCentroReg.add(lblColegiatura, gr);
                gr.gridx = 1; pnlCentroReg.add(txtColegiatura, gr);
            }
            pnlCentroReg.revalidate();
            pnlCentroReg.repaint();
        };
        
        cbTipoUsuario.addActionListener(e -> actualizarCampos.run());
        actualizarCampos.run(); 
        
        JPanel pnlSurReg = new JPanel();
        pnlSurReg.setBackground(new Color(240, 248, 255));
        JButton btnGuardarReg = crearBoton("Registrarse");
        JButton btnVolverR = crearBoton("Volver");
        pnlSurReg.add(btnGuardarReg);
        pnlSurReg.add(btnVolverR);
        
        pnlRegistro.add(pnlNorteReg, BorderLayout.NORTH);
        pnlRegistro.add(pnlCentroReg, BorderLayout.CENTER);
        pnlRegistro.add(pnlSurReg, BorderLayout.SOUTH);

        // Agregar 
        panelCards.add(pnlOpciones, "Opciones");
        panelCards.add(pnlLogin, "Login");
        panelCards.add(pnlRegistro, "Registro");
        btnIrLogin.addActionListener(e -> cardLayout.show(panelCards, "Login"));
        btnIrRegistro.addActionListener(e -> cardLayout.show(panelCards, "Registro"));
        btnVolverL.addActionListener(e -> cardLayout.show(panelCards, "Opciones"));
        btnVolverR.addActionListener(e -> cardLayout.show(panelCards, "Opciones"));

        btnEntrar.addActionListener(e -> {
            String correo = txtCorreoLogin.getText();
            String pass = new String(txtPassLogin.getPassword());
            boolean auth = false;
            for (Usuario u : listaUsuarios) {
                if (u.getCorreo_Usuario().equals(correo) && u.getContraseña_Usuario().equals(pass)) {
                    auth = true;
                    u.iniciarSesion();
                    break;
                }
            }
            if (auth) {
                JOptionPane.showMessageDialog(this, "Bienvenido al sistema.");
                tabbedPane.setEnabledAt(1, true);
                tabbedPane.setSelectedIndex(1); // Ir a la pestaña del sistema
            } else {
                JOptionPane.showMessageDialog(this, "Credenciales incorrectas.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnGuardarReg.addActionListener(e -> {
            String tipo = (String) cbTipoUsuario.getSelectedItem();
            String id = txtId.getText();
            String nom = txtNombre.getText();
            String corr = txtCorreo.getText();
            String pass = new String(txtPass.getPassword());
            
            if (id.isEmpty() || nom.isEmpty() || corr.isEmpty() || pass.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Llene los campos básicos (ID, Nombre, Correo, Contraseña).", "Error", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            // Validar ID único
            for (Usuario u : listaUsuarios) {
                if (u.getIdUsuario().equals(id)) {
                    JOptionPane.showMessageDialog(this, "El ID de Usuario ya existe. Por favor ingrese uno diferente.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            // Validar Tipo de Documento
            String tipoDoc = (String) cbTipoDoc.getSelectedItem();
            String nroDoc = txtNroDoc.getText();
            if ("DNI".equals(tipoDoc) && !nroDoc.matches("\\d{8}")) {
                JOptionPane.showMessageDialog(this, "El DNI debe tener exactamente 8 dígitos numéricos.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } else if ("CE".equals(tipoDoc) && !nroDoc.matches("\\d{9}")) {
                JOptionPane.showMessageDialog(this, "El CE debe tener exactamente 9 dígitos numéricos.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Validar Teléfono
            String telefono = txtTelefono.getText();
            if (!telefono.matches("\\d{9}")) {
                JOptionPane.showMessageDialog(this, "El teléfono debe tener exactamente 9 dígitos numéricos.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Validar Correo
            if (!corr.contains("@") || !corr.contains(".com")) {
                JOptionPane.showMessageDialog(this, "El correo debe contener '@' y '.com'.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Validar Contraseña con caracter especial
            if (!pass.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*")) {
                JOptionPane.showMessageDialog(this, "La contraseña debe contener al menos un carácter especial.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            Usuario nuevoUsuario = null;
            if ("Dueño".equals(tipo)) {
                nuevoUsuario = new Dueño(id, nom, corr, pass);
                listaUsuarios.add(nuevoUsuario);
            } else if ("Administrador".equals(tipo)) {
                nuevoUsuario = new Administrador(id, nom, corr, pass);
                listaUsuarios.add(nuevoUsuario);
            } else if ("Veterinario".equals(tipo)) {
                String esp = txtEspecialidad.getText();
                String col = txtColegiatura.getText();
                Veterinario v = new Veterinario(id, nom, corr, pass, esp, col);
                nuevoUsuario = v;
                listaUsuarios.add(v);
                listaVeterinarios.add(v);
            }
            
            if (nuevoUsuario != null) {
                nuevoUsuario.setTipo_documento((String) cbTipoDoc.getSelectedItem());
                nuevoUsuario.setNro_documento(txtNroDoc.getText());
                nuevoUsuario.setPaterno(txtPaterno.getText());
                nuevoUsuario.setMaterno(txtMaterno.getText());
                nuevoUsuario.setTelefono(txtTelefono.getText());
            }
            
            JOptionPane.showMessageDialog(this, "Usuario registrado con éxito. Ahora puede Iniciar Sesión.");
            cardLayout.show(panelCards, "Login");
            txtCorreoLogin.setText(corr);
        });

        panel.add(panelCards, BorderLayout.CENTER);
        return panel;
    }
    
    private JPanel crearPanelSistema() {
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.setBackground(new Color(240, 248, 255));

        // Header
        JPanel panelHeader = new JPanel();
        panelHeader.setBackground(new Color(33, 97, 140));
        panelHeader.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        JLabel lblTitulo = new JLabel("Clínica Veterinaria - Menú");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitulo.setForeground(Color.WHITE);
        panelHeader.add(lblTitulo);

        // Botones
        JPanel panelBotones = new JPanel(new GridLayout(6, 1, 10, 10));
        panelBotones.setBackground(new Color(240, 248, 255));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(20, 80, 20, 80));

        JButton btn1 = crearBoton("1. Registrar Mascota");
        JButton btn2 = crearBoton("2. Agendar Servicio (Consulta)");
        JButton btn3 = crearBoton("3. Atender Consulta");
        JButton btn4 = crearBoton("4. Cobrar (Generar Factura)");
        JButton btn5 = crearBoton("5. Ver Reporte del Administrador");
        JButton btnCerrarSesion = crearBoton("Cerrar Sesión");
        btnCerrarSesion.setBackground(new Color(231, 76, 60)); // Color rojo

        btn1.addActionListener(e -> new FormRegistrarMascota(listaMascotas).setVisible(true));
        btn2.addActionListener(e -> new FormAgendarConsulta(listaMascotas, listaVeterinarios, listaServicios, listaConsultas, idConsultaCounter).setVisible(true));
        btn3.addActionListener(e -> new FormAtenderConsulta(listaConsultas).setVisible(true));
        btn4.addActionListener(e -> new FormGenerarFactura(listaConsultas, listaFacturas, idFacturaCounter).setVisible(true));
        btn5.addActionListener(e -> new FormReportes(listaFacturas, listaConsultas).setVisible(true));
        
        btnCerrarSesion.addActionListener(e -> {
            tabbedPane.setSelectedIndex(0);
            tabbedPane.setEnabledAt(1, false);
            JOptionPane.showMessageDialog(this, "Sesión cerrada.");
        });

        panelBotones.add(btn1);
        panelBotones.add(btn2);
        panelBotones.add(btn3);
        panelBotones.add(btn4);
        panelBotones.add(btn5);
        panelBotones.add(btnCerrarSesion);
        JPanel panelFooter = new JPanel();
        panelFooter.setBackground(new Color(33, 97, 140));
        JLabel lblFooter = new JLabel("Sistema de Gestión Veterinaria v1.0");
        lblFooter.setForeground(Color.WHITE);
        lblFooter.setFont(new Font("Arial", Font.ITALIC, 11));
        panelFooter.add(lblFooter);

        panelPrincipal.add(panelHeader, BorderLayout.NORTH);
        panelPrincipal.add(panelBotones, BorderLayout.CENTER);
        panelPrincipal.add(panelFooter, BorderLayout.SOUTH);
        
        return panelPrincipal;
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