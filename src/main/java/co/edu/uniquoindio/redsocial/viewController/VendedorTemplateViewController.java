package co.edu.uniquoindio.redsocial.viewController;

import java.io.File;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import co.edu.uniquoindio.redsocial.controller.VendedorTemplateController;
import co.edu.uniquoindio.redsocial.model.*;
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

import static co.edu.uniquoindio.redsocial.utils.RedSocialConstants.*;

public class VendedorTemplateViewController {
    RedsocialAppViewController redsocialAppViewController = RedsocialAppViewController.getController();
    VendedorTemplateController vendedorTemplateController = new VendedorTemplateController();
    public Vendedor vendedorAsociado;
    ObservableList<Producto> listaProductos = FXCollections.observableArrayList();
    Producto productoSeleccionado, productoSeleccionadoPublicado;
    private String pathUsuarioImagenProducto;
    ObservableList<String> listaMensajes = FXCollections.observableArrayList();


    public void setVendedorAsociado(Vendedor vendedorAsociado) {
        this.vendedorAsociado = vendedorAsociado;
    }

    @FXML
    private AnchorPane rootPane;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView ImageViewProductCrud;

    @FXML
    private Button bttnEnviarMensaje;

    @FXML
    private Button bttnActualizarProducto;

    @FXML
    private Button bttnCrearProducto;

    @FXML
    private Button bttnEliminarProducto;

    @FXML
    private Button bttnImagenProductoCrud;

    @FXML
    private Button bttnEnviarMensajePriv;

    @FXML
    private ToggleButton bttnLike;

    @FXML
    private ComboBox<EstadoProducto> comboBoxEstado;

    @FXML
    private ImageView imageViewListProductos;

    @FXML
    private Label likeCounter;

    @FXML
    private ListView<String> listViewMensajes;

    @FXML
    private ListView<?> listViewMensajesContactos;


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
    private TableColumn<Producto, String> tcVenededorProducto;

    @FXML
    private TextField txtCategoriaProducto;

    @FXML
    private TextField txtDescripcionProducto;

    @FXML
    private TextField txtNombreProducto;

    @FXML
    private TextField txtPrecioProducto;

    @FXML
    private TextField txtMensajesTo;

    @FXML
    private TextArea txtMensajesContactos;

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
                    limpiarCampos();
                    redsocialAppViewController.actualizarProductosMuro(productoField);
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
            boolean productoAgregado = vendedorTemplateController.agregarProducto(producto, vendedorAsociado);
            if (productoAgregado) {
                listaProductos.add(producto);
                redsocialAppViewController.actualizarProductosMuro(producto);
                limpiarCampos();
                refrescarTablas();
                ViewControllerUtil.mostrarMensaje(TITULO_PRODUCTO_AGREGADO, HEADER, BODY_PRODUCTO_AGREGADO, Alert.AlertType.INFORMATION);
            } else {
                ViewControllerUtil.mostrarMensaje(TITULO_PRODUCTO_NO_CREADO, HEADER, BODY_PRODUCTO_NO_CREADO, Alert.AlertType.ERROR);
            }
        }
    }

    @FXML
    void onEliminarProducto(ActionEvent event) {

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



    //interacciones red social
    @FXML
    void onBttnLike(ActionEvent event) {
        if (productoSeleccionadoPublicado != null) {
            boolean usuarioYaLeDioLike = vendedorTemplateController.usuarioDioLike(productoSeleccionadoPublicado, vendedorAsociado);
            if (bttnLike.isSelected()) {
                if (!usuarioYaLeDioLike) {
                    vendedorTemplateController.addLike(productoSeleccionadoPublicado, vendedorAsociado);
                    bttnLike.setText("Liked");
                }
            } else {
                if (usuarioYaLeDioLike) {
                    vendedorTemplateController.removeLike(productoSeleccionadoPublicado, vendedorAsociado);
                    bttnLike.setText("Like");
                }
            }
            RedsocialAppViewController.getProductosPublicados().set(
                    RedsocialAppViewController.getProductosPublicados().indexOf(productoSeleccionadoPublicado),
                    productoSeleccionadoPublicado
            );
            likeCounter.setText(String.valueOf(vendedorTemplateController.getLikes(productoSeleccionadoPublicado)));
        } else {
            bttnLike.setSelected(false);
            ViewControllerUtil.mostrarMensaje(ERROR, HEADER, BODY_SELECCIONA_PRODUCTO_ANTES_QUE_LIKE, Alert.AlertType.WARNING);
        }
    }

    @FXML
    void onEnviarMensaje(ActionEvent event) {
        if (productoSeleccionadoPublicado!=null) {
            if (txtMensajesTo.getText() != null) {
                String mensaje = vendedorTemplateController.getUsuarioOnSession().getUsuarioAsociado().getUsername()
                        +": "+txtMensajesTo.getText();
                vendedorTemplateController.agregarComentarioProducto(productoSeleccionadoPublicado, mensaje);
                listaMensajes.add(mensaje);
                txtMensajesTo.setText(null);
            } else {
                txtMensajesTo.setText(null);
                ViewControllerUtil.mostrarMensaje(TITULO_MENSAJE_VACIO, HEADER, BODY_MENSAJE_VACIO, Alert.AlertType.WARNING);
            }
        } else {
            ViewControllerUtil.mostrarMensaje(TITULO_CAMPOS_INCOMPLETOS, HEADER, BODY_SELECCIONAR_PRODUCTO, Alert.AlertType.WARNING);
        }
    }

    @FXML
    void onEnviarMensajePriv(ActionEvent event) {
        //TODO
    }


    private void configurarPermisos() {
        Persona persona = vendedorTemplateController.getUsuarioOnSession();
        if (persona != null) {
            if (persona instanceof Administrador) {
                habilitarTodosLosControles();
            } else if (persona instanceof Vendedor) {
                Vendedor vendedorEnSesion = (Vendedor) persona;
                if (vendedorAsociado != null && vendedorAsociado.equals(vendedorEnSesion)) {
                    habilitarTodosLosControles();
                } else {
                    limitarAccesoOtrosVendedores();
                }
            } 
        } else {
            deshabilitarTodosLosControles();
        }
    }

    private void limitarAccesoOtrosVendedores() {
        bttnActualizarProducto.setDisable(true);
        bttnCrearProducto.setDisable(true);
        bttnEliminarProducto.setDisable(true);
        bttnImagenProductoCrud.setDisable(true);
        bttnEnviarMensajePriv.setDisable(true);
        comboBoxEstado.setDisable(true);
        txtDescripcionProducto.setDisable(true);
        txtPrecioProducto.setDisable(true);
        txtNombreProducto.setDisable(true);
        txtCategoriaProducto.setDisable(true);
        txtMensajesContactos.setDisable(true);
        tableViewProductosCRUD.setDisable(true);
    }

    private void habilitarTodosLosControles() {
        bttnEnviarMensaje.setDisable(false);
        bttnActualizarProducto.setDisable(false);
        bttnCrearProducto.setDisable(false);
        bttnEliminarProducto.setDisable(false);
        bttnImagenProductoCrud.setDisable(false);
        bttnEnviarMensajePriv.setDisable(false);
        bttnLike.setDisable(false);
        comboBoxEstado.setDisable(false);
        txtDescripcionProducto.setDisable(false);
        txtPrecioProducto.setDisable(false);
        txtNombreProducto.setDisable(false);
        txtCategoriaProducto.setDisable(false);
        txtMensajesTo.setDisable(false);
        txtMensajesContactos.setDisable(false);
        tableViewProductosCRUD.setDisable(false);
        tableViewPublicados.setDisable(false);
        tableViewListaContactos.setDisable(false);
    }

    private void deshabilitarTodosLosControles() {
        bttnEliminarProducto.setDisable(true);
    }

    public void updateView() {
        listaProductos.addAll(vendedorTemplateController.getProductosVendedor(vendedorAsociado));
    }


    @FXML
    void initialize() {
        comboBoxEstado.getItems().addAll(EstadoProducto.values());
        tableViewProductosCRUD.setItems(listaProductos);
        tableViewPublicados.setItems(RedsocialAppViewController.getProductosPublicados());
        listViewMensajes.setItems(listaMensajes);
        initView();
        cargarMensajesMuro();
        configurarPermisos();
    }

    private void cargarMensajesMuro() {
        //listaMensajes.ge;
    }

    private void initView() {
        initDataBinding();
        obtenerProductos();
        listenerSelection();
    }

    private void listenerSelection() {
        tableViewProductosCRUD.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            productoSeleccionado = newSelection;
            if (productoSeleccionado != null) {
                mostrarInformacionProducto(productoSeleccionado);
            }
        });

        tableViewPublicados.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            productoSeleccionadoPublicado = newSelection;
            if (productoSeleccionadoPublicado != null) {
                mostrarInformacionProductoMuro(productoSeleccionadoPublicado);
            }
        });
    }
    //MURO
    private void mostrarInformacionProductoMuro(Producto productoSeleccionadoPublicado) {
        if (productoSeleccionadoPublicado != null) {
            likeCounter.setText(String.valueOf(vendedorTemplateController.getLikes(productoSeleccionadoPublicado)));
            String validPath = "file:" + productoSeleccionadoPublicado.getImagen().replace("\\", "/");
            imageViewListProductos.setImage(new Image(validPath));
            listaMensajes.setAll(vendedorTemplateController.getComentariosProducto(productoSeleccionadoPublicado));
        }
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
        tcVenededorProducto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getVendedorAsociado().getUsuarioAsociado().getUsername()));
        tcProductDescripcionMuro.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDescripcion()));
        tcProductCategoriaMuro.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCategoria()));
        tcProductPrecioMuro.setCellValueFactory(cellData -> new SimpleStringProperty(Double.toString(cellData.getValue().getPrecio())));
        //TABLE CONTACTOS
        tcViewListaContactos.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getNombre()
                +" "+cellData.getValue().getApellido()));
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

    private boolean esDouble(String text) {
        String patron = "^-?\\d+(\\.\\d+)?$";
        if (!text.matches(patron)) {
            ViewControllerUtil.mostrarMensaje(TITULO_SOLO_NUMEROS, HEADER, BODY_SOLO_NUMEROS, Alert.AlertType.WARNING);
            return false;
        }

        return true;
    }

    private void obtenerProductos() {
    }

    public AnchorPane getView() {
        return rootPane;
    }

    private Publicacion crearPublicacion() {
        return new Publicacion();
    }

    private String generarIdProducto() {
        return vendedorTemplateController.generarIdProducto();
    }

    public void onShow() {
        configurarPermisos();
    }
}
