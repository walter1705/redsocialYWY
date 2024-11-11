package co.edu.uniquoindio.redsocial.model;

import java.util.ArrayList;
import java.util.List;

public class Publicacion {
    private int like;
    private List<Comentario> listaComentarios = new ArrayList<>();
    //private int dislike;

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public List<Comentario> getListaComentarios() {
        return listaComentarios;
    }

    public void setListaComentarios(List<Comentario> listaComentarios) {
        this.listaComentarios = listaComentarios;
    }
}
