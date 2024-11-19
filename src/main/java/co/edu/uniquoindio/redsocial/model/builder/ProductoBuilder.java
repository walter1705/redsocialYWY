package co.edu.uniquoindio.redsocial.model.builder;

import co.edu.uniquoindio.redsocial.model.EstadoProducto;
import co.edu.uniquoindio.redsocial.model.Producto;
import co.edu.uniquoindio.redsocial.model.Publicacion;
import co.edu.uniquoindio.redsocial.model.Vendedor;

import java.time.LocalDate;

public class ProductoBuilder {
    protected String nombre, imagen, categoria, id, descripcion;
    protected EstadoProducto estadoProducto;
    protected double precio;
    protected Vendedor vendedorAsociado;
    protected LocalDate fechaPublicacion;
    protected Publicacion publicacion;

    public ProductoBuilder publicacion(Publicacion publicacion) {
        this.publicacion = publicacion;
        return this;
    }

    public ProductoBuilder nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }
    public ProductoBuilder id(String id) {
        this.id = id;
        return this;
    }

    public ProductoBuilder descripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public ProductoBuilder imagen(String imagen) {
        this.imagen = imagen;
        return this;
    }

    public ProductoBuilder categoria(String categoria) {
        this.categoria = categoria;
        return this;
    }

    public ProductoBuilder estadoProducto(EstadoProducto estadoProducto) {
        this.estadoProducto = estadoProducto;
        return this;
    }

    public ProductoBuilder precio(double precio) {
        this.precio = precio;
        return this;
    }

    public ProductoBuilder vendedorAsociado(Vendedor vendedor) {
        this.vendedorAsociado = vendedor;
        return this;
    }

    public ProductoBuilder fechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
        return this;
    }

    public Producto build() {
        return new Producto(nombre, imagen, categoria, estadoProducto, precio, vendedorAsociado, fechaPublicacion, id , descripcion, publicacion);
    }


}
