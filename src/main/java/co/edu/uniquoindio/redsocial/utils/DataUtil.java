package co.edu.uniquoindio.redsocial.utils;

import co.edu.uniquoindio.redsocial.model.Administrador;
import co.edu.uniquoindio.redsocial.model.RedSocial;
import co.edu.uniquoindio.redsocial.model.Usuario;

public class DataUtil {
    public static RedSocial inicializarDatosPrueba() {

        RedSocial redSocial = new RedSocial();
        //Administrador
        Usuario usuario = Usuario.builder()
                .username("admin")
                .password("admin")
                .build();
        redSocial.crearUsuario(usuario);
        redSocial.agregarRedSocial(usuario);
        return redSocial;
    }
}