package co.edu.uniquoindio.redsocial.service;

import co.edu.uniquoindio.redsocial.model.Producto;
import co.edu.uniquoindio.redsocial.model.Usuario;
import co.edu.uniquoindio.redsocial.model.Vendedor;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface IRedSocial {
    boolean eliminarUsuario(String username);

    boolean actualizarUsuario(String username, Usuario usuario);

    boolean actualizarVendedor(String id, String username, Vendedor vendedor);
    boolean comprobarDatosVendedor(Vendedor vendedor);
    boolean eliminarVendedor(String id);

    String cantProductosFechas(LocalDate v1, LocalDate v2);
    //CRUD PRODUCTO
    Producto encontrarProducto(String id);
    boolean agregarProducto(Producto producto, Vendedor vendedor);


    boolean actualizarProducto(Producto productoSeleccionado, Producto productoField);

    boolean addLikeProducto(Producto productoSeleccionadoPublicado, Vendedor vendedor);

    boolean removeLikeProducto(Producto productoSeleccionadoPublicado, Vendedor vendedor);

    int getLikesProducto(Producto productoSeleccionadoPublicado);

    List<String> getComentariosProducto(Producto productoSeleccionadoPublicado);

    List<Producto> getProductosPublicados();

    void agregarComentarioProducto(Producto productoSeleccionadoPublicado, String text);

    boolean usuarioDioLike(Producto productoSeleccionadoPublicado, Vendedor vendedorAsociado);

    List<Producto> getProductosVendedor(Vendedor vendedor);

    Map<String, String> obtenerDiccionarioVendedoresUser();
}
