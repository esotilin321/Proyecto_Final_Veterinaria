/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_final_veterinaria;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

/**
 *
 * @author Jean Purizaga
 */
public class FormReportes extends JFrame {

    private ArrayList<Factura> listaFacturas;
    private ArrayList<Consulta> listaConsultas;

    public FormReportes(ArrayList<Factura> listaFacturas, ArrayList<Consulta> listaConsultas) {
        this.listaFacturas = listaFacturas;
        this.listaConsultas = listaConsultas;

        setTitle("Reporte del Administrador");
        setSize(650, 480);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(240, 248, 255));

        // Header
        JPanel header = new JPanel();
        header.setBackground(new Color(33, 97, 140));
        header.setBorder(BorderFactory.createEmptyBorder(12, 20, 12, 20));
        JLabel lblTitulo = new JLabel("Reporte del Administrador");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        lblTitulo.setForeground(Color.WHITE);
        header.add(lblTitulo);

        // Tabs
        JTabbedPane tabs = new JTabbedPane();
        tabs.setFont(new Font("Arial", Font.PLAIN, 13));
        tabs.setBackground(new Color(240, 248, 255));

        // --- Tab 1: Facturas ---
        String[] colsFacturas = {"N° Factura", "Mascota", "Dueño", "Servicio", "Total ($)", "Método Pago"};
        DefaultTableModel modelFacturas = new DefaultTableModel(colsFacturas, 0) {
            public boolean isCellEditable(int r, int c) { return false; }
        };

        double totalRecaudado = 0;
        for (Factura f : listaFacturas) {
            modelFacturas.addRow(new Object[]{
                f.getIdFactura(),
                f.getConsulta().getMascota().getNombre(),
                f.getConsulta().getMascota().getNombreDueno(),
                f.getConsulta().getServicio().getNombreServicio(),
                f.getMontoTotal(),
                f.getMetodoPago()
            });
            totalRecaudado += f.getMontoTotal();
        }

        JTable tablaFacturas = new JTable(modelFacturas);
        tablaFacturas.setRowHeight(24);
        tablaFacturas.getTableHeader().setBackground(new Color(52, 152, 219));
        tablaFacturas.getTableHeader().setForeground(Color.WHITE);
        tablaFacturas.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
        JScrollPane scrollFacturas = new JScrollPane(tablaFacturas);

        JPanel panelFacturas = new JPanel(new BorderLayout());
        panelFacturas.setBackground(new Color(240, 248, 255));
        panelFacturas.add(scrollFacturas, BorderLayout.CENTER);

        JLabel lblTotal = new JLabel("  Total recaudado: $" + totalRecaudado);
        lblTotal.setFont(new Font("Arial", Font.BOLD, 14));
        lblTotal.setForeground(new Color(39, 174, 96));
        lblTotal.setBorder(BorderFactory.createEmptyBorder(8, 10, 8, 10));
        panelFacturas.add(lblTotal, BorderLayout.SOUTH);

        // --- Tab 2: Consultas ---
        String[] colsConsultas = {"ID", "Mascota", "Veterinario", "Servicio", "Diagnóstico", "Estado"};
        DefaultTableModel modelConsultas = new DefaultTableModel(colsConsultas, 0) {
            public boolean isCellEditable(int r, int c) { return false; }
        };

        for (Consulta c : listaConsultas) {
            modelConsultas.addRow(new Object[]{
                c.getIdConsulta(),
                c.getMascota().getNombre(),
                c.getVeterinario().getNombre_Usuario(),
                c.getServicio().getNombreServicio(),
                c.getDiagnostico(),
                c.getEstado()
            });
        }

        JTable tablaConsultas = new JTable(modelConsultas);
        tablaConsultas.setRowHeight(24);
        tablaConsultas.getTableHeader().setBackground(new Color(52, 152, 219));
        tablaConsultas.getTableHeader().setForeground(Color.WHITE);
        tablaConsultas.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
        JScrollPane scrollConsultas = new JScrollPane(tablaConsultas);

        JPanel panelConsultas = new JPanel(new BorderLayout());
        panelConsultas.add(scrollConsultas, BorderLayout.CENTER);

        JLabel lblTotalConsultas = new JLabel("  Total consultas: " + listaConsultas.size());
        lblTotalConsultas.setFont(new Font("Arial", Font.BOLD, 14));
        lblTotalConsultas.setForeground(new Color(52, 152, 219));
        lblTotalConsultas.setBorder(BorderFactory.createEmptyBorder(8, 10, 8, 10));
        panelConsultas.add(lblTotalConsultas, BorderLayout.SOUTH);

        tabs.addTab("Facturas", panelFacturas);
        tabs.addTab("Consultas", panelConsultas);

        // Footer
        JPanel panelFooter = new JPanel();
        panelFooter.setBackground(new Color(33, 97, 140));
        JLabel lblFooter = new JLabel("Sistema de Gestión Veterinaria v1.0  |  Admin Clinica");
        lblFooter.setForeground(Color.WHITE);
        lblFooter.setFont(new Font("Arial", Font.ITALIC, 11));
        panelFooter.add(lblFooter);

        panel.add(header, BorderLayout.NORTH);
        panel.add(tabs, BorderLayout.CENTER);
        panel.add(panelFooter, BorderLayout.SOUTH);

        add(panel);
    }
}
