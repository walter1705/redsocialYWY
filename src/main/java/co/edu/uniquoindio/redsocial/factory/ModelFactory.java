package co.edu.uniquoindio.redsocial.factory;


import co.edu.uniquoindio.redsocial.model.*;
import co.edu.uniquoindio.redsocial.service.IModelFactoryService;
import co.edu.uniquoindio.redsocial.utils.DataUtil;

import java.time.LocalDate;
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
    public boolean agregarProducto(Producto producto) {
        return redSocial.agregarProducto(producto);
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
    public void addLike(Producto productoSeleccionadoPublicado) {
        redSocial.addLikeProducto(productoSeleccionadoPublicado);
    }

    @Override
    public void removeLike(Producto productoSeleccionadoPublicado) {
        redSocial.removeLikeProducto(productoSeleccionadoPublicado);
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


}
