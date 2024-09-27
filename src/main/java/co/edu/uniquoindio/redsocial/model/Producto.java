package co.edu.uniquoindio.redsocial.model;

public class Producto {
    private String nombre, imagen, categoria;
    private EstadoProducto estadoProducto;
    private double precio;
    private Vendedor vendedorAsociado;

    public Producto(String nombre, String imagen, String categoria,
                    EstadoProducto estadoProducto, double precio, Vendedor vendedorAsociado) {
        this.vendedorAsociado = vendedorAsociado;
        this.nombre = nombre;
        this.imagen = imagen;
        this.categoria = categoria;
        this.estadoProducto = estadoProducto;
        this.precio = precio;
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
