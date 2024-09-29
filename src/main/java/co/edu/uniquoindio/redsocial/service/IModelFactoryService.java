package co.edu.uniquoindio.redsocial.service;

import co.edu.uniquoindio.redsocial.mapping.dto.UsuarioDto;
import co.edu.uniquoindio.redsocial.mapping.dto.UsuarioVendedorDto;
import co.edu.uniquoindio.redsocial.mapping.dto.VendedorDto;

import java.util.List;

public interface IModelFactoryService {
    List<UsuarioVendedorDto> getUsuariosVendedoresDto();
    List<UsuarioDto> getUsuariosDto();
}
