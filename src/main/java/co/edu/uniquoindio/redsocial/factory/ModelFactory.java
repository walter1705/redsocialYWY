package co.edu.uniquoindio.redsocial.factory;

import co.edu.uniquoindio.redsocial.mapping.dto.AdministradorDto;
import co.edu.uniquoindio.redsocial.mapping.dto.UsuarioDto;
import co.edu.uniquoindio.redsocial.mapping.dto.UsuarioVendedorDto;
import co.edu.uniquoindio.redsocial.mapping.dto.VendedorDto;
import co.edu.uniquoindio.redsocial.mapping.mappers.RedSocialMappingImpl;
import co.edu.uniquoindio.redsocial.model.RedSocial;
import co.edu.uniquoindio.redsocial.model.Usuario;
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

        return false;
    }

    public boolean eliminarUsuarioVendedor() {
        //redSocial.eliminarUsuario();
        //redSocial.eliminarVendedor(mapper.);
        return false;
    }
}
