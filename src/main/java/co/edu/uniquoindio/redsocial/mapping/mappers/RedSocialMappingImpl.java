package co.edu.uniquoindio.redsocial.mapping.mappers;

import co.edu.uniquoindio.redsocial.mapping.dto.UsuarioDto;
import co.edu.uniquoindio.redsocial.mapping.dto.UsuarioVendedorDto;
import co.edu.uniquoindio.redsocial.mapping.dto.VendedorDto;
import co.edu.uniquoindio.redsocial.model.Usuario;
import co.edu.uniquoindio.redsocial.model.Vendedor;
import co.edu.uniquoindio.redsocial.model.builder.UsuarioBuilder;
import co.edu.uniquoindio.redsocial.model.builder.VendedorBuilder;
import co.edu.uniquoindio.redsocial.service.IRedSocialMapping;

import java.util.ArrayList;
import java.util.List;

public class RedSocialMappingImpl implements IRedSocialMapping {


    @Override
    public List<VendedorDto> getVendedoresDto(List<Vendedor> listaVendedores) {
       if (listaVendedores == null) {
           throw new IllegalArgumentException("LISTA VENDEDORES NULA EN REDSOCIALMAPPING");
       }
       List<VendedorDto> vendedoresDto = new ArrayList<VendedorDto>(listaVendedores.size());
       for(Vendedor vendedor : listaVendedores) {
           vendedoresDto.add(vendedorToVendedorDto(vendedor));
       }

       return vendedoresDto;
    }

    @Override
    public VendedorDto vendedorToVendedorDto(Vendedor vendedor) {
        return new VendedorDto(vendedor.getNombre(),
                vendedor.getApellido(),
                vendedor.getEmail());

    }

    @Override
    public Vendedor vendedorDtoToVendedor(VendedorDto vendedorDto) {
        return new VendedorBuilder().nombre(vendedorDto.nombre()).
                apellido(vendedorDto.apellido()).
                email(vendedorDto.email()).
                build();
    }

    @Override
    public List<UsuarioDto> getUsuariosDto(List<Usuario> listaUsuarios) {
        if (listaUsuarios == null) {
            throw new IllegalArgumentException("LISTA USUARIOS NULA EN REDSOCIALMAPPING");
        }
        List<UsuarioDto> usuariosDto = new ArrayList<UsuarioDto>(listaUsuarios.size());
        for(Usuario usuario : listaUsuarios) {
            usuariosDto.add(usuarioToUsuarioDto(usuario));
        }

        return usuariosDto;
    }

    @Override
    public UsuarioDto usuarioToUsuarioDto(Usuario usuario) {
        return new UsuarioDto(usuario.getUsername(), usuario.getPassword());
    }

    @Override
    public Usuario usuarioDtoToUsuario(UsuarioDto usuarioDto) {
        return new UsuarioBuilder()
                .username(usuarioDto.username())
                .password(usuarioDto.password())
                .build();
    }

    @Override
    public List<UsuarioVendedorDto> getUsuariosVendedoresDto(List<VendedorDto> listaVendedoresDto
            , List<UsuarioDto> listaUsuariosDto) {
        return List.of();
    }
}
