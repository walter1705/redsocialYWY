package co.edu.uniquoindio.redsocial.factory;

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
        List<VendedorDto> vendedoresDto =  mapper.getVendedoresDto(redSocial.getListaVendedores());
        List<UsuarioDto> usuariosDto =  mapper.getUsuariosDto(redSocial.getListaUsuarios());
        return mapper.getUsuariosVendedoresDto(vendedoresDto, usuariosDto);
    }

    @Override
    public List<UsuarioDto> getUsuariosDto() {
        return mapper.getUsuariosDto(redSocial.getListaUsuarios());
    }
}
