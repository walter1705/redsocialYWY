package co.edu.uniquoindio.redsocial.controller;

import co.edu.uniquoindio.redsocial.factory.ModelFactory;
import co.edu.uniquoindio.redsocial.model.Producto;

import java.util.List;

public class VendedorTemplateController {
    ModelFactory modelFactory = ModelFactory.getInstance();


    public boolean agregarProducto(Producto producto) {
        return modelFactory.agregarProducto(producto);
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

    public void addLike(Producto productoSeleccionadoPublicado) {
        modelFactory.addLike(productoSeleccionadoPublicado);
    }

    public void removeLike(Producto productoSeleccionadoPublicado) {
        modelFactory.removeLike(productoSeleccionadoPublicado);
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
        modelFactory.agregarComentarioProducto(productoSeleccionadoPublicado, text); // TODO Agregar el usuario que lo hace
    }
}
