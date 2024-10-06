package co.edu.uniquoindio.redsocial.factory;

import co.edu.uniquoindio.redsocial.mapping.dto.AdministradorDto;
import co.edu.uniquoindio.redsocial.mapping.dto.UsuarioDto;
import co.edu.uniquoindio.redsocial.mapping.dto.UsuarioVendedorDto;
import co.edu.uniquoindio.redsocial.mapping.mappers.RedSocialMappingImpl;
import co.edu.uniquoindio.redsocial.model.RedSocial;
import co.edu.uniquoindio.redsocial.service.IModelFactoryService;
import co.edu.uniquoindio.redsocial.service.IRedSocialMapping;
import co.edu.uniquoindio.redsocial.utils.DataUtil;

import java.util.List;

public class ModelFactory implements IModelFactoryService {
    private static ModelFactory modelFactory;
    private RedSocial redSocial;
    private IRedSocialMapping mapper;

    private ModelFactory() {
        redSocial = DataUtil.inicializarDatosPrueba();;
        mapper = new RedSocialMappingImpl();
    }

    public static ModelFactory getInstance() {
        if (modelFactory==null)  modelFactory = new ModelFactory();
        return modelFactory;
    }


    @Override
    public List<UsuarioVendedorDto> getUsuariosVendedoresDto() {
        return mapper.getUsuariosVendedoresDto(redSocial.getListaVendedores(), redSocial.getListaUsuarios());
    }

    @Override
    public List<AdministradorDto> getAdministradoresDto() {
        return mapper.getAdministradoresDto(redSocial.getListaAdministradores());
    }

    @Override
    public List<UsuarioDto> getUsuariosDto() {
        return mapper.getUsuariosDto(redSocial.getListaUsuarios());
    }

    @Override
    public boolean agregarUsuarioVendedor(UsuarioVendedorDto usuarioVendedorDto) {
        boolean usuarioCreado = true;
        boolean vendedorCreado = true;

        if (usuarioVendedorDto.necesitaUsuario()) {
            usuarioCreado = redSocial.crearUsuario(mapper.usuarioVendedorDtoToUsuario(usuarioVendedorDto));
        }
        if (usuarioVendedorDto.necesitaVendedor()) {
            vendedorCreado = redSocial.crearVendedor(mapper.usuarioVendedorDtoToVendedor(usuarioVendedorDto));
        }
        return  usuarioCreado && vendedorCreado;
    }

    @Override
    public boolean eliminarUsuarioVendedor(UsuarioVendedorDto vendedorSelecionado) {
        return redSocial.eliminarVendedor(vendedorSelecionado.id())
                | redSocial.eliminarUsuario(vendedorSelecionado.username());
    }

    @Override
    public boolean actualizarUsuarioVendedor(String username, String id, UsuarioVendedorDto usuarioVendedorDto) {
        return redSocial.actualizarUsuario(username ,mapper.usuarioVendedorDtoToUsuario(usuarioVendedorDto))
                | redSocial.actualizarVendedor(id, mapper.usuarioVendedorDtoToVendedor(usuarioVendedorDto));
    }
}
