package proyecto_final_veterinaria;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 *
 * @author Jean Purizaga
 */
public class FormVerHistorial extends JFrame{

    public FormVerHistorial(ArrayList<Mascota> listaMascotas, ArrayList<Consulta> listaConsultas) {
        setTitle("Historial Clínico de Mascota");
        setSize(500, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBackground(new Color(240, 248, 255));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // Header and Selection
        JPanel panelTop = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panelTop.setBackground(new Color(240, 248, 255));
        panelTop.add(new JLabel("Seleccione Mascota:"));
        
        JComboBox<String> cbMascota = new JComboBox<>();
        cbMascota.addItem("-- Seleccionar Mascota --");
        for (Mascota m : listaMascotas) {
            cbMascota.addItem(m.getNombre() + " (" + m.getIdMascota() + ")");
        }
        panelTop.add(cbMascota);

        JTextArea txtHistorial = new JTextArea();
        txtHistorial.setEditable(false);
        txtHistorial.setFont(new Font("Monospaced", Font.PLAIN, 13));
        JScrollPane scroll = new JScrollPane(txtHistorial);

        cbMascota.addActionListener(e -> {
            int idx = cbMascota.getSelectedIndex();
            if (idx == 0 || idx == -1) {
                txtHistorial.setText("");
                return;
            }
            // idx - 1 because of the placeholder
            Mascota m = listaMascotas.get(idx - 1);
            StringBuilder sb = new StringBuilder();
            sb.append("=== Historial Clínico de ").append(m.getNombre()).append(" ===\n\n");
            
            boolean tieneConsultas = false;
            for (Consulta c : listaConsultas) {
                if (c.getMascota().getIdMascota().equals(m.getIdMascota())) {
                    tieneConsultas = true;
                    sb.append("ID Consulta : ").append(c.getIdConsulta()).append("\n");
                    sb.append("Servicio    : ").append(c.getServicio().getNombreServicio()).append("\n");
                    sb.append("Veterinario : ").append(c.getVeterinario().getNombre_Usuario()).append("\n");
                    sb.append("Diagnóstico : ").append(c.getDiagnostico()).append("\n");
                    sb.append("Estado      : ").append(c.getEstado()).append("\n");
                    sb.append("--------------------------------------------------\n");
                }
            }
            if (!tieneConsultas) {
                sb.append("La mascota no tiene consultas registradas en el historial.");
            }
            txtHistorial.setText(sb.toString());
            txtHistorial.setCaretPosition(0);
        });

        panel.add(panelTop, BorderLayout.NORTH);
        panel.add(scroll, BorderLayout.CENTER);
        
        add(panel);
    }

}
