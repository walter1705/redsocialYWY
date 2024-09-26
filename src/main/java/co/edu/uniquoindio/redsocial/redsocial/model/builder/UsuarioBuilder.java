package co.edu.uniquoindio.redsocial.redsocial.model.builder;

import co.edu.uniquoindio.redsocial.redsocial.model.Usuario;

public class UsuarioBuilder {
    protected String user, password;

    public UsuarioBuilder user(String user) {
        this.user = user;
        return this;
    }

    public UsuarioBuilder password(String password) {
        this.password = password;
        return this;
    }

    public Usuario build() {
        return new Usuario(user, password);
    }
}
