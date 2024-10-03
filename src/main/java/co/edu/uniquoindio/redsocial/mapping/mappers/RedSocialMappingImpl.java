package co.edu.uniquoindio.redsocial.mapping.mappers;

import co.edu.uniquoindio.redsocial.mapping.dto.AdministradorDto;
import co.edu.uniquoindio.redsocial.mapping.dto.UsuarioDto;
import co.edu.uniquoindio.redsocial.mapping.dto.UsuarioVendedorDto;
import co.edu.uniquoindio.redsocial.mapping.dto.VendedorDto;
import co.edu.uniquoindio.redsocial.model.Administrador;
import co.edu.uniquoindio.redsocial.model.Usuario;
import co.edu.uniquoindio.redsocial.model.Vendedor;
import co.edu.uniquoindio.redsocial.model.builder.AdministradorBuilder;
import co.edu.uniquoindio.redsocial.model.builder.UsuarioBuilder;
import co.edu.uniquoindio.redsocial.model.builder.VendedorBuilder;
import co.edu.uniquoindio.redsocial.service.IRedSocialMapping;

import java.util.ArrayList;
import java.util.List;

public class RedSocialMappingImpl implements IRedSocialMapping {

    @Override
    public AdministradorDto administradorToAdministradorDto(Administrador administrador) {
        return new AdministradorDto(administrador.getNombre(),
                administrador.getApellido(),
                administrador.getEmail(),
                administrador.getId());
    }

    @Override
    public Administrador administradorDtoToAdministrador(AdministradorDto administradorDto) {
        return new AdministradorBuilder().nombre(administradorDto.nombre()).
                apellido(administradorDto.apellido()).
                email(administradorDto.email()).
                id(administradorDto.id()).
                build();
    }
    @Override
    public List<AdministradorDto> getAdministradoresDto(List<Administrador> listaAdministradores){
        if (listaAdministradores == null) {
            throw new IllegalArgumentException("LISTA ADMINISTRADORES NULA EN REDSOCIALMAPPING");
        }
        List<AdministradorDto> administradoresDto = new ArrayList<AdministradorDto>(listaAdministradores.size());
        for (Administrador administrador : listaAdministradores) {
            administradoresDto.add(administradorToAdministradorDto(administrador));
        }
        return administradoresDto;
    }
    @Override
    public VendedorDto vendedorToVendedorDto(Vendedor vendedor) {
        return new VendedorDto(vendedor.getNombre(),
                vendedor.getApellido(),
                vendedor.getEmail(),
                vendedor.getId());

    }

    @Override
    public Vendedor vendedorDtoToVendedor(VendedorDto vendedorDto) {
        return new VendedorBuilder().nombre(vendedorDto.nombre()).
                apellido(vendedorDto.apellido()).
                email(vendedorDto.email()).
                id(vendedorDto.id())
                .build();
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
    public List<VendedorDto> getVendedoresDto(List<Vendedor> listaVendedores) {
        if (listaVendedores == null) {
            throw new IllegalArgumentException("LISTA VENDEDORES NULA EN REDSOCIALMAPPING");
        }
        List<VendedorDto> vendedoresDto = new ArrayList<VendedorDto>(listaVendedores.size());
        for (Vendedor vendedor : listaVendedores) {
            vendedoresDto.add(vendedorToVendedorDto(vendedor));
        }

        return vendedoresDto;
    }

    //Metodo para mappear los dto de vendedor y usuario, para que aparezcan juntos en la tabla
    @Override
    public List<UsuarioVendedorDto> getUsuariosVendedoresDto(List<Vendedor> listaVendedores
            , List<Usuario> listaUsuarios) {
        if (listaUsuarios == null || listaVendedores == null) throw new IllegalArgumentException("BOTH OF LIST MAPPING IMPL CLASS");
        int sizeOfList =listaUsuarios.size()+listaVendedores.size();
        List<UsuarioVendedorDto> usuariosVendedoresDto = new ArrayList<UsuarioVendedorDto>(sizeOfList);
        verificarUsuarioRedunante(listaVendedores, listaUsuarios);

        for(Vendedor vendedor : listaVendedores){
            String nombreVendedor = vendedor.getNombre();
            String apellidoVendedor =vendedor.getApellido();
            String emailVendedor = vendedor.getEmail();
            String idVendedor = vendedor.getId();
            Usuario usuario = vendedor.getUsuarioAsociado();
            String username = (usuario != null) ? usuario.getUsername() : "Vendedor sin usuario";
            String password = (usuario != null) ? usuario.getPassword() : "";
            UsuarioVendedorDto usuarioVendedorDto = new UsuarioVendedorDto(
                    username, password,
                    nombreVendedor, apellidoVendedor, emailVendedor, idVendedor
            );
            usuariosVendedoresDto.add(usuarioVendedorDto);
        }
        for(Usuario usuario : listaUsuarios) {
            String username = (usuario != null) ? usuario.getUsername() : "Vendedor sin usuario";
            String password = (usuario != null) ? usuario.getPassword() : "";
            UsuarioVendedorDto usuarioVendedorDto = new UsuarioVendedorDto(
                    username, password,
                    "", "", "", ""
            );
        }

        return usuariosVendedoresDto;
    }
    @Override
    public void verificarUsuarioRedunante(List<Vendedor> listaVendedores, List<Usuario> listaUsuarios) {
        for(Vendedor vendedor : listaVendedores) {
            listaUsuarios.remove(vendedor.getUsuarioAsociado());
        }
    }



}





















