package co.edu.uniquoindio.redsocial.viewController;

import java.io.File;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import co.edu.uniquoindio.redsocial.controller.VendedorTemplateController;
import co.edu.uniquoindio.redsocial.model.EstadoProducto;
import co.edu.uniquoindio.redsocial.model.Producto;
import co.edu.uniquoindio.redsocial.model.Publicacion;
import co.edu.uniquoindio.redsocial.model.Vendedor;
import co.edu.uniquoindio.redsocial.viewController.viewControllerHelpers.ViewControllerUtil;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.text.View;

import static co.edu.uniquoindio.redsocial.utils.RedSocialConstants.*;

public class VendedorTemplateViewController {
    VendedorTemplateController vendedorTemplateController = new VendedorTemplateController();
    ObservableList<Producto> listaProductos = FXCollections.observableArrayList();
    ObservableList<Producto> listaProductosPublicados = FXCollections.observableArrayList();
    public Vendedor vendedorAsociado;
    Producto productoSeleccionado, productoSeleccionadoPublicado;
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
    private TableView<Producto> tableViewProductosCRUD;


    @FXML
    private TableColumn<Vendedor, String> tcViewListaContactos;

    @FXML
    private TableColumn<Producto, String> tcCategoriaProductoPro;

    @FXML
    private TableColumn<Producto, String> tcDescripcionProductoPro;

    @FXML
    private TableColumn<Producto, String> tcEstadoProductoPro;

    @FXML
    private TableColumn<Producto, String> tcNombreProductoPro;

    @FXML
    private TableColumn<Producto, String> tcPrecioProductoPro;

    @FXML
    private TableColumn<Producto, String> tcProductCategoriaMuro;

    @FXML
    private TableColumn<Producto, String> tcProductDescripcionMuro;

    @FXML
    private TableColumn<Producto, String> tcProductNombreMuro;

    @FXML
    private TableColumn<Producto, String> tcProductPrecioMuro;

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
        if (productoSeleccionado != null) {
            if (datosTxtProducto()) {
                Producto productoField = crearProducto();
                boolean productoActualizado = vendedorTemplateController.actualizarProducto(productoSeleccionado, productoField);
                if (productoActualizado) {
                    // TO DOactualizarProductoListObser TODO HACER ACTUALIZAR AQUI Y ACTUALIZAR TAB EN VENDEDORES
                    limpiarCampos();
                    actualizarProductosMuro();
                    refrescarTablas();
                    ViewControllerUtil.mostrarMensaje(TITULO_PRODUCTO_ACTUALIZADO, HEADER, BODY_PRODUCTO_ACTUALIZADO, Alert.AlertType.INFORMATION);
                } else {
                    ViewControllerUtil.mostrarMensaje(TITULO_PRODUCTO_NO_ACTUALIZADO, HEADER, BODY_PRODUCTO_NO_ACTUALIZADO, Alert.AlertType.ERROR);
                }
            } else {
                ViewControllerUtil.mostrarMensaje(TITULO_CAMPOS_INCOMPLETOS, HEADER, BODY_CAMPOS_INCOMPLETOS, Alert.AlertType.WARNING);
            }
        } else {
            ViewControllerUtil.mostrarMensaje(TITULO_CAMPOS_INCOMPLETOS, HEADER, BODY_PRODUCTO_NO_SELECCIONADO, Alert.AlertType.WARNING);
        }
    }

    @FXML
    void onCrearProducto(ActionEvent event) {
        if (datosTxtProducto()) {
            Producto producto = crearProducto();
            boolean productoAgregado = vendedorTemplateController.agregarProducto(producto);
            if (productoAgregado) {
                listaProductos.add(producto);
                actualizarProductosMuro();
                limpiarCampos();
                refrescarTablas();
                ViewControllerUtil.mostrarMensaje(TITULO_PRODUCTO_AGREGADO, HEADER, BODY_PRODUCTO_AGREGADO, Alert.AlertType.INFORMATION);
            } else {
                ViewControllerUtil.mostrarMensaje(TITULO_PRODUCTO_NO_CREADO, HEADER, BODY_PRODUCTO_NO_CREADO, Alert.AlertType.ERROR);
            }
        }
    }

    private void actualizarProductosMuro() {
        listaProductos.forEach(producto -> {
            if (producto.getEstadoProducto().equals(EstadoProducto.PUBLICADO)) listaProductosPublicados.add(producto);
        });
    }

    private void limpiarCampos() {
        txtDescripcionProducto.setText("");
        txtPrecioProducto.setText("");
        txtNombreProducto.setText("");
        txtCategoriaProducto.setText("");
        ImageViewProductCrud.setImage(null);
        pathUsuarioImagenProducto = null;
        comboBoxEstado.setValue(null);

    }

    private void refrescarTablas() {
        tableViewListaContactos.refresh();
        tableViewPublicados.refresh();
        tableViewProductosCRUD.refresh();
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
                .precio(Double.parseDouble(txtPrecioProducto.getText()))
                .imagen(pathUsuarioImagenProducto)
                .vendedorAsociado(vendedorAsociado)
                .publicacion(crearPublicacion())
                .build();
    }

    private Publicacion crearPublicacion() {
        return new Publicacion();
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
        tableViewProductosCRUD.setItems(listaProductos);
        tableViewPublicados.setItems(listaProductosPublicados);
        initView();
    }

    private void initView() {
        initDataBinding();
        obtenerProductos();
        listenerSelection();
        actualizarProductosMuro();
    }

    private void listenerSelection() {
        tableViewProductosCRUD.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            productoSeleccionado = newSelection;
            if (productoSeleccionado != null) {
                mostrarInformacionProducto(productoSeleccionado);
            }
        });
    }

    private void mostrarInformacionProducto(Producto producto) {
        if (productoSeleccionado != null) {
            txtPrecioProducto.setText(Double.toString(productoSeleccionado.getPrecio()));
            txtDescripcionProducto.setText(productoSeleccionado.getDescripcion());
            txtNombreProducto.setText(productoSeleccionado.getNombre());
            txtCategoriaProducto.setText(productoSeleccionado.getCategoria());
            comboBoxEstado.setValue(productoSeleccionado.getEstadoProducto());
            pathUsuarioImagenProducto = productoSeleccionado.getImagen();
            String validPath = "file:" + producto.getImagen().replace("\\", "/");
            ImageViewProductCrud.setImage(new Image(validPath));
        }
    }


    private void initDataBinding() {
        //TABLE LISTA PRODUCTOS CRUD
        tcNombreProductoPro.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tcCategoriaProductoPro.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCategoria()));
        tcDescripcionProductoPro.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDescripcion()));
        tcPrecioProductoPro.setCellValueFactory(cellData -> new SimpleStringProperty(Double.toString(cellData.getValue().getPrecio())));
        tcEstadoProductoPro.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEstadoProducto().name()));
        //TABLE PRODUCTOS PUBLICADOS
        tcProductNombreMuro.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tcProductDescripcionMuro.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDescripcion()));
        tcProductCategoriaMuro.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCategoria()));
        tcProductPrecioMuro.setCellValueFactory(cellData -> new SimpleStringProperty(Double.toString(cellData.getValue().getPrecio())));
        //TABLE CONTACTOS
        tcViewListaContactos.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getNombre()
                +" "+cellData.getValue().getApellido()));
    }

    private void obtenerProductos() {
        listaProductos.addAll(vendedorTemplateController.getProductos());
        actualizarProductosMuro();
    }


}
