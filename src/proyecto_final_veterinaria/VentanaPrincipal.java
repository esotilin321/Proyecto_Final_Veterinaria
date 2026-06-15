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
    public VentanaPrincipal() {
        setTitle("Clínica Veterinaria - Sistema de Gestión");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Panel principal con color de fondo
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.setBackground(new Color(240, 248, 255));

        // --- ENCABEZADO ---
        JPanel panelHeader = new JPanel();
        panelHeader.setBackground(new Color(33, 97, 140));
        panelHeader.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel lblTitulo = new JLabel(" Clínica Veterinaria");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitulo.setForeground(Color.WHITE);
        panelHeader.add(lblTitulo);

        // --- PANEL DE BOTONES ---
        JPanel panelBotones = new JPanel(new GridLayout(5, 1, 10, 10));
        panelBotones.setBackground(new Color(240, 248, 255));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(30, 80, 30, 80));

        String[] opciones = {
            "1. Registrar Mascota",
            "2. Agendar Servicio (Consulta)",
            "3. Atender Consulta",
            "4. Cobrar (Generar Factura)",
            "5. Ver Reporte del Administrador"
        };

        for (String opcion : opciones) {
            JButton btn = new JButton(opcion);
            btn.setFont(new Font("Arial", Font.PLAIN, 14));
            btn.setBackground(new Color(52, 152, 219));
            btn.setForeground(Color.WHITE);
            btn.setFocusPainted(false);
            btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
            btn.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));
            panelBotones.add(btn);
        }

        // --- PIE DE PÁGINA ---
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
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new VentanaPrincipal().setVisible(true);
        });
    }
}
