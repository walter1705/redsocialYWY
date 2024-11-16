package co.edu.uniquoindio.redsocial.controller;

import co.edu.uniquoindio.redsocial.factory.ModelFactory;

import java.time.LocalDate;

public class EstadisticasController {
    ModelFactory modelFactory = ModelFactory.getInstance();


    public String cantProductosFechas(LocalDate d1, LocalDate d2) {
        return modelFactory.cantProductosFechas(d1, d2);
    }
}
