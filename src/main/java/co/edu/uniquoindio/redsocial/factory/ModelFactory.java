package co.edu.uniquoindio.redsocial.factory;

import co.edu.uniquoindio.redsocial.model.RedSocial;

public class ModelFactory {
    private static ModelFactory modelFactory;
    private RedSocial redSocial;
    //private IRedSocialMapping mapper;

    private ModelFactory() {
        redSocial = new RedSocial();
        //mapper = new IRedSocialMapping();
        //inicializarDatos();
    }

    public static ModelFactory getInstance() {
        if (modelFactory==null) new ModelFactory();
        return modelFactory;
    }
}
