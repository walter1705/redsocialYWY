package co.edu.uniquoindio.redsocial.model;

import java.time.LocalDateTime;

public class Mensaje {
    private String contenido;
    private Vendedor remitente;
    private Vendedor destinatario;
    private LocalDateTime fechaHora;

    public Mensaje(String contenido, Vendedor remitente, Vendedor destinatario) {
        this.contenido = contenido;
        this.remitente = remitente;
        this.destinatario = destinatario;
        this.fechaHora = LocalDateTime.now();
    }

    public String getContenido() {
        return contenido;
    }

    public Vendedor getRemitente() {
        return remitente;
    }

    public Vendedor getDestinatario() {
        return destinatario;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    @Override
    public String toString() {
        return "[" + fechaHora + "] " + remitente.getNombre() + ": " + contenido;
    }
}
