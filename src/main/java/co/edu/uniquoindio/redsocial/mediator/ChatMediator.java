package co.edu.uniquoindio.redsocial.mediator;

import co.edu.uniquoindio.redsocial.model.Mensaje;
import co.edu.uniquoindio.redsocial.model.Vendedor;

import java.util.ArrayList;
import java.util.List;

public class ChatMediator {
    private List<Vendedor> vendedores;

    public ChatMediator() {
        this.vendedores = new ArrayList<>();
    }

    public void registrarVendedor(Vendedor vendedor) {
        if (!vendedores.contains(vendedor)) {
            vendedores.add(vendedor);
        }
    }

    public void eliminarVendedor(Vendedor vendedor) {
        vendedores.remove(vendedor);
    }

    public void enviarMensaje(String contenido, Vendedor remitente, Vendedor destinatario) {
        if (vendedores.contains(remitente) && vendedores.contains(destinatario)) {
            Mensaje mensaje = new Mensaje(contenido, remitente, destinatario);
            System.out.println("Mensaje enviado de " + remitente.getNombre() + " a " + destinatario.getNombre());
        } else {
            System.out.println("Uno de los vendedores no está registrado en el mediador.");
        }
    }
}
