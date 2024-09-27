package co.edu.uniquoindio.redsocial.model;

public class Persona {
    private String id, nombre, apellido, email, direccion;
    private Usuario usuarioAsociado;

    public Persona(Usuario usuarioAsociado, String direccion, String email, String apellido, String nombre, String id) {
        this.usuarioAsociado = usuarioAsociado;
        this.direccion = direccion;
        this.email = email;
        this.apellido = apellido;
        this.nombre = nombre;
        this.id = id;
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

    public Usuario getUsuarioAsociado() {
        return usuarioAsociado;
    }

    public void setUsuarioAsociado(Usuario usuarioAsociado) {
        this.usuarioAsociado = usuarioAsociado;
    }
}
