package co.edu.uniquoindio.redsocial.redsocial.model.builder;

import co.edu.uniquoindio.redsocial.redsocial.model.Administrador;
import co.edu.uniquoindio.redsocial.redsocial.model.Usuario;

public class AdministradorBuilder {
    protected String id, nombre, apellido, email, direccion;
    protected Usuario usuarioAsociado;

    public AdministradorBuilder nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public AdministradorBuilder id(String id) {
        this.id = id;
        return this;
    }

    public AdministradorBuilder apellido(String apellido) {
        this.apellido = apellido;
        return this;
    }

    public AdministradorBuilder email(String email) {
        this.email = email;
        return this;
    }

    public AdministradorBuilder direccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

    public AdministradorBuilder usuarioAsociado(Usuario usuario) {
        this.usuarioAsociado = usuario;
        return this;
    }

    public Administrador build() {
        return new Administrador(id, nombre, apellido, email, direccion, usuarioAsociado);
    }
}
