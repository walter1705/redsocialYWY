package co.edu.uniquoindio.redsocial.viewController;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import co.edu.uniquoindio.redsocial.controller.VendedorTemplateController;
import co.edu.uniquoindio.redsocial.model.EstadoProducto;
import co.edu.uniquoindio.redsocial.model.Producto;
import co.edu.uniquoindio.redsocial.model.Vendedor;
import co.edu.uniquoindio.redsocial.model.builder.ProductoBuilder;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class VendedorTemplateViewController {
    VendedorTemplateController vendedorTemplateController = new VendedorTemplateController();
    Producto productoSeleccionado;


    @FXML
    private AnchorPane rootPane;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView ImageViewProductCrud;

    @FXML
    private Button bttnActualizarProducto;

    @FXML
    private Button bttnCrearProducto;

    @FXML
    private Button bttnEliminarProducto;

    @FXML
    private Button bttnImagenProductoCrud;

    @FXML
    private ToggleButton bttnLike;

    @FXML
    private ComboBox<EstadoProducto> comboBoxEstado;

    @FXML
    private ImageView imageViewListProductos;

    @FXML
    private Label likeCounter;

    @FXML
    private TableView<Vendedor> tableViewListaContactos;

    @FXML
    private TableView<Producto> tableViewPublicados;

    @FXML
    private TableColumn<Vendedor, String> tcViewListaContactos;

    @FXML
    private TableColumn<Vendedor, String> tcCategoriaProductoPro;

    @FXML
    private TableColumn<Vendedor, String> tcDescripcionProductoPro;

    @FXML
    private TableColumn<Vendedor, String> tcEstadoProductoPro;

    @FXML
    private TableColumn<Vendedor, String> tcNombreProductoPro;

    @FXML
    private TableColumn<Vendedor, String> tcPrecioProductoPro;

    @FXML
    private TableColumn<Vendedor, String> tcProductCategoriaMuro;

    @FXML
    private TableColumn<Vendedor, String> tcProductDescripcionMuro;

    @FXML
    private TableColumn<Vendedor, String> tcProductNombreMuro;

    @FXML
    private TableColumn<Vendedor, String> tcProductPrecioMuro;

    @FXML
    private TextField txtCategoriaProducto;

    @FXML
    private TextField txtDescripcionProducto;

    @FXML
    private TextField txtNombreProducto;

    @FXML
    private TextField txtPrecioProducto;
    //CRUD
    @FXML
    void onImagenProductoPath(ActionEvent event) {

    }

    @FXML
    void onActualizarProducto(ActionEvent event) {

    }

    @FXML
    void onCrearProducto(ActionEvent event) {
        Producto producto = crearProducto();
        if (datosTxtProducto()) {
            boolean productoAgregado = vendedorTemplateController.agregarProducto(producto);
            if (productoAgregado) {}
        }
    }


    private boolean datosTxtProducto() {
        return txtDescripcionProducto.getText()!=null
                && txtDescripcionProducto.getText()!=null
                && txtPrecioProducto.getText()!=null //TODO
                && txtCategoriaProducto.getText()!=null
                && txtNombreProducto.getText()!=null
                && comboBoxEstado.getValue()!=null;
                //TODO IMAGEN;
    }

    private Producto crearProducto() {
        return Producto.builder()
                .descripcion(txtDescripcionProducto.getText())
                .id(generarIdProducto())
                .estadoProducto(comboBoxEstado.getValue())
                .fechaPublicacion(LocalDate.now())
                .categoria(txtCategoriaProducto.getText())
                .nombre(txtNombreProducto.getText())
                .precio(Integer.parseInt(txtPrecioProducto.getText()))
                .build();
    }

    private String generarIdProducto() {
        return ""; //TODO
    }

    @FXML
    void onEliminarProducto(ActionEvent event) {

    }

    //interacciones red social
    @FXML
    void onBttnLike(ActionEvent event) {

    }
    public AnchorPane getView() {
        return rootPane;
    }

    public void updateView() {
    }


    @FXML
    void initialize() {
        comboBoxEstado.getItems().addAll(EstadoProducto.values());
    }


}
