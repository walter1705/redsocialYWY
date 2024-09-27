package co.edu.uniquoindio.redsocial.model;

import co.edu.uniquoindio.redsocial.model.builder.UsuarioBuilder;

public class Usuario {
    private String username, password;

    public Usuario(String user, String password) {
        this.username = user;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static UsuarioBuilder builder() {
        return new UsuarioBuilder();
    }
}
