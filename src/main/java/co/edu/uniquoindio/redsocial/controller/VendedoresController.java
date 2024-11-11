package co.edu.uniquoindio.redsocial.controller;

import co.edu.uniquoindio.redsocial.factory.ModelFactory;
import co.edu.uniquoindio.redsocial.model.Vendedor;

import java.util.List;

public class VendedoresController {
    ModelFactory modelFactory;
    public VendedoresController(){
        modelFactory = ModelFactory.getInstance();
    }

    public List<Vendedor> obtenerVendedores() {
        return modelFactory.obtenerVendedores();
    }

    public boolean agregarVendedor(Vendedor vendedor) {
        return modelFactory.agregarVendedor(vendedor);
    }

    public boolean actualizarVendedor(String id, Vendedor vendedor) {
        return modelFactory.actualizarVendedor(id, vendedor);
    }

    public boolean eliminarVendedor(Vendedor vendedorSelecionado) {
        return modelFactory.eliminarVendedor(vendedorSelecionado);
    }
}
