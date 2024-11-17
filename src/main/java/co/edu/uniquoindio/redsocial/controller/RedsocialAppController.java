package co.edu.uniquoindio.redsocial.controller;

import co.edu.uniquoindio.redsocial.factory.ModelFactory;
import co.edu.uniquoindio.redsocial.model.Producto;

import java.util.List;

public class RedsocialAppController {
    ModelFactory modelFactory = ModelFactory.getInstance();


    public List<Producto> getProductoPublicados() {
        return modelFactory.getProductosPublicados();
    }
}
