package co.edu.uniquoindio.redsocial.proxy;

import co.edu.uniquoindio.redsocial.model.Vendedor;
import co.edu.uniquoindio.redsocial.service.ILoginService;

import java.util.HashMap;
import java.util.Map;

public class LoginService implements ILoginService {
    private Map<String, String> usuarios = new HashMap<>();
    private Vendedor vendedorOnSesion;

    public LoginService() {

    }

    public Map<String, String> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Map<String, String> usuarios) {
        this.usuarios = usuarios;
    }

    public Vendedor getVendedorOnSesion() {
        return vendedorOnSesion;
    }

    public void setVendedorOnSesion(Vendedor vendedorOnSesion) {
        this.vendedorOnSesion = vendedorOnSesion;
    }

    @Override
    public boolean login(Vendedor vendedor) {
        String username = vendedor.getUsuarioAsociado().getUsername();
        String password = vendedor.getUsuarioAsociado().getPassword();
        String storedPassword = usuarios.get(username);
        if (storedPassword != null && storedPassword.equals(password)) {
            vendedorOnSesion = vendedor;
            return true;
        }
        return false;
    }
}