package co.edu.uniquoindio.redsocial.model;

import co.edu.uniquoindio.redsocial.model.builder.VendedorBuilder;

import java.util.ArrayList;
import java.util.List;

public class Vendedor extends Persona{
    private List<Producto> productosAsociados = new ArrayList<>();

    public Vendedor(Usuario usuarioAsociado, String direccion, String email, String apellido, String nombre, String id){
        super(usuarioAsociado, direccion, email, apellido, nombre, id);
    }
    //Metodo agregar un producto a el vendedor
    public void agregarProducto(Producto producto) {
        productosAsociados.add(producto);
    }
    //BUILDER
    public static VendedorBuilder builder() {
        return new VendedorBuilder();
    }
}
