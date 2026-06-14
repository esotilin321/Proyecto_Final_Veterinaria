package proyecto_final_veterinaria;

import java.util.Date;

public class Factura {
    private int idFactura;
    private Consulta consulta;
    private double montoTotal;
    private String metodoPago;
    private Date fechaEmision;

    public Factura(int idFactura, Consulta consulta, String metodoPago) {
        this.idFactura = idFactura;
        this.consulta = consulta;
        this.montoTotal = consulta.getServicio().getPrecio();
        this.metodoPago = metodoPago;
        this.fechaEmision = new Date();
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public void imprimirFactura() {
        System.out.println("==================================");
        System.out.println("   CLÍNICA VETERINARIA FACTURA    ");
        System.out.println("==================================");
        System.out.println("Factura Nro: " + idFactura);
        System.out.println("Fecha: " + fechaEmision);
        System.out.println("----------------------------------");
        System.out.println("Dueño: " + consulta.getMascota().getNombreDueno());
        System.out.println("Teléfono: " + consulta.getMascota().getTelefonoDueno());
        System.out.println("Mascota: " + consulta.getMascota().getNombre() + " (" + consulta.getMascota().getEspecie() + ")");
        System.out.println("Atendido por: Dr(a). " + consulta.getVeterinario().getNombre_Usuario());
        System.out.println("----------------------------------");
        System.out.println("Servicio: " + consulta.getServicio().getNombreServicio());
        System.out.println("Diagnóstico: " + consulta.getDiagnostico());
        System.out.println("----------------------------------");
        System.out.println("Monto a pagar: $" + montoTotal);
        System.out.println("Método de Pago: " + metodoPago);
        System.out.println("==================================");
    }
}
