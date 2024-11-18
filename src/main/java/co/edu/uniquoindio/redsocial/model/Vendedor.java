package co.edu.uniquoindio.redsocial.model;

import co.edu.uniquoindio.redsocial.mediator.ChatMediator;
import co.edu.uniquoindio.redsocial.model.builder.VendedorBuilder;

import java.util.ArrayList;
import java.util.List;

public class Vendedor extends Persona{
    private List<Producto> productosAsociados = new ArrayList<>();
    private List<Vendedor> vendedoresAliados = new ArrayList<>();
    private List<Mensaje> mensajesRecibidos = new ArrayList<>();

    private Muro muroAsociado;


    public Vendedor(Usuario usuarioAsociado, String direccion, String email,
                    String apellido, String nombre, String id, Muro muroAsociado) {
        super(usuarioAsociado, direccion, email, apellido, nombre, id);
        this.muroAsociado = muroAsociado;
    }

    public List<Mensaje> getMensajesRecibidos() {
        return mensajesRecibidos;
    }

    public List<Producto> getProductosAsociados() {
        return productosAsociados;
    }

    public void setProductosAsociados(List<Producto> productosAsociados) {
        this.productosAsociados = productosAsociados;
    }

    public Muro getMuroAsociado() {
        return muroAsociado;
    }

    public void setMuroAsociado(Muro muroAsociado) {
        this.muroAsociado = muroAsociado;
    }

    public void agregarProducto(Producto producto) {
        productosAsociados.add(producto);
    }
    //BUILDER
    public static VendedorBuilder builder() {
        return new VendedorBuilder();
    }

    public List<Vendedor> getVendedoresAliados() {
        return vendedoresAliados;
    }

    public void setVendedoresAliados(List<Vendedor> vendedoresAliados) {
        this.vendedoresAliados = vendedoresAliados;
    }
}
