package co.edu.uniquoindio.redsocial.model;

import java.util.ArrayList;
import java.util.List;

public class Muro {
    private List<String> listaMensajes = new ArrayList<>();
    private List<Publicacion> listaPublicaciones = new ArrayList<>();


    public List<String> getListaMensajes() {
        return listaMensajes;
    }

    public void setListaMensajes(List<String> listaMensajes) {
        this.listaMensajes = listaMensajes;
    }

    public List<Publicacion> getListaPublicaciones() {
        return listaPublicaciones;
    }

    public void setListaPublicaciones(List<Publicacion> listaPublicaciones) {
        this.listaPublicaciones = listaPublicaciones;
    }
}
