package co.edu.uniquoindio.redsocial.service;

import co.edu.uniquoindio.redsocial.mapping.dto.AdministradorDto;
import co.edu.uniquoindio.redsocial.mapping.dto.UsuarioDto;
import co.edu.uniquoindio.redsocial.mapping.dto.UsuarioVendedorDto;
import co.edu.uniquoindio.redsocial.mapping.dto.VendedorDto;
import co.edu.uniquoindio.redsocial.model.Administrador;
import co.edu.uniquoindio.redsocial.model.Usuario;
import co.edu.uniquoindio.redsocial.model.Vendedor;

import java.util.List;

public interface IRedSocialMapping {
    List<VendedorDto> getVendedoresDto(List<Vendedor> listaVendedores);
    List<AdministradorDto> getAdministradoresDto(List<Administrador> administradores);
    AdministradorDto administradorToAdministradorDto(Administrador administrador);
    Administrador administradorDtoToAdministrador(AdministradorDto administradorDto);
    VendedorDto vendedorToVendedorDto(Vendedor vendedor);
    Vendedor vendedorDtoToVendedor(VendedorDto vendedorDto);
    List<UsuarioDto> getUsuariosDto(List<Usuario> listaUsuarios);
    UsuarioDto usuarioToUsuarioDto(Usuario usuario);
    Usuario usuarioDtoToUsuario(UsuarioDto usuarioDto);
    List<UsuarioVendedorDto> getUsuariosVendedoresDto(List<Vendedor> listaVendedores,
                                                      List<Usuario> listaUsuarios);
    public void verificarUsuarioRedunante(List<Vendedor> listaVendedores, List<Usuario> listaUsuarios);
    
}
