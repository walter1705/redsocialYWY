package co.edu.uniquoindio.redsocial.model;

import java.util.ArrayList;
import java.util.List;

public class Publicacion {
    private int like;
    private List<String> listaComentarios = new ArrayList<>();
    //private int dislike;

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public List<String> getListaComentarios() {
        return listaComentarios;
    }

    public void setListaComentarios(List<String> listaComentarios) {
        this.listaComentarios = listaComentarios;
    }


    public void addLike() {
        this.like++;
    }

    public void removeLike() {
        if (this.like > 0) {
            this.like--;
        }
    }
}
