package co.edu.uniquoindio.redsocial.model.builder;

import co.edu.uniquoindio.redsocial.model.Usuario;

public class UsuarioBuilder {
    protected String username, password;

    public UsuarioBuilder username(String usernane) {
        this.username = username;
        return this;
    }

    public UsuarioBuilder password(String password) {
        this.password = password;
        return this;
    }

    public Usuario build() {
        return new Usuario(username, password);
    }
}
