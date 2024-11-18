package co.edu.uniquoindio.redsocial.utils;

import co.edu.uniquoindio.redsocial.model.Administrador;
import co.edu.uniquoindio.redsocial.model.RedSocial;
import co.edu.uniquoindio.redsocial.model.Usuario;

public class DataUtil {
    public static RedSocial inicializarDatosPrueba() {

        RedSocial redSocial = new RedSocial();
        //Administrador
        Administrador administrador = Administrador.builder()
                .nombre("Yeral")
                .apellido("Uwu")
                .id("123")
                .email("@uqvirtual.edu.co")
                .direccion("pueblo tapado")
                .build();
        Usuario usuarioAdmin = Usuario.builder()
                .username("admin")
                .password("admin")
                .build();
        administrador.setUsuarioAsociado(usuarioAdmin);
        usuarioAdmin.setAdministradorAsociado(administrador);
        redSocial.agregarRedSocial(administrador);
        redSocial.agregarRedSocial(usuarioAdmin);
        return redSocial;
    }
}