package co.edu.uniquoindio.redsocial.model.builder;

import co.edu.uniquoindio.redsocial.model.EstadoProducto;
import co.edu.uniquoindio.redsocial.model.Producto;
import co.edu.uniquoindio.redsocial.model.Vendedor;

public class ProductoBuilder {
    protected String nombre, imagen, categoria;
    protected EstadoProducto estadoProducto;
    protected double precio;
    protected Vendedor vendedorAsociado;

    public ProductoBuilder nombre(String nombre) {
        this.nombre = nombre;
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

    public Producto build() {
        return new Producto(nombre, imagen, categoria, estadoProducto, precio, vendedorAsociado);
    }
}
