package co.edu.uniquoindio.redsocial.controller;

import co.edu.uniquoindio.redsocial.factory.ModelFactory;
import co.edu.uniquoindio.redsocial.mapping.dto.UsuarioVendedorDto;
import co.edu.uniquoindio.redsocial.mapping.dto.VendedorDto;

import java.util.List;

public class VendedoresController {
    ModelFactory modelFactory;
    public VendedoresController(){
        modelFactory = ModelFactory.getInstance();
    }

    public List<UsuarioVendedorDto> getUsuariosVendedoresDto() {
        return modelFactory.getUsuariosVendedoresDto();
    }

    public boolean agregarUsuarioVendedor(UsuarioVendedorDto usuarioVendedorDto) {
        return modelFactory.agregarUsuarioVendedor(usuarioVendedorDto);
    }

    public boolean eliminarUsuarioVendedor(UsuarioVendedorDto vendedorSelecionado) {
        return modelFactory.eliminarUsuarioVendedor(vendedorSelecionado);
    }

    public boolean actualizarUsuarioVendedor(String username, String id, UsuarioVendedorDto usuarioVendedorDto) {
        return modelFactory.actualizarUsuarioVendedor(username, id, usuarioVendedorDto);
    }
}
