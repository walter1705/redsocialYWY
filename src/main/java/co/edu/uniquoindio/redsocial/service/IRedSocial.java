package co.edu.uniquoindio.redsocial.service;

import co.edu.uniquoindio.redsocial.model.Producto;
import co.edu.uniquoindio.redsocial.model.Usuario;
import co.edu.uniquoindio.redsocial.model.Vendedor;

import java.time.LocalDate;
import java.util.List;

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


    boolean actualizarProducto(Producto productoSeleccionado, Producto productoField);

    void addLikeProducto(Producto productoSeleccionadoPublicado);

    void removeLikeProducto(Producto productoSeleccionadoPublicado);

    int getLikesProducto(Producto productoSeleccionadoPublicado);

    List<String> getComentariosProducto(Producto productoSeleccionadoPublicado);

    List<Producto> getProductosPublicados();

    void agregarComentarioProducto(Producto productoSeleccionadoPublicado, String text);

}
