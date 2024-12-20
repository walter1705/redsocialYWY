package co.edu.uniquoindio.redsocial.service;


import co.edu.uniquoindio.redsocial.model.Persona;
import co.edu.uniquoindio.redsocial.model.Producto;
import co.edu.uniquoindio.redsocial.model.Usuario;
import co.edu.uniquoindio.redsocial.model.Vendedor;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface IModelFactoryService {
    List<Vendedor> obtenerVendedores();


    boolean agregarVendedor(Vendedor vendedor);

    boolean actualizarVendedor(String id, String username, Vendedor vendedor);

    boolean eliminarVendedor(Vendedor vendedor);

    List<Usuario> getUsuarios();

    String cantProductosFechas(LocalDate d1, LocalDate d2);

    boolean agregarProducto(Producto producto, Vendedor vendedor);

    String generarIdProducto();

    List<Producto> getProductos();

    boolean actualizarProducto(Producto productoSeleccionado, Producto productoField);

    boolean addLike(Producto productoSeleccionadoPublicado, Vendedor vendedor);

    boolean removeLike(Producto productoSeleccionadoPublicado, Vendedor vendedor);


    int getLikesProducto(Producto productoSeleccionadoPublicado);

    List<String> getComentariosProducto(Producto productoSeleccionadoPublicado);

    List<Producto> getProductosPublicados();


    void agregarComentarioProducto(Producto productoSeleccionadoPublicado, String text);

    boolean usuarioDioLike(Producto productoSeleccionadoPublicado, Vendedor vendedorAsociado);

    List<Producto> getProductosVendedor(Vendedor vendedor);

    Map<String, Persona> obtenerDiccionarioVendedoresUser();

    Persona getUsuarioOnSession();

    boolean login(String username, String password);

    List<Producto> getTop3MostLikedProducts();

    void exportarEstadisticas(ILoggerStrategy logger, String directory, String log, Usuario usuario);

    List<Producto> getCantProductosFechas(LocalDate d1, LocalDate d2);
}
