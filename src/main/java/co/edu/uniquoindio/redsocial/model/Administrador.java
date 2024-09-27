package co.edu.uniquoindio.redsocial.model;

import co.edu.uniquoindio.redsocial.model.builder.AdministradorBuilder;

public class Administrador extends Persona{

    public Administrador(Usuario usuarioAsociado, String direccion, String email, String apellido, String nombre, String id) {
        super(usuarioAsociado, direccion, email, apellido, nombre, id);
    }

    public static AdministradorBuilder builder() {
        return new AdministradorBuilder();
    }
}
