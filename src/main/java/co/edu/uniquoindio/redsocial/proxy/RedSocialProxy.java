package co.edu.uniquoindio.redsocial.proxy;

import co.edu.uniquoindio.redsocial.model.*;
import co.edu.uniquoindio.redsocial.service.IRedSocial;

import java.time.LocalDate;

public class RedSocialProxy implements IRedSocial {
    private RedSocial redSocial;
    private Persona usuarioAutenticado;

    public RedSocialProxy(RedSocial redSocial) {
        this.redSocial = new RedSocial();
    }

    public Persona getUsuarioAutenticado() {
        return usuarioAutenticado;
    }

    public void setUsuarioAutenticado(Persona usuarioAutenticado) {
        this.usuarioAutenticado = usuarioAutenticado;
    }

    @Override
    public boolean eliminarUsuario(String username) {
        if (esAdministrador()) {
            return redSocial.eliminarUsuario(username);
        }
        System.out.println("Acceso denegado: Solo los administradores pueden eliminar usuarios.");
        return false;
    }

    @Override
    public boolean actualizarUsuario(String username, Usuario usuario) {
        return false;
    }

    @Override
    public boolean actualizarVendedor(String id, String username, Vendedor vendedor) {
        return false;
    }

    @Override
    public boolean comprobarDatosVendedor(Vendedor vendedor) {
        return false;
    }

    @Override
    public boolean eliminarVendedor(String id) {
        if (esAdministrador()) {
            return redSocial.eliminarVendedor(id);
        }
        System.out.println("Acceso denegado: Solo los administradores pueden eliminar vendedores.");
        return false;
    }

    @Override
    public String cantProductosFechas(LocalDate v1, LocalDate v2) {
        return "";
    }

    @Override
    public Producto encontrarProducto(String id) {
        return null;
    }

    @Override
    public boolean agregarProducto(Producto producto) {
        return false;
    }

    private boolean esAdministrador() {
        return usuarioAutenticado instanceof Administrador;
    }

    private boolean esVendedor() {
        return usuarioAutenticado instanceof Vendedor;
    }
}

