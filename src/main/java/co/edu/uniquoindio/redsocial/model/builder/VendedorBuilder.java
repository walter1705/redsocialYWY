package co.edu.uniquoindio.redsocial.model.builder;

import co.edu.uniquoindio.redsocial.model.Muro;
import co.edu.uniquoindio.redsocial.model.Usuario;
import co.edu.uniquoindio.redsocial.model.Vendedor;

public class VendedorBuilder {
    protected String id, nombre, apellido, email, direccion;
    protected Usuario usuarioAsociado;
    protected Muro muro;

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

    public VendedorBuilder muro(Muro muro) {
        this.muro = muro;
        return this;
    }

    public Vendedor build() {
        return new Vendedor(usuarioAsociado, direccion,  email, apellido, nombre, id, muro);
    }
}
