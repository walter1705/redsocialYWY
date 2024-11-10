package co.edu.uniquoindio.redsocial.service;

import co.edu.uniquoindio.redsocial.model.Usuario;

public interface ILoggerStrategy {
    //Servicio destinado a la funcionalidad de exportar estadisticas en txt
    //mediante el uso de patron Strategy
    void write(String data, String fecha, String path, String titulo, Usuario usuario);
    String conseguirNombreUnicoPath(String filePath);
}
