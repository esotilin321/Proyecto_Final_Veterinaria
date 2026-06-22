package proyecto_final_veterinaria;

/**
 *
 * @author Jean Purizaga
 */
public class Dueño extends Usuario{

    private Mascota mascota;

    public Dueño(String idUsuario, String nombre_Usuario, String correo_Usuario, String contraseña_Usuario) {
        super(idUsuario, nombre_Usuario, correo_Usuario, contraseña_Usuario);
    }
    
    @Override
    public void iniciarSesion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void cerrarSesion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
