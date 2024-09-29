package co.edu.uniquoindio.redsocial.model.builder;

import co.edu.uniquoindio.redsocial.model.Administrador;
import co.edu.uniquoindio.redsocial.model.Usuario;
import co.edu.uniquoindio.redsocial.model.Vendedor;

public class UsuarioBuilder {
    protected String username, password;
    protected Vendedor vendedorAsociado;
    protected Administrador administradorAsociado;

    public UsuarioBuilder username(String username) {
        this.username = username;
        return this;
    }

    public UsuarioBuilder password(String password) {
        this.password = password;
        return this;
    }

    public UsuarioBuilder vendedorAsociado(Vendedor vendedor) {
        this.vendedorAsociado = vendedor;
        return this;
    }

    public UsuarioBuilder administradorAsociado(Administrador administrador) {
        this.administradorAsociado = administrador;
        return this;
    }

    public Usuario build() {
        return new Usuario(username, password, vendedorAsociado, administradorAsociado);
    }
}
