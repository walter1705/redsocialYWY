package co.edu.uniquoindio.redsocial.utils;

import co.edu.uniquoindio.redsocial.model.*;

import java.time.LocalDate;

public class DataUtil {
    public static RedSocial inicializarDatosPrueba() {

        RedSocial redSocial = new RedSocial();
        // Administrador
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
        redSocial.agregarRedSocial(administrador);
        redSocial.agregarRedSocial(usuarioAdmin);

        // Vendedores y productos
        // Vendedor 1
        Usuario usuarioVendedor1 = Usuario.builder()
                .username("vendedor1")
                .password("vendedor1")
                .build();

        Muro muroVendedor1 = new Muro();
        Vendedor vendedor1 = Vendedor.builder()
                .usuarioAsociado(usuarioVendedor1)
                .direccion("Calle Ficticia 123")
                .email("vendedor1@correo.com")
                .apellido("Lopez")
                .nombre("Carlos")
                .id("001")
                .muro(muroVendedor1)
                .build();

        Producto producto1 = Producto.builder()
                .nombre("Camiseta Deportiva")
                .imagen("camiseta.jpg")
                .categoria("Ropa")
                .estadoProducto(EstadoProducto.PUBLICADO)
                .precio(25.0)
                .vendedorAsociado(vendedor1)
                .fechaPublicacion(LocalDate.of(2024, 11, 17))
                .id("prod001")
                .descripcion("Camiseta deportiva de alta calidad.")
                .publicacion(new Publicacion())  // Asocia a la publicación correspondiente
                .build();

        vendedor1.agregarProducto(producto1);
        redSocial.agregarRedSocial(vendedor1);
        redSocial.agregarRedSocial(usuarioVendedor1);

        // Vendedor 2
        Usuario usuarioVendedor2 = Usuario.builder()
                .username("vendedor2")
                .password("vendedor2")
                .build();

        Muro muroVendedor2 = new Muro();  // Asegúrate de tener la clase Muro definida
        Vendedor vendedor2 = Vendedor.builder()
                .usuarioAsociado(usuarioVendedor2)
                .direccion("Calle Ficticia 456")
                .email("vendedor2@correo.com")
                .apellido("Perez")
                .nombre("Ana")
                .id("002")
                .muro(muroVendedor2)
                .build();

        Producto producto2 = Producto.builder()
                .nombre("Zapatos Deportivos")
                .imagen("zapatos.jpg")
                .categoria("Calzado")
                .estadoProducto(EstadoProducto.PUBLICADO)
                .precio(50.0)
                .vendedorAsociado(vendedor2)
                .fechaPublicacion(LocalDate.of(2024, 11, 15))
                .id("prod002")
                .descripcion("Zapatos deportivos en buen estado.")
                .publicacion(new Publicacion())  // Asocia a la publicación correspondiente
                .build();

        vendedor2.agregarProducto(producto2);
        redSocial.agregarRedSocial(vendedor2);
        redSocial.agregarRedSocial(usuarioVendedor2);

        // Vendedor 3
        Usuario usuarioVendedor3 = Usuario.builder()
                .username("vendedor3")
                .password("vendedor3")
                .build();

        Muro muroVendedor3 = new Muro();
        Vendedor vendedor3 = Vendedor.builder()
                .usuarioAsociado(usuarioVendedor3)
                .direccion("Avenida Siempre Viva 789")
                .email("vendedor3@correo.com")
                .apellido("Martinez")
                .nombre("Pedro")
                .id("003")
                .muro(muroVendedor3)
                .build();

        Producto producto3 = Producto.builder()
                .nombre("Reloj Inteligente")
                .imagen("reloj.jpg")
                .categoria("Tecnología")
                .estadoProducto(EstadoProducto.VENDIDO)
                .precio(150.0)
                .vendedorAsociado(vendedor3)
                .fechaPublicacion(LocalDate.of(2024, 11, 10))
                .id("prod003")
                .descripcion("Reloj inteligente con múltiples funciones.")
                .publicacion(new Publicacion())
                .build();

        vendedor3.agregarProducto(producto3);
        redSocial.agregarRedSocial(vendedor3);
        redSocial.agregarRedSocial(usuarioVendedor3);
        // Vendedor 4
        Usuario usuarioVendedor4 = Usuario.builder()
                .username("vendedor4")
                .password("vendedor4")
                .build();

        Muro muroVendedor4 = new Muro();
        Vendedor vendedor4 = Vendedor.builder()
                .usuarioAsociado(usuarioVendedor4)
                .direccion("Avenida del Sol 101")
                .email("vendedor4@correo.com")
                .apellido("Gomez")
                .nombre("Maria")
                .id("004")
                .muro(muroVendedor4)
                .build();

        Producto producto4 = Producto.builder()
                .nombre("Auriculares Bluetooth")
                .imagen("auriculares.jpg")
                .categoria("Electrónica")
                .estadoProducto(EstadoProducto.PUBLICADO)
                .precio(75.0)
                .vendedorAsociado(vendedor4)
                .fechaPublicacion(LocalDate.of(2024, 11, 12))
                .id("prod004")
                .descripcion("Auriculares Bluetooth de excelente calidad.")
                .publicacion(new Publicacion())
                .build();

        vendedor4.agregarProducto(producto4);
        redSocial.agregarRedSocial(vendedor4);
        redSocial.agregarRedSocial(usuarioVendedor4);
        // Vendedor 5
        Usuario usuarioVendedor5 = Usuario.builder()
                .username("vendedor5")
                .password("vendedor5")
                .build();

        Muro muroVendedor5 = new Muro();  // Asegúrate de tener la clase Muro definida
        Vendedor vendedor5 = Vendedor.builder()
                .usuarioAsociado(usuarioVendedor5)
                .direccion("Calle Real 234")
                .email("vendedor5@correo.com")
                .apellido("Diaz")
                .nombre("Luis")
                .id("005")
                .muro(muroVendedor5)
                .build();

        Producto producto5 = Producto.builder()
                .nombre("Cámara Digital")
                .imagen("camara.jpg")
                .categoria("Tecnología")
                .estadoProducto(EstadoProducto.CANCELADO)
                .precio(200.0)
                .vendedorAsociado(vendedor5)
                .fechaPublicacion(LocalDate.of(2024, 11, 7))
                .id("prod005")
                .descripcion("Cámara digital con alta resolución.")
                .publicacion(new Publicacion())
                .build();

        vendedor5.agregarProducto(producto5);
        redSocial.agregarRedSocial(vendedor5);
        redSocial.agregarRedSocial(usuarioVendedor5);
        // Vendedor 6
        Usuario usuarioVendedor6 = Usuario.builder()
                .username("vendedor6")
                .password("vendedor6")
                .build();

        Muro muroVendedor6 = new Muro();  // Asegúrate de tener la clase Muro definida
        Vendedor vendedor6 = Vendedor.builder()
                .usuarioAsociado(usuarioVendedor6)
                .direccion("Calle de la Luna 567")
                .email("vendedor6@correo.com")
                .apellido("Fernandez")
                .nombre("Sofia")
                .id("006")
                .muro(muroVendedor6)
                .build();
        Publicacion publicacion = new Publicacion();
        publicacion.setLike(55);
        Producto producto6 = Producto.builder()
                .nombre("Silla Gaming")
                .imagen("silla.jpg")
                .categoria("Muebles")
                .estadoProducto(EstadoProducto.PUBLICADO)
                .precio(120.0)
                .vendedorAsociado(vendedor6)
                .fechaPublicacion(LocalDate.of(2024, 11, 5))
                .id("prod006")
                .descripcion("Silla ergonómica para gamers.")
                .publicacion(publicacion)
                .build();

        vendedor6.agregarProducto(producto6);
        redSocial.agregarRedSocial(vendedor6);
        redSocial.agregarRedSocial(usuarioVendedor6);

        redSocial.agregarRedSocial(producto1);
        redSocial.agregarRedSocial(producto2);
        redSocial.agregarRedSocial(producto3);
        redSocial.agregarRedSocial(producto4);
        redSocial.agregarRedSocial(producto5);
        redSocial.agregarRedSocial(producto6);
        return redSocial;

    }
}