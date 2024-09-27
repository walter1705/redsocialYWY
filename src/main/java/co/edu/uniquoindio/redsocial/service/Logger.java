package co.edu.uniquoindio.redsocial.service;

public interface Logger {
    //Servicio destinado a la funcionalidad de exportar estadisticas en txt
    //mediante el uso de patron Strategy
    void write(String mensaje);
}
