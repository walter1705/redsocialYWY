package co.edu.uniquoindio.redsocial.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

public class Publicacion {
    private int like;
    private List<Vendedor> likeRegistrado = new ArrayList<>();
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


    public boolean addLike(Vendedor vendedor) {
        for (Vendedor value : likeRegistrado) {
            if (Objects.equals(value.getId(), vendedor.getId())) {
                return false;
            }
        }
        this.like++;
        likeRegistrado.add(vendedor);
        return true;

    }

    public boolean removeLike(Vendedor vendedor) {
        for (Vendedor value : likeRegistrado) {
            if (Objects.equals(value.getId(), vendedor.getId())) {
                likeRegistrado.remove(value);
                this.like--;
                return true;
            }
        }

        return false;
    }

    public boolean dioLike(Vendedor vendedorAsociado) {
        return likeRegistrado.contains(vendedorAsociado);
    }
}
