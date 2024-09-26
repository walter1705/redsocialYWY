package co.edu.uniquoindio.redsocial.redsocial.model;

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
    public void agregarRedSocial(Administrador administrador) {listaAdministradores.add(administrador);}
    //Metodo agregar Vendedor
    public void agregarRedSocial(Vendedor vendedor) {listaVendedores.add(vendedor);}
    //Metodo agregar Producto
    public void agregarRedSocial(Producto producto) {listaProductos.add(producto);}
}
