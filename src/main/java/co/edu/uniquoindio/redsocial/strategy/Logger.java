package co.edu.uniquoindio.redsocial.strategy;

import co.edu.uniquoindio.redsocial.model.Usuario;
import co.edu.uniquoindio.redsocial.service.ILoggerStrategy;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Logger {
    private ILoggerStrategy strategy;

    public void setStrategy(ILoggerStrategy strategy) {
        this.strategy = strategy;
    }

    public void logDatos(String data, String path, String titulo, Usuario usuario) {
        if (strategy != null) {

            strategy.write(data, fecha(), path+"/estadisticasMarketPlace", titulo(), usuario);
        } else {
            throw new IllegalStateException("Strategy no establecida");
        }
    }

    private String titulo() {
        return "Reporte de Listado de Clientes";
    }

    public String fecha() {
        LocalDate fechaHoy = LocalDate.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "Fecha: " + fechaHoy.format(formato);
    }
}
