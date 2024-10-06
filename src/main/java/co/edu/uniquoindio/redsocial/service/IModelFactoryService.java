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

    boolean agregarUsuarioVendedor(UsuarioVendedorDto usuarioVendedorDto);
    boolean eliminarUsuarioVendedor(UsuarioVendedorDto vendedorSelecionado);

    boolean actualizarUsuarioVendedor(String username, String id, UsuarioVendedorDto usuarioVendedorDto);
}
