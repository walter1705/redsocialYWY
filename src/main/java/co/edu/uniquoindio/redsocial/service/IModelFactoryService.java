package co.edu.uniquoindio.redsocial.service;


import co.edu.uniquoindio.redsocial.model.Producto;
import co.edu.uniquoindio.redsocial.model.Usuario;
import co.edu.uniquoindio.redsocial.model.Vendedor;

import java.time.LocalDate;
import java.util.List;

public interface IModelFactoryService {
    List<Vendedor> obtenerVendedores();

    boolean agregarVendedor(Vendedor vendedor);

    boolean actualizarVendedor(String id, String username, Vendedor vendedor);

    boolean eliminarVendedor(Vendedor vendedor);

    List<Usuario> getUsuarios();

    String cantProductosFechas(LocalDate d1, LocalDate d2);

    boolean agregarProducto(Producto producto);

    String generarIdProducto();

    List<Producto> getProductos();

    boolean actualizarProducto(Producto productoSeleccionado, Producto productoField);
}
