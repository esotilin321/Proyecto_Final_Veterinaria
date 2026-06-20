/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_final_veterinaria;

/**
 *
 * @author OS
 */
public abstract class Usuario {
    
    protected String idUsuario;
    protected String tipo_documento;
    protected String nro_documento;
    protected String nombre_Usuario; 
    protected String paterno;
    protected String materno;
    protected String telefono;
    protected String correo_Usuario; 
    protected String contraseña_Usuario; 

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public String getNro_documento() {
        return nro_documento;
    }

    public void setNro_documento(String nro_documento) {
        this.nro_documento = nro_documento;
    }

    public String getNombre_Usuario() {
        return nombre_Usuario;
    }

    public void setNombre_Usuario(String nombre_Usuario) {
        this.nombre_Usuario = nombre_Usuario;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo_Usuario() {
        return correo_Usuario;
    }

    public void setCorreo_Usuario(String correo_Usuario) {
        this.correo_Usuario = correo_Usuario;
    }

    public String getContraseña_Usuario() {
        return contraseña_Usuario;
    }

    public void setContraseña_Usuario(String contraseña_Usuario) {
        this.contraseña_Usuario = contraseña_Usuario;
    }

    

    public Usuario(String idUsuario, String nombre_Usuario, String correo_Usuario, String contraseña_Usuario) {
        this.idUsuario = idUsuario;
        this.nombre_Usuario = nombre_Usuario;
        this.correo_Usuario = correo_Usuario;
        this.contraseña_Usuario = contraseña_Usuario;
    }
    
    
    public abstract void iniciarSesion();
       
    
    public abstract void cerrarSesion();
        
    

    
}
