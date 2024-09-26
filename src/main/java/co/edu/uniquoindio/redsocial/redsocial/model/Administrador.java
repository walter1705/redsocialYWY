package co.edu.uniquoindio.redsocial.redsocial.model;

import co.edu.uniquoindio.redsocial.redsocial.model.builder.AdministradorBuilder;

public class Administrador {
    private String id, nombre, apellido, email, direccion;
    private Usuario usuarioAsociado;

    public Administrador(String id, String nombre, String apellido, String email,
                         String direccion, Usuario usuario) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.direccion = direccion;
        this.usuarioAsociado = usuario;
    }

    public Usuario getUsuarioAsociado() {
        return usuarioAsociado;
    }

    public void setUsuarioAsociado(Usuario usuarioAsociado) {
        this.usuarioAsociado = usuarioAsociado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public static AdministradorBuilder builder() {
        return new AdministradorBuilder();
    }
}
