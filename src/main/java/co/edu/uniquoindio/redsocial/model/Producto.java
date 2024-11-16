package co.edu.uniquoindio.redsocial.model;

import co.edu.uniquoindio.redsocial.model.builder.ProductoBuilder;

import java.time.LocalDate;

public class Producto {
    private String nombre, imagen, categoria, id, descripcion;
    private EstadoProducto estadoProducto;
    private double precio;
    private Vendedor vendedorAsociado;
    private Publicacion publicacionAsociado;
    private LocalDate fechaPublicacion;

    public Producto(String nombre, String imagen, String categoria,
                    EstadoProducto estadoProducto, double precio, Vendedor vendedorAsociado,
                    LocalDate fechaPublicacion, String id, String descripcion) {
        this.vendedorAsociado = vendedorAsociado;
        this.nombre = nombre;
        this.imagen = imagen;
        this.categoria = categoria;
        this.estadoProducto = estadoProducto;
        this.precio = precio;
        this.fechaPublicacion = fechaPublicacion;
        this.id = id;
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Publicacion getPublicacionAsociado() {
        return publicacionAsociado;
    }

    public void setPublicacionAsociado(Publicacion publicacionAsociado) {
        this.publicacionAsociado = publicacionAsociado;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public static ProductoBuilder builder() {
        return new ProductoBuilder();
    }

    public Vendedor getVendedorAsociado() {
        return vendedorAsociado;
    }

    public void setVendedorAsociado(Vendedor vendedorAsociado) {
        this.vendedorAsociado = vendedorAsociado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public EstadoProducto getEstadoProducto() {
        return estadoProducto;
    }

    public void setEstadoProducto(EstadoProducto estadoProducto) {
        this.estadoProducto = estadoProducto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
