package co.edu.uniquoindio.redsocial.service;

import co.edu.uniquoindio.redsocial.mapping.dto.AdministradorDto;
import co.edu.uniquoindio.redsocial.mapping.dto.UsuarioDto;
import co.edu.uniquoindio.redsocial.mapping.dto.UsuarioVendedorDto;
import co.edu.uniquoindio.redsocial.mapping.dto.VendedorDto;
import co.edu.uniquoindio.redsocial.model.Administrador;

import java.util.List;

public interface IModelFactoryService {
    List<UsuarioVendedorDto> getUsuariosVendedoresDto();
    List<UsuarioDto> getUsuariosDto();
    List<AdministradorDto> getAdministradoresDto();

    boolean agregarUsuarioDto(UsuarioVendedorDto usuarioVendedorDto);
    boolean agregarVendedorDto(UsuarioVendedorDto usuarioVendedorDto);
    boolean eliminarUsuarioVendedor(UsuarioVendedorDto vendedorSelecionado);

    boolean actualizarUsuario(String username, UsuarioVendedorDto usuarioVendedorDto);
    boolean actualizarVendedor(String id, UsuarioVendedorDto usuarioVendedorDto);
}
