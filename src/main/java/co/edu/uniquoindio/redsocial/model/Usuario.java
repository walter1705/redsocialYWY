package co.edu.uniquoindio.redsocial.model;

import co.edu.uniquoindio.redsocial.model.builder.UsuarioBuilder;

public class Usuario {
    private String username, password;
    private Vendedor vendedorAsociado;
    private Administrador administradorAsociado;

    public Usuario(String username, String password, Vendedor vendedorAsociado, Administrador administradorAsociado) {
        this.administradorAsociado = administradorAsociado;
        this.vendedorAsociado = vendedorAsociado;
        this.username = username;
        this.password = password;
    }

    public Vendedor getVendedorAsociado() {
        return vendedorAsociado;
    }

    public void setVendedorAsociado(Vendedor vendedorAsociado) {
        this.vendedorAsociado = vendedorAsociado;
    }

    public Administrador getAdministradorAsociado() {
        return administradorAsociado;
    }

    public void setAdministradorAsociado(Administrador administradorAsociado) {
        this.administradorAsociado = administradorAsociado;
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
