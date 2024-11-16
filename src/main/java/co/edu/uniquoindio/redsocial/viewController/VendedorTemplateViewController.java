package co.edu.uniquoindio.redsocial.viewController;

import java.io.File;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import co.edu.uniquoindio.redsocial.controller.VendedorTemplateController;
import co.edu.uniquoindio.redsocial.model.EstadoProducto;
import co.edu.uniquoindio.redsocial.model.Producto;
import co.edu.uniquoindio.redsocial.model.Vendedor;
import co.edu.uniquoindio.redsocial.model.builder.ProductoBuilder;
import co.edu.uniquoindio.redsocial.viewController.viewControllerHelpers.ViewControllerUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import static co.edu.uniquoindio.redsocial.utils.RedSocialConstants.*;

public class VendedorTemplateViewController {
    VendedorTemplateController vendedorTemplateController = new VendedorTemplateController();
    ObservableList<Producto> listaProductos = FXCollections.observableArrayList();
    public Vendedor vendedorAsociado;
    Producto productoSeleccionado;
    private String pathUsuarioImagenProducto;

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
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Seleccionar Imagen");

        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Imágenes", "*.jpg", "*.jpeg", "*.png", "*.gif"),
                new FileChooser.ExtensionFilter("Todos los Archivos", "*.*")
        );

        File selectedFile = fileChooser.showOpenDialog(new Stage()); // Usa tu Stage si es diferente
        if (selectedFile != null) {
            pathUsuarioImagenProducto = selectedFile.getAbsolutePath(); // Guardar el path
            System.out.println("Imagen seleccionada: " + pathUsuarioImagenProducto);

            Image image = new Image(selectedFile.toURI().toString());
            ImageViewProductCrud.setImage(image);
        } else {
            ViewControllerUtil.mostrarMensaje(TITULO_CAMPOS_INCOMPLETOS, HEADER, BODY_PATH_PRODUCTO_NOT_SELECTED, Alert.AlertType.WARNING);
        }
    }

    @FXML
    void onActualizarProducto(ActionEvent event) {

    }

    @FXML
    void onCrearProducto(ActionEvent event) {
        if (datosTxtProducto()) {
            Producto producto = crearProducto();
            boolean productoAgregado = vendedorTemplateController.agregarProducto(producto);
            if (productoAgregado) {
                listaProductos.add(producto);
                limpiarCampos();
                refrescarTabla();
                ViewControllerUtil.mostrarMensaje(TITULO_PRODUCTO_AGREGADO, HEADER, BODY_PRODUCTO_AGREGADO, Alert.AlertType.INFORMATION);
            } else {
                ViewControllerUtil.mostrarMensaje(TITULO_PRODUCTO_NO_CREADO, HEADER, BODY_PRODUCTO_NO_CREADO, Alert.AlertType.ERROR);
            }
        }
    }

    private void limpiarCampos() {
        txtDescripcionProducto.setText("");
        txtPrecioProducto.setText("");
        txtNombreProducto.setText("");
        txtCategoriaProducto.setText("");
        pathUsuarioImagenProducto = null;
        comboBoxEstado.setValue(null);

    }

    private void refrescarTabla() {
        tableViewListaContactos.refresh();
    }


    private boolean datosTxtProducto() {
        return txtDescripcionProducto.getText()!=null
                && txtDescripcionProducto.getText()!=null
                && txtPrecioProducto.getText()!=null
                && esDouble(txtPrecioProducto.getText())
                && txtCategoriaProducto.getText()!=null
                && txtNombreProducto.getText()!=null
                && comboBoxEstado.getValue()!=null
                && pathUsuarioImagenProducto!=null;
    }

    private boolean esDouble(String text) {
        String patron = "^-?\\d+(\\.\\d+)?$";
        if (!text.matches(patron)) {
            ViewControllerUtil.mostrarMensaje(TITULO_SOLO_NUMEROS, HEADER, BODY_SOLO_NUMEROS, Alert.AlertType.WARNING);
            return false;
        }

        return true;
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
                .imagen(pathUsuarioImagenProducto)
                .vendedorAsociado(vendedorAsociado)
                .build();
    }

    private String generarIdProducto() {
        return vendedorTemplateController.generarIdProducto();
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
        listaProductos.clear();
        tableViewPublicados.setItems(listaProductos);
        //cargarProductos(); TODO
    }


}
