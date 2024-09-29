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
    //Metodo para mappear los dto de vendedor y usuario, para que aparezcan juntos en la tabla
    @Override
    public List<UsuarioVendedorDto> getUsuariosVendedoresDto(List<VendedorDto> listaVendedoresDto
            , List<UsuarioDto> listaUsuariosDto) {
        if (listaUsuariosDto == null || listaVendedoresDto == null) throw new IllegalArgumentException("BOTH OF LIST MAPPING IMPL CLASS");
        int sizeOfList = Math.max(listaUsuariosDto.size(), listaVendedoresDto.size());
        List<UsuarioVendedorDto> usuariosVendedoresDto = new ArrayList<UsuarioVendedorDto>(sizeOfList);
        for(int i = 0;i<sizeOfList;i++) {
            VendedorDto vendedor = (i < listaVendedoresDto.size()) ? listaVendedoresDto.get(i) : null;
            UsuarioDto usuario = (i < listaUsuariosDto.size()) ? listaUsuariosDto.get(i) : null;
            String nombreVendedor = (vendedor != null) ? vendedor.nombre() : "Usuario sin vendedor";
            String apellidoVendedor = (vendedor != null) ? vendedor.apellido() : "";
            String emailVendedor = (vendedor != null) ? vendedor.email() : "";
            String username = (usuario != null) ? usuario.username() : "Vendedor sin usuario";
            String password = (usuario != null) ? usuario.password() : "";
            UsuarioVendedorDto usuarioVendedorDto = new UsuarioVendedorDto(
                    nombreVendedor, apellidoVendedor, emailVendedor,
                    username, password
            );
            usuariosVendedoresDto.add(usuarioVendedorDto);
        }

        return usuariosVendedoresDto;
    }
}





















