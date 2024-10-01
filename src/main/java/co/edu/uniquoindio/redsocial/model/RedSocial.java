package co.edu.uniquoindio.redsocial.model;

import java.util.ArrayList;
import java.util.List;

public class RedSocial {
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
    private Usuario obtenerUsuario(String username) {
        Usuario usuario = null;
        for (Usuario usuario1: listaUsuarios) {
            if(usuario1.getUsername().equals(username)){
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
        if(usuarioEncontrado == null){
            Usuario usuario = getBuildUsuario(username, password, vendedorAsociado, administradorAsociado);
            agregarRedSocial(usuario);
            return true;
        }
        return  false;
    }

    public boolean crearUsuario(Usuario nuevoUsuario){
        Usuario usuarioEncontrado = obtenerUsuario(nuevoUsuario.getUsername());
        if(usuarioEncontrado == null) {
            agregarRedSocial(nuevoUsuario);
            return true;
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
    private Vendedor obtenerVendedor(String id) {
        Vendedor vendedor = null;
        for (Vendedor vendedor1: listaVendedores) {
            if(!vendedor1.getId().equals(id)){
                vendedor = vendedor1;
                break;
            }
        }

        return vendedor;
    }

    public boolean crearVendedor(Usuario usuarioAsociado, String direccion, String email,
                                 String apellido, String nombre, String id){
        Usuario vendedorEncontrado = obtenerUsuario(id);
        if(vendedorEncontrado == null){
            Vendedor vendedor = getBuildVendedor(usuarioAsociado, direccion, email, apellido, nombre, id);
            agregarRedSocial(vendedor);
            return true;
        }
        return  false;
    }

    public boolean crearVendedor(Vendedor nuevoVendedor){
        Vendedor vendedorEncontrado = obtenerVendedor(nuevoVendedor.getId());
        if(vendedorEncontrado == null) {
            agregarRedSocial(nuevoVendedor);
            return true;
        }
        return  false;
    }

    public void eliminarVendedor(String id) {
        Vendedor encontrarVendedor = obtenerVendedor(id);
        if (encontrarVendedor!=null) {
            listaVendedores.remove(encontrarVendedor);
        }
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
