package co.edu.uniquoindio.redsocial.service;

public interface ILogger {
    //Servicio destinado a la funcionalidad de exportar estadisticas en txt
    //mediante el uso de patron Strategy
    void write(String mensaje);
}
