package co.edu.uniquoindio.redsocial.controller;

import co.edu.uniquoindio.redsocial.factory.ModelFactory;
import co.edu.uniquoindio.redsocial.model.Persona;
import co.edu.uniquoindio.redsocial.model.Producto;
import co.edu.uniquoindio.redsocial.model.Usuario;
import co.edu.uniquoindio.redsocial.service.ILoggerStrategy;

import java.time.LocalDate;
import java.util.List;

public class EstadisticasController {
    ModelFactory modelFactory = ModelFactory.getInstance();


    public String cantProductosFechas(LocalDate d1, LocalDate d2) {
        return modelFactory.cantProductosFechas(d1, d2);
    }


    public List<Producto> getTop3MostLikedProducts() {
        return modelFactory.getTop3MostLikedProducts();
    }

    public void exportarEstadisticas(ILoggerStrategy logger, String directory, String log, Usuario usuario) {
        modelFactory.exportarEstadisticas(logger, directory, log, usuario);
    }

    public Persona getPersonaOnSession() {
        return modelFactory.getUsuarioOnSession();
    }

    public List<Producto> getCantProductosFechas(LocalDate d1, LocalDate d2) {
        return modelFactory.getCantProductosFechas(d1, d2);
    }
}
