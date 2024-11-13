package co.edu.uniquoindio.redsocial.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquoindio.redsocial.model.EstadoProducto;
import co.edu.uniquoindio.redsocial.model.Producto;
import co.edu.uniquoindio.redsocial.model.Vendedor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class VendedorTemplateViewController {

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

    @FXML
    void onBttnLike(ActionEvent event) {

    }

    @FXML
    void onImagenProductoPath(ActionEvent event) {

    }

    @FXML
    void onActualizarProducto(ActionEvent event) {

    }

    @FXML
    void onCrearProducto(ActionEvent event) {

    }

    @FXML
    void onEliminarProducto(ActionEvent event) {

    }

    @FXML
    void initialize() {
        comboBoxEstado.getItems().addAll(EstadoProducto.values());



        assert ImageViewProductCrud != null : "fx:id=\"ImageViewProductCrud\" was not injected: check your FXML file 'VendedorTemplate.fxml'.";
        assert bttnActualizarProducto != null : "fx:id=\"bttnActualizarProducto\" was not injected: check your FXML file 'VendedorTemplate.fxml'.";
        assert bttnCrearProducto != null : "fx:id=\"bttnCrearProducto\" was not injected: check your FXML file 'VendedorTemplate.fxml'.";
        assert bttnEliminarProducto != null : "fx:id=\"bttnEliminarProducto\" was not injected: check your FXML file 'VendedorTemplate.fxml'.";
        assert bttnImagenProductoCrud != null : "fx:id=\"bttnImagenProductoCrud\" was not injected: check your FXML file 'VendedorTemplate.fxml'.";
        assert bttnLike != null : "fx:id=\"bttnLike\" was not injected: check your FXML file 'VendedorTemplate.fxml'.";
        assert comboBoxEstado != null : "fx:id=\"comboBoxEstado\" was not injected: check your FXML file 'VendedorTemplate.fxml'.";
        assert imageViewListProductos != null : "fx:id=\"imageViewListProductos\" was not injected: check your FXML file 'VendedorTemplate.fxml'.";
        assert likeCounter != null : "fx:id=\"likeCounter\" was not injected: check your FXML file 'VendedorTemplate.fxml'.";
        assert tableViewListaContactos != null : "fx:id=\"tableViewListaContactos\" was not injected: check your FXML file 'VendedorTemplate.fxml'.";
        assert tcCategoriaProductoPro != null : "fx:id=\"tcCategoriaProductoPro\" was not injected: check your FXML file 'VendedorTemplate.fxml'.";
        assert tcDescripcionProductoPro != null : "fx:id=\"tcDescripcionProductoPro\" was not injected: check your FXML file 'VendedorTemplate.fxml'.";
        assert tcEstadoProductoPro != null : "fx:id=\"tcEstadoProductoPro\" was not injected: check your FXML file 'VendedorTemplate.fxml'.";
        assert tcNombreProductoPro != null : "fx:id=\"tcNombreProductoPro\" was not injected: check your FXML file 'VendedorTemplate.fxml'.";
        assert tcPrecioProductoPro != null : "fx:id=\"tcPrecioProductoPro\" was not injected: check your FXML file 'VendedorTemplate.fxml'.";
        assert tcProductCategoriaMuro != null : "fx:id=\"tcProductCategoriaMuro\" was not injected: check your FXML file 'VendedorTemplate.fxml'.";
        assert tcProductDescripcionMuro != null : "fx:id=\"tcProductDescripcionMuro\" was not injected: check your FXML file 'VendedorTemplate.fxml'.";
        assert tcProductNombreMuro != null : "fx:id=\"tcProductNombreMuro\" was not injected: check your FXML file 'VendedorTemplate.fxml'.";
        assert tcProductPrecioMuro != null : "fx:id=\"tcProductPrecioMuro\" was not injected: check your FXML file 'VendedorTemplate.fxml'.";
        assert txtCategoriaProducto != null : "fx:id=\"txtCategoriaProducto\" was not injected: check your FXML file 'VendedorTemplate.fxml'.";
        assert txtDescripcionProducto != null : "fx:id=\"txtDescripcionProducto\" was not injected: check your FXML file 'VendedorTemplate.fxml'.";
        assert txtNombreProducto != null : "fx:id=\"txtNombreProducto\" was not injected: check your FXML file 'VendedorTemplate.fxml'.";
        assert txtPrecioProducto != null : "fx:id=\"txtPrecioProducto\" was not injected: check your FXML file 'VendedorTemplate.fxml'.";

    }

    public AnchorPane getView() {
        return rootPane;
    }

    public void updateView() {
    }
}
