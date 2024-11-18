package co.edu.uniquoindio.redsocial.factory;


import co.edu.uniquoindio.redsocial.model.*;
import co.edu.uniquoindio.redsocial.proxy.LoginProxy;
import co.edu.uniquoindio.redsocial.proxy.LoginService;
import co.edu.uniquoindio.redsocial.service.ILoginService;
import co.edu.uniquoindio.redsocial.service.IModelFactoryService;
import co.edu.uniquoindio.redsocial.utils.DataUtil;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class ModelFactory implements IModelFactoryService {
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

    public Map<String, String> obtenerDiccionarioVendedoresUser() {
        return redSocial.obtenerDiccionarioVendedoresUser();
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
    public boolean actualizarVendedor(String id, String username, Vendedor vendedor) {
        return redSocial.actualizarVendedor(id, username, vendedor);
    }

    @Override
    public boolean eliminarVendedor(Vendedor vendedor) {
        return redSocial.eliminarVendedor(vendedor.getId());
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
