package co.edu.uniquoindio.redsocial.model;

import co.edu.uniquoindio.redsocial.service.IRedSocial;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RedSocial implements IRedSocial {
    private String nombre;
    private List<Usuario> listaUsuarios = new ArrayList<>();
    private List<Vendedor> listaVendedores = new ArrayList<>();
    private List<Administrador> listaAdministradores = new ArrayList<>();
    private List<Producto> listaProductos = new ArrayList<>();

    //Metodo agregar Usuario
    public void agregarRedSocial(Usuario usuario) {listaUsuarios.add(usuario);}
    //Metodo agregar Administrador
    public void agregarRedSocial(Administrador administrador) {
        if (obtenerUsuario(administrador.getNombre()) == null && listaAdministradores.size()<=1) {
            listaAdministradores.add(administrador);
        }
    }
    //Metodo agregar Vendedor
    public void agregarRedSocial(Vendedor vendedor) {listaVendedores.add(vendedor);}
    //Metodo agregar Producto
    public void agregarRedSocial(Producto producto) {listaProductos.add(producto);}

    //CRUD USUARIO

    private boolean verificarUsuarioRepetido(String username) {
        if (username==null || username.isBlank()) return false;
        for(Usuario usuario : listaUsuarios) {
            if (usuario.getUsername().equals(username) && !usuario.getUsername().isEmpty()) return false;
        }

        return true;
    }
    private Usuario obtenerUsuario(String username) {
        Usuario usuario = null;
            for (Usuario usuario1 : listaUsuarios) {
                if (usuario1.getUsername().equals(username)
                        && !usuario1.getUsername().isBlank()) {
                    usuario = usuario1;
                    break;
                }
            }

        return usuario;
    }

    public boolean crearUsuario(String username,
                                String password,
                                Vendedor vendedorAsociado,
                                Administrador administradorAsociado
                                ){
        Usuario usuarioEncontrado = obtenerUsuario(username);
        if(verificarUsuarioRepetido(username)){
            if (usuarioEncontrado == null) {
                Usuario usuario = getBuildUsuario(username, password, vendedorAsociado, administradorAsociado);
                agregarRedSocial(usuario);
                return true;
            }
        }
        return  false;
    }

    public boolean crearUsuario(Usuario nuevoUsuario){
        Usuario usuarioEncontrado = obtenerUsuario(nuevoUsuario.getUsername());
        if (verificarUsuarioRepetido(nuevoUsuario.getUsername())){
            if (usuarioEncontrado == null) {
                agregarRedSocial(nuevoUsuario);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarUsuario(String username) {
        Usuario usuarioEncontrado = obtenerUsuario(username);
        if (usuarioEncontrado!=null) {
            listaUsuarios.remove(usuarioEncontrado);
            return true;
        }
        return false;
    }

    public boolean actualizarUsuario(String username, Usuario usuario) {
        Usuario usuarioEncontrado = obtenerUsuario(username);
        if(usuarioEncontrado != null) {
            if (verificarUsuarioRepetido(usuario.getUsername()) && usuarioEncontrado.getUsername().equals(username)) {
                for (Usuario usuario1 : listaUsuarios) {
                    if (usuario1.getUsername().equals(username)) {
                        usuario1.setUsername(usuario.getUsername());
                        usuario1.setPassword(usuario.getPassword());
                        return true;
                    }
                }
            }
        }

        return false;
    }
    private Usuario getBuildUsuario(String username, String password, Vendedor vendedorAsociado, Administrador administradorAsociado) {
        return Usuario.builder()
                .username(username)
                .password(password)
                .vendedorAsociado(vendedorAsociado)
                .administradorAsociado(administradorAsociado)
                .build();
    }

    //CRUD VENDEDOR

    private boolean verificarVendedorRepetido(String id) {
        if (id == null || id.isBlank()) return false;
        for (Vendedor vendedor : listaVendedores) {
            if (vendedor.getId().equals(id) && !vendedor.getId().isBlank()) return false;
        }

        return true;
    }

    private Vendedor obtenerVendedor(String id) {
        Vendedor vendedor = null;
        for (Vendedor vendedor1 : listaVendedores) {
                if (vendedor1.getId().equals(id)
                        && !vendedor1.getId().isBlank()) {
                    vendedor = vendedor1;
                    break;
                }
            }

        return vendedor;
    }

    public boolean crearVendedor(Usuario usuarioAsociado, String direccion, String email,
                                 String apellido, String nombre, String id){
        Usuario vendedorEncontrado = obtenerUsuario(id);
        if(verificarVendedorRepetido(id)){
            if (vendedorEncontrado == null) {
                Vendedor vendedor = getBuildVendedor(usuarioAsociado, direccion, email, apellido, nombre, id);
                agregarRedSocial(vendedor);
                return true;
            }
        }
        return  false;
    }

    public boolean crearVendedor(Vendedor nuevoVendedor){
        Vendedor vendedorEncontrado = obtenerVendedor(nuevoVendedor.getId());
        if (comprobarDatosVendedor(nuevoVendedor)){
            if (vendedorEncontrado == null) {
                agregarRedSocial(nuevoVendedor);
                agregarRedSocial(nuevoVendedor.getUsuarioAsociado());
                return true;
            }
        }
        return false;
    }

    public boolean eliminarVendedor(String id) {
        Vendedor encontrarVendedor = obtenerVendedor(id);
        if (encontrarVendedor!=null) {
            listaVendedores.remove(encontrarVendedor);
            return true;
        }

        return false;
    }

    @Override
    public boolean actualizarVendedor(String id, String username, Vendedor vendedor) {
        Vendedor vendedorEncontrado = obtenerVendedor(id);
        if (vendedorEncontrado != null) {
            if (vendedorEncontrado.getId().equals(id)) {
                for (Vendedor vendedor1 : listaVendedores) {
                    if (vendedor1.getId().equals(id) && vendedor1.getUsuarioAsociado().getUsername().equals(username)) {
                        vendedor1.setNombre(vendedor.getNombre());
                        vendedor1.setApellido(vendedor.getApellido());
                        vendedor1.setDireccion(vendedor.getDireccion());
                        vendedor1.setId(vendedor.getId());
                        vendedor1.setEmail(vendedor.getEmail());
                        vendedor1.getUsuarioAsociado().setUsername(vendedor.getUsuarioAsociado().getUsername());
                        vendedor1.getUsuarioAsociado().setPassword(vendedor.getUsuarioAsociado().getPassword());
                        return true;
                    }
                }
            }
        }

        return false;
    }

    @Override
    public boolean comprobarDatosVendedor(Vendedor vendedor) {
        for (Vendedor vendedor1 : listaVendedores) {
            if (vendedor1.getId().equals(vendedor.getId())) {
                return false;
            }
            if (vendedor1.getUsuarioAsociado().getUsername().equals(vendedor.getUsuarioAsociado().getUsername())) {
                return false;
            }
        }

        return true;
    }

    private Vendedor getBuildVendedor(Usuario usuarioAsociado, String direccion, String email,
                                      String apellido, String nombre, String id) {
        return Vendedor.builder()
                .usuarioAsociado(usuarioAsociado)
                .direccion(direccion)
                .email(email)
                .apellido(apellido)
                .nombre(nombre)
                .build();
    }

    @Override
    public String cantProductosFechas(LocalDate v1, LocalDate v2) {
        return Integer.toString(listaProductos.stream()
                .filter(n -> n.getFechaPublicacion().isAfter(v1) && n.getFechaPublicacion().isBefore(v2))
                .toList().size());
    }


    //CRUD PRODUCTO
    @Override
    public Producto encontrarProducto(String id) {
        Producto producto = null;
        for (Producto producto1 : listaProductos) {
            if (producto1.getId().equals(id)) {
                producto = producto1;
            }
        }

        return producto;
    }

    @Override
    public boolean agregarProducto(Producto producto, Vendedor vendedor) {
        Producto productoEncontrado = encontrarProducto(producto.getId());
        if (productoEncontrado == null) {
            vendedor.agregarProducto(producto);
            agregarRedSocial(producto);
            return true;
        }
        return false;
    }

    @Override
    public boolean actualizarProducto(Producto productoSeleccionado, Producto productoField) {
        Producto productoEncontrado = encontrarProducto(productoSeleccionado.getId());

        if (productoEncontrado != null) {
            productoEncontrado.setNombre(productoField.getNombre());
            productoEncontrado.setEstadoProducto(productoField.getEstadoProducto());
            productoEncontrado.setDescripcion(productoField.getDescripcion());
            productoEncontrado.setPrecio(productoField.getPrecio());
            productoEncontrado.setImagen(productoField.getImagen());
            return true;
        }

        return false;
    }

    @Override
    public boolean addLikeProducto(Producto productoSeleccionadoPublicado, Vendedor vendedor) {
        Producto productoEncontrado = encontrarProducto(productoSeleccionadoPublicado.getId());
        return productoEncontrado.getPublicacionAsociado().addLike(vendedor);
    }

    @Override
    public boolean removeLikeProducto(Producto productoSeleccionadoPublicado, Vendedor vendedor) {
        Producto productoEncontrado = encontrarProducto(productoSeleccionadoPublicado.getId());
        return productoEncontrado.getPublicacionAsociado().removeLike(vendedor);
    }

    @Override
    public int getLikesProducto(Producto productoSeleccionadoPublicado) {
        return encontrarProducto(productoSeleccionadoPublicado.getId()).getPublicacionAsociado().getLike();
    }

    @Override
    public List<String> getComentariosProducto(Producto productoSeleccionadoPublicado) {
        return encontrarProducto(productoSeleccionadoPublicado.getId()).getPublicacionAsociado().getListaComentarios();
    }

    @Override
    public List<Producto> getProductosPublicados() {
        return listaProductos.stream().filter(n -> n.getEstadoProducto().equals(EstadoProducto.PUBLICADO)).toList();
    }

    @Override
    public void agregarComentarioProducto(Producto productoSeleccionadoPublicado, String text) {
        encontrarProducto(productoSeleccionadoPublicado.getId()).getPublicacionAsociado().getListaComentarios().add(text);
    }

    @Override
    public boolean usuarioDioLike(Producto productoSeleccionadoPublicado, Vendedor vendedorAsociado) {
        return encontrarProducto(productoSeleccionadoPublicado.getId()).getPublicacionAsociado().dioLike(vendedorAsociado);
    }

    @Override
    public List<Producto> getProductosVendedor(Vendedor vendedor) {
        return obtenerVendedor(vendedor.getId()).getProductosAsociados();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public List<Administrador> getListaAdministradores() {
        return listaAdministradores;
    }

    public void setListaAdministradores(List<Administrador> listaAdministradores) {
        this.listaAdministradores = listaAdministradores;
    }

    public List<Vendedor> getListaVendedores() {
        return listaVendedores;
    }

    public void setListaVendedores(List<Vendedor> listaVendedores) {
        this.listaVendedores = listaVendedores;
    }

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }



}
