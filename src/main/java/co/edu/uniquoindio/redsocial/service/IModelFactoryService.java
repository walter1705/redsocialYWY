package co.edu.uniquoindio.redsocial.service;


import co.edu.uniquoindio.redsocial.model.Usuario;
import co.edu.uniquoindio.redsocial.model.Vendedor;

import java.util.List;

public interface IModelFactoryService {
    List<Vendedor> obtenerVendedores();

    boolean agregarVendedor(Vendedor vendedor);

    boolean actualizarVendedor(String id, Vendedor vendedor);

    boolean eliminarVendedor(Vendedor vendedor);

    List<Usuario> getUsuarios();
}
