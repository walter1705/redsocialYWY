package co.edu.uniquoindio.redsocial.utils;

import co.edu.uniquoindio.redsocial.model.Administrador;
import co.edu.uniquoindio.redsocial.model.RedSocial;
import co.edu.uniquoindio.redsocial.model.Usuario;

public class DataUtil {
    public static RedSocial inicializarDatosPrueba() {

        RedSocial redSocial = new RedSocial();
        //Administrador
        Administrador administrador = Administrador.builder()
                .nombre("admin")
                .build();
        Usuario usuarioAdmi = Usuario.builder()
                .username("admin")
                .password("admin")
                .administradorAsociado(administrador)
                .build();
        redSocial.agregarRedSocial(administrador);
        redSocial.agregarRedSocial(usuario);
        //User y vendedor enlazado 1
        Usuario usuario =  Usuario.builder()
                .username("yeral")
                .password("123")
                .build();
        redSocial.crearUsuario(usuario);
        redSocial.crearVendedor(usuario, "Cra1", "yeraln@uniquindio.co","Noguera", "Yeral", "109");
        //Solo user 2
        Usuario usuario1 = Usuario.builder()
                .username("Wal17")
                .password("1119")
                .build();
        redSocial.crearUsuario(usuario1);
        //Solo vendedor 3
        redSocial.crearVendedor(null, "Calle 2", "@gmail.com", "Pardo", "Jose", "108");
        return redSocial;
    }
}