package co.edu.uniquoindio.redsocial.controller;

import co.edu.uniquoindio.redsocial.factory.ModelFactory;
import co.edu.uniquoindio.redsocial.model.Producto;

public class VendedorTemplateController {
    ModelFactory modelFactory = ModelFactory.getInstance();


    public boolean agregarProducto(Producto producto) {
        return modelFactory.agregarProducto(producto);
    }
}
