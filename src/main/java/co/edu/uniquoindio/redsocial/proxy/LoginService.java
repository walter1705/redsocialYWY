package co.edu.uniquoindio.redsocial.proxy;

import co.edu.uniquoindio.redsocial.model.Persona;
import co.edu.uniquoindio.redsocial.model.Vendedor;
import co.edu.uniquoindio.redsocial.service.ILoginService;

import java.util.HashMap;
import java.util.Map;

public class LoginService implements ILoginService {
    private Map<String, Persona> usuarios = new HashMap<>();
    private Persona personaOnSesion;

    public LoginService() {
    }

    public Map<String, Persona> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Map<String, Persona> usuarios) {
        this.usuarios = usuarios;
    }

    public Persona getPersonaOnSesion() {
        return personaOnSesion;
    }

    public void setPersonaOnSesion(Persona personaOnSesion) {
        this.personaOnSesion = personaOnSesion;
    }

    @Override
    public boolean login(String username, String password) {
        Persona persona = usuarios.get(username);
        if (persona != null && persona.getUsuarioAsociado().getPassword().equals(password)) {
            personaOnSesion = persona;
            return true;
        }
        return false;
    }
}