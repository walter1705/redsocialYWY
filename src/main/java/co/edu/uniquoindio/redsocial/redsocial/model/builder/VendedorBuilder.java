package co.edu.uniquoindio.redsocial.redsocial.model.builder;

import co.edu.uniquoindio.redsocial.redsocial.model.Usuario;
import co.edu.uniquoindio.redsocial.redsocial.model.Vendedor;

public class VendedorBuilder {
    protected String id, nombre, apellido, email, direccion;
    protected Usuario usuarioAsociado;

    public VendedorBuilder nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public VendedorBuilder id(String id) {
        this.id = id;
        return this;
    }

    public VendedorBuilder apellido(String apellido) {
        this.apellido = apellido;
        return this;
    }

    public VendedorBuilder email(String email) {
        this.email = email;
        return this;
    }

    public VendedorBuilder direccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

    public VendedorBuilder usuarioAsociado(Usuario usuario) {
        this.usuarioAsociado = usuario;
        return this;
    }

    public Vendedor build() {
        return new Vendedor(id, nombre, apellido, email, direccion, usuarioAsociado);
    }
}
