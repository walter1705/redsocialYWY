package co.edu.uniquoindio.redsocial.controller;

import co.edu.uniquoindio.redsocial.factory.ModelFactory;
import co.edu.uniquoindio.redsocial.model.Persona;
import co.edu.uniquoindio.redsocial.model.Producto;
import co.edu.uniquoindio.redsocial.model.Vendedor;

import java.util.List;

public class VendedorTemplateController {
    ModelFactory modelFactory = ModelFactory.getInstance();


    public boolean agregarProducto(Producto producto, Vendedor vendedor) {
        return modelFactory.agregarProducto(producto, vendedor);
    }

    public String generarIdProducto() {
        return modelFactory.generarIdProducto();
    }

    public List<Producto> getProductos() {
        return modelFactory.getProductos();
    }

    public boolean actualizarProducto(Producto productoSeleccionado, Producto productoField) {
        return modelFactory.actualizarProducto(productoSeleccionado, productoField);
    }

    public void addLike(Producto productoSeleccionadoPublicado, Vendedor vendedor) {
        modelFactory.addLike(productoSeleccionadoPublicado, vendedor);
    }

    public void removeLike(Producto productoSeleccionadoPublicado, Vendedor vendedor) {
        modelFactory.removeLike(productoSeleccionadoPublicado, vendedor);
    }


    public int getLikes(Producto productoSeleccionadoPublicado) {
        return modelFactory.getLikesProducto(productoSeleccionadoPublicado);
    }

    public List<String> getComentariosProducto(Producto productoSeleccionadoPublicado) {
        return modelFactory.getComentariosProducto(productoSeleccionadoPublicado);
    }

    public List<Producto> getProductosPublicados() {
        return modelFactory.getProductosPublicados();
    }


    public void agregarComentarioProducto(Producto productoSeleccionadoPublicado, String text) {
        modelFactory.agregarComentarioProducto(productoSeleccionadoPublicado, text);
    }

    public boolean usuarioDioLike(Producto productoSeleccionadoPublicado, Vendedor vendedorAsociado) {
        return modelFactory.usuarioDioLike(productoSeleccionadoPublicado, vendedorAsociado);
    }

    public List<Producto> getProductosVendedor(Vendedor vendedor) {
        return modelFactory.getProductosVendedor(vendedor);
    }

    public Persona getUsuarioOnSession() {
        return modelFactory.getUsuarioOnSession();
    }
}
