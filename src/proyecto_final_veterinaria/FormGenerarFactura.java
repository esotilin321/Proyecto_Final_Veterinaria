/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_final_veterinaria;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Jean Purizaga
 */
public class FormGenerarFactura extends JFrame {

    private ArrayList<Consulta> listaConsultas;
    private ArrayList<Factura> listaFacturas;
    private int[] idFacturaCounter;

    private JComboBox<String> cbConsultas;
    private JComboBox<String> cbMetodoPago;
    private JTextArea txtResumen;

    public FormGenerarFactura(ArrayList<Consulta> listaConsultas,
                               ArrayList<Factura> listaFacturas,
                               int[] idFacturaCounter) {
        this.listaConsultas = listaConsultas;
        this.listaFacturas = listaFacturas;
        this.idFacturaCounter = idFacturaCounter;

        setTitle("Cobrar - Generar Factura");
        setSize(480, 420);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(240, 248, 255));

        // Header
        JPanel header = new JPanel();
        header.setBackground(new Color(33, 97, 140));
        header.setBorder(BorderFactory.createEmptyBorder(12, 20, 12, 20));
        JLabel lblTitulo = new JLabel("Cobrar - Generar Factura");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        lblTitulo.setForeground(Color.WHITE);
        header.add(lblTitulo);

        // Formulario
        JPanel formulario = new JPanel(new GridLayout(4, 1, 10, 10));
        formulario.setBackground(new Color(240, 248, 255));
        formulario.setBorder(BorderFactory.createEmptyBorder(20, 30, 10, 30));

        cbConsultas = new JComboBox<>();
        cargarConsultasAtendidas();

        cbMetodoPago = new JComboBox<>(new String[]{"Efectivo", "Tarjeta de Crédito/Débito", "Transferencia Bancaria"});

        txtResumen = new JTextArea(4, 20);
        txtResumen.setEditable(false);
        txtResumen.setFont(new Font("Monospaced", Font.PLAIN, 12));
        txtResumen.setBackground(new Color(230, 240, 255));
        txtResumen.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        JScrollPane scroll = new JScrollPane(txtResumen);

        // Actualizar resumen al cambiar selección
        cbConsultas.addActionListener(e -> actualizarResumen());

        JLabel lblConsulta = new JLabel("Consulta atendida:");
        lblConsulta.setFont(new Font("Arial", Font.PLAIN, 13));
        JLabel lblMetodo = new JLabel("Método de pago:");
        lblMetodo.setFont(new Font("Arial", Font.PLAIN, 13));

        formulario.add(lblConsulta);
        formulario.add(cbConsultas);
        formulario.add(lblMetodo);
        formulario.add(cbMetodoPago);

        // Resumen panel
        JPanel panelResumen = new JPanel(new BorderLayout());
        panelResumen.setBackground(new Color(240, 248, 255));
        panelResumen.setBorder(BorderFactory.createEmptyBorder(0, 30, 10, 30));
        panelResumen.add(new JLabel("Resumen:"), BorderLayout.NORTH);
        panelResumen.add(scroll, BorderLayout.CENTER);

        // Botón
        JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        panelBoton.setBackground(new Color(240, 248, 255));

        JButton btnCobrar = new JButton("Generar Factura");
        btnCobrar.setBackground(new Color(39, 174, 96));
        btnCobrar.setForeground(Color.WHITE);
        btnCobrar.setFocusPainted(false);
        btnCobrar.setFont(new Font("Arial", Font.BOLD, 13));
        btnCobrar.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btnCobrar.addActionListener(e -> {
            ArrayList<Consulta> atendidas = getConsultasAtendidas();

            if (atendidas.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No hay consultas atendidas pendientes de cobro.", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }

            Consulta consulta = atendidas.get(cbConsultas.getSelectedIndex());
            String metodoPago = (String) cbMetodoPago.getSelectedItem();

            Pago pago = new Pago(idFacturaCounter[0], new Date(), consulta.getServicio().getPrecio(), metodoPago);
            pago.registrarPago();

            Factura factura = new Factura(idFacturaCounter[0]++, consulta, metodoPago);
            consulta.setEstado("Cobrada");
            listaFacturas.add(factura);

            JOptionPane.showMessageDialog(null,
                "Factura generada exitosamente!" +
                "Factura N°: " + factura.getIdFactura() + "\n" +
                "Dueño: " + consulta.getMascota().getNombreDueno() + "\n" +
                "Mascota: " + consulta.getMascota().getNombre() + "\n" +
                "Servicio: " + consulta.getServicio().getNombreServicio() + "\n" +
                "Método de pago: " + metodoPago + "\n" +
                "Total: $" + consulta.getServicio().getPrecio(),
                "Factura Generada", JOptionPane.INFORMATION_MESSAGE);

            cargarConsultasAtendidas();
            txtResumen.setText("");
        });

        panelBoton.add(btnCobrar);

        // Layout final
        JPanel centro = new JPanel(new BorderLayout());
        centro.setBackground(new Color(240, 248, 255));
        centro.add(formulario, BorderLayout.NORTH);
        centro.add(panelResumen, BorderLayout.CENTER);

        panel.add(header, BorderLayout.NORTH);
        panel.add(centro, BorderLayout.CENTER);
        panel.add(panelBoton, BorderLayout.SOUTH);

        add(panel);
        actualizarResumen();
    }

    private ArrayList<Consulta> getConsultasAtendidas() {
        ArrayList<Consulta> atendidas = new ArrayList<>();
        for (Consulta c : listaConsultas) {
            if (c.getEstado().equals("Atendida")) atendidas.add(c);
        }
        return atendidas;
    }

    private void cargarConsultasAtendidas() {
        cbConsultas.removeAllItems();
        for (Consulta c : getConsultasAtendidas()) {
            cbConsultas.addItem("ID " + c.getIdConsulta() + " - " + c.getMascota().getNombre() + " | " + c.getServicio().getNombreServicio() + " ($" + c.getServicio().getPrecio() + ")");
        }
    }

    private void actualizarResumen() {
        ArrayList<Consulta> atendidas = getConsultasAtendidas();
        if (atendidas.isEmpty() || cbConsultas.getSelectedIndex() < 0) {
            txtResumen.setText("No hay consultas atendidas pendientes.");
            return;
        }
        Consulta c = atendidas.get(cbConsultas.getSelectedIndex());
        txtResumen.setText(
            "Dueño    : " + c.getMascota().getNombreDueno() + "\n" +
            "Teléfono : " + c.getMascota().getTelefonoDueno() + "\n" +
            "Mascota  : " + c.getMascota().getNombre() + " (" + c.getMascota().getEspecie() + ")\n" +
            "Veterinario: " + c.getVeterinario().getNombre_Usuario() + "\n" +
            "Diagnóstico: " + c.getDiagnostico() + "\n" +
            "Total    : $" + c.getServicio().getPrecio()
        );
    }
}