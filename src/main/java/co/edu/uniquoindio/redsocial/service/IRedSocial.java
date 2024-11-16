package co.edu.uniquoindio.redsocial.service;

import co.edu.uniquoindio.redsocial.model.Producto;
import co.edu.uniquoindio.redsocial.model.Usuario;
import co.edu.uniquoindio.redsocial.model.Vendedor;

import java.time.LocalDate;

public interface IRedSocial {
    boolean eliminarUsuario(String username);

    boolean actualizarUsuario(String username, Usuario usuario);

    boolean actualizarVendedor(String id, String username, Vendedor vendedor);
    boolean comprobarDatosVendedor(Vendedor vendedor);
    boolean eliminarVendedor(String id);

    String cantProductosFechas(LocalDate v1, LocalDate v2);
    //CRUD PRODUCTO
    Producto encontrarProducto(String id);
    boolean agregarProducto(Producto producto);


}
