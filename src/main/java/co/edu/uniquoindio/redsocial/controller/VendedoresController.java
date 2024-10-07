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

    public boolean agregarUsuarioDto(UsuarioVendedorDto usuarioVendedorDto) {
        return modelFactory.agregarUsuarioDto(usuarioVendedorDto);
    }

    public boolean agregarVendedorDto(UsuarioVendedorDto usuarioVendedorDto) {
        return modelFactory.agregarVendedorDto(usuarioVendedorDto);
    }

    public boolean eliminarUsuarioVendedor(UsuarioVendedorDto vendedorSelecionado) {
        return modelFactory.eliminarUsuarioVendedor(vendedorSelecionado);
    }

    public boolean actualizarUsuario(String username, UsuarioVendedorDto usuarioVendedorDto) {
        return modelFactory.actualizarUsuario(username, usuarioVendedorDto);
    }

    public boolean actualizarVendedor(String id, UsuarioVendedorDto usuarioVendedorDto) {
        return modelFactory.actualizarVendedor(id, usuarioVendedorDto);
    }
}
