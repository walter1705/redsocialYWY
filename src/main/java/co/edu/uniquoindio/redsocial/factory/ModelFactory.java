package co.edu.uniquoindio.redsocial.factory;


import co.edu.uniquoindio.redsocial.model.Logger;
import co.edu.uniquoindio.redsocial.model.RedSocial;
import co.edu.uniquoindio.redsocial.model.Usuario;
import co.edu.uniquoindio.redsocial.model.Vendedor;
import co.edu.uniquoindio.redsocial.service.IModelFactoryService;
import co.edu.uniquoindio.redsocial.utils.DataUtil;

import java.util.List;

public class ModelFactory implements IModelFactoryService {
    private static ModelFactory modelFactory;
    private RedSocial redSocial;
    private Logger logger;

    private ModelFactory() {
        redSocial = DataUtil.inicializarDatosPrueba();;
        logger = new Logger();
    }

    public static ModelFactory getInstance() {
        if (modelFactory==null)  modelFactory = new ModelFactory();
        return modelFactory;
    }


    @Override
    public List<Vendedor> obtenerVendedores() {
        return redSocial.getListaVendedores();
    }

    @Override
    public boolean agregarVendedor(Vendedor vendedor) {
        return redSocial.crearVendedor(vendedor);
    }

    @Override
    public boolean actualizarVendedor(String id, Vendedor vendedor) {
        return redSocial.actualizarVendedor(id, vendedor);
    }

    @Override
    public boolean eliminarVendedor(Vendedor vendedor) {
        return redSocial.eliminarVendedor(vendedor.getId());
    }



    @Override
    public List<Usuario> getUsuarios() {
        return redSocial.getListaUsuarios();
    }
}
