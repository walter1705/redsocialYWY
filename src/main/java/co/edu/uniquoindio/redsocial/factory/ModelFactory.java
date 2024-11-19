package co.edu.uniquoindio.redsocial.factory;


import co.edu.uniquoindio.redsocial.model.*;
import co.edu.uniquoindio.redsocial.proxy.LoginProxy;
import co.edu.uniquoindio.redsocial.proxy.LoginService;
import co.edu.uniquoindio.redsocial.service.ILoggerStrategy;
import co.edu.uniquoindio.redsocial.service.IModelFactoryService;
import co.edu.uniquoindio.redsocial.strategy.Logger;
import co.edu.uniquoindio.redsocial.utils.DataUtil;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class ModelFactory implements IModelFactoryService {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(ModelFactory.class);
    private static ModelFactory modelFactory;
    private RedSocial redSocial;
    private Logger logger;
    private LoginProxy loginProxy;
    private LoginService loginService;

    private ModelFactory() {
        redSocial = DataUtil.inicializarDatosPrueba();;
        logger = new Logger();
        loginService = new LoginService();
        loginProxy = new LoginProxy(loginService);
        loginService.setUsuarios(obtenerDiccionarioVendedoresUser());
    }

    public Map<String, Persona> obtenerDiccionarioVendedoresUser() {
        return redSocial.obtenerDiccionarioVendedoresUser();
    }

    @Override
    public Persona getUsuarioOnSession() {
        return loginService.getPersonaOnSesion();
    }

    @Override
    public boolean login(String username, String password) {
        return loginProxy.login(username, password);
    }

    @Override
    public List<Producto> getTop3MostLikedProducts() {
        return redSocial.getTop3MostLikedProducts() ;
    }

    @Override
    public void exportarEstadisticas(ILoggerStrategy logger, String directory, String log, Usuario usuario) {
        this.logger.setStrategy(logger);
        this.logger.logDatos(log, directory, "", usuario);
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
        boolean si = redSocial.crearVendedor(vendedor);
        agregarVendedorChat(vendedor);
        if (si) loginService.setUsuarios(obtenerDiccionarioVendedoresUser());
        return si;
    }

    private void agregarVendedorChat(Vendedor vendedor) {

    }

    @Override
    public boolean actualizarVendedor(String id, String username, Vendedor vendedor) {
        boolean si = redSocial.actualizarVendedor(id, username, vendedor);
        if (si) loginService.setUsuarios(obtenerDiccionarioVendedoresUser());
        return si;
    }

    @Override
    public boolean eliminarVendedor(Vendedor vendedor) {
        boolean si = redSocial.eliminarVendedor(vendedor.getId());;
        if (si) loginService.setUsuarios(obtenerDiccionarioVendedoresUser());
        return si;
    }

    @Override
    public List<Usuario> getUsuarios() {
        return redSocial.getListaUsuarios();
    }

    @Override
    public String cantProductosFechas(LocalDate d1, LocalDate d2) {
        return redSocial.cantProductosFechas(d1, d2);
    }

    @Override
    public boolean agregarProducto(Producto producto, Vendedor vendedor) {
        return redSocial.agregarProducto(producto, vendedor);
    }

    @Override
    public String generarIdProducto() {
        return Integer.toString(redSocial.getListaProductos().size()+1);
    }

    @Override
    public List<Producto> getProductos() {
        return redSocial.getListaProductos();
    }

    @Override
    public boolean actualizarProducto(Producto productoSeleccionado, Producto productoField) {
        return redSocial.actualizarProducto(productoSeleccionado, productoField);
    }

    @Override
    public boolean addLike(Producto productoSeleccionadoPublicado, Vendedor vendedor) {
        return redSocial.addLikeProducto(productoSeleccionadoPublicado, vendedor);
    }

    @Override
    public boolean  removeLike(Producto productoSeleccionadoPublicado, Vendedor vendedor) {
        return redSocial.removeLikeProducto(productoSeleccionadoPublicado, vendedor);
    }

    @Override
    public int getLikesProducto(Producto productoSeleccionadoPublicado) {
        return redSocial.getLikesProducto(productoSeleccionadoPublicado);
    }

    @Override
    public List<String> getComentariosProducto(Producto productoSeleccionadoPublicado) {
        return redSocial.getComentariosProducto(productoSeleccionadoPublicado);
    }

    @Override
    public List<Producto> getProductosPublicados() {
        return redSocial.getProductosPublicados();
    }

    @Override
    public void agregarComentarioProducto(Producto productoSeleccionadoPublicado, String text) {
        redSocial.agregarComentarioProducto(productoSeleccionadoPublicado, text);
    }

    @Override
    public boolean usuarioDioLike(Producto productoSeleccionadoPublicado, Vendedor vendedorAsociado) {
        return redSocial.usuarioDioLike(productoSeleccionadoPublicado, vendedorAsociado);
    }

    @Override
    public List<Producto> getProductosVendedor(Vendedor vendedor) {
        return redSocial.getProductosVendedor(vendedor);
    }


}
