package co.edu.uniquoindio.redsocial.viewController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquoindio.redsocial.model.Usuario;
import co.edu.uniquoindio.redsocial.model.Vendedor;
import co.edu.uniquoindio.redsocial.controller.VendedoresController;
import co.edu.uniquoindio.redsocial.model.builder.UsuarioBuilder;
import co.edu.uniquoindio.redsocial.model.builder.VendedorBuilder;
import co.edu.uniquoindio.redsocial.viewController.viewControllerHelpers.TabManagerVendedorTemplate;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import static co.edu.uniquoindio.redsocial.utils.RedSocialConstants.*;

public class VendedoresViewController {
    RedsocialAppViewController redSocialAppViewController;

    VendedoresController vendedoresController;
    ObservableList<Vendedor> listaVendedores;

    TabManagerVendedorTemplate tabManagerVendedorTemplate = TabManagerVendedorTemplate.getInstance();

    Vendedor vendedorSelecionado;

    private static VendedoresViewController vendedoresViewController;

    public VendedoresViewController() {
        vendedoresViewController = this;
        listaVendedores = FXCollections.observableArrayList();
    }

    public static VendedoresViewController getInstance() {
        if (vendedoresViewController == null) {
            vendedoresViewController = new VendedoresViewController();
        }
        return vendedoresViewController;
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnNuevo;

    @FXML
    private TableView<Vendedor> tableVendedor;

    @FXML
    private TableColumn<Vendedor, String> tcApellidoVendedor;

    @FXML
    private TableColumn<Vendedor, String> tcContrasenaUsuario;

    @FXML
    private TableColumn<Vendedor, String> tcEmailVendedor;

    @FXML
    private TableColumn<Vendedor, String> tcIdVendedor;

    @FXML
    private TableColumn<Vendedor, String> tcDireccionvendedor;

    @FXML
    private TableColumn<Vendedor, String> tcNombreUsuario;

    @FXML
    private TableColumn<Vendedor, String> tcNombreVendedor;

    @FXML
    private TextField txtApellidoVendedor;

    @FXML
    private TextField txtContrasenaUsuario;

    @FXML
    private TextField txtEmailVendedor;

    @FXML
    private TextField txtNombreUsuario;

    @FXML
    private TextField txtNombreVendedor;

    @FXML
    private TextField txtIdVendedor;

    @FXML
    private TextField txtDireccionVendedor;

    @FXML
    void initialize() {
        vendedoresController = new VendedoresController();
        tabManagerVendedorTemplate = TabManagerVendedorTemplate.getInstance();

        redSocialAppViewController = RedsocialAppViewController.getController();

        initView();
        loadViewsAfterLogin();
    }

    public void loadViewsAfterLogin() {

        for (Tab tab : tabManagerVendedorTemplate.getTabs()) {
            if (!redSocialAppViewController.TabPane.getTabs().contains(tab)) {
                redSocialAppViewController.TabPane.getTabs().add(tab);
            }
        }

    }



    private void initView() {
        initDataBinding();
        obtenerVendedores();
        tableVendedor.getItems().clear();
        tableVendedor.setItems(listaVendedores);
        listenerSelection();
    }

    private void obtenerVendedores() {
        listaVendedores.addAll(vendedoresController.obtenerVendedores());
    }

    private void listenerSelection() {
        tableVendedor.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            vendedorSelecionado = newSelection;
            if (vendedorSelecionado != null) {
                mostrarInformacionVendedor(vendedorSelecionado);
            }
        });
    }

    private void mostrarInformacionVendedor(Vendedor vendedorSelecionado) {
        if (vendedorSelecionado != null) {
            txtNombreVendedor.setText(vendedorSelecionado.getNombre());
            txtApellidoVendedor.setText(vendedorSelecionado.getApellido());
            txtEmailVendedor.setText(vendedorSelecionado.getEmail());
            txtIdVendedor.setText(vendedorSelecionado.getId());
            txtDireccionVendedor.setText(vendedorSelecionado.getDireccion());
            txtNombreUsuario.setText(vendedorSelecionado.getUsuarioAsociado().getUsername());
            txtContrasenaUsuario.setText(vendedorSelecionado.getUsuarioAsociado().getPassword());
        }
    }

    private void agregarVendedor() {
        Vendedor vendedor = crearVendedor();
        if (listaVendedores.size()<10) {
            if (datosValidosUsuario(vendedor) && datosValidosVendedor(vendedor)) {
                boolean vendedorAgregado = vendedoresController.agregarVendedor(vendedor);
                if (vendedorAgregado) {
                    listaVendedores.add(vendedor);
                    limpiarCampos();
                    refrescarTabla();
                    agregarTabVendedor(vendedor);
                    mostrarMensaje(TITULO_USUVENDEDOR_AGREGADO, HEADER, BODY_USUVENDEDOR_AGREGADO, Alert.AlertType.INFORMATION);
                } else {
                    mostrarMensaje(TITULO_USUVENDEDOR_NO_AGREGADO, HEADER, BODY_USUVENDEDOR_NO_AGREGADO, Alert.AlertType.ERROR);
                }
            } else {
                mostrarMensaje(TITULO_CAMPOS_INCOMPLETOS, HEADER, BODY_CAMPOS_INCOMPLETOS, Alert.AlertType.INFORMATION);
            }
        } else {
            mostrarMensaje(TITULO_LIMITE_VENDEDORES, HEADER, BODY_LIMITE_VENDEDORES, Alert.AlertType.INFORMATION);
        }
    }

    private void agregarTabVendedor(Vendedor vendedor) {
        try {
            if (tabManagerVendedorTemplate.hasTab(vendedor)) {
                Tab tabExistente = tabManagerVendedorTemplate.getTab(vendedor);
                redSocialAppViewController.mainTab.getTabPane().getTabs().add(tabExistente);
            } else {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquoindio/redsocial/VendedorTemplate.fxml"));
                AnchorPane vendedorContent = loader.load();

                VendedorTemplateViewController vendedorController = loader.getController();
                vendedorController.updateView();

                Tab nuevoTab = new Tab(vendedor.getNombre(), vendedorContent);
                redSocialAppViewController.mainTab.getTabPane().getTabs().add(nuevoTab);

                tabManagerVendedorTemplate.agregarTab(vendedor, nuevoTab);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al cargar la vista de Vendedor.");
        }
    }

    private void actualizarVendedor() {
        Vendedor vendedor = crearVendedor();
        if(vendedorSelecionado!=null) {
        if (datosValidosVendedor(vendedor) && datosValidosUsuario(vendedor)) {
            boolean vendedorActualizado = vendedoresController.actualizarVendedor(vendedorSelecionado.getId(),
                    vendedorSelecionado.getUsuarioAsociado().getUsername() ,vendedor);
            if (vendedorActualizado) {
                actualizarVendedorListaObserver(vendedor);
                limpiarCampos();
                refrescarTabla();
                mostrarMensaje(TITULO_USUVENDEDOR_ACTUALIZADO, HEADER, BODY_USUVENDEDOR_ACTUALIZADO, Alert.AlertType.INFORMATION);
            } else {
                mostrarMensaje(TITULO_USUVENDEDOR_NO_ACTUALIZADO, HEADER, BODY_USUVENDEDOR_NO_ACTUALIZADO, Alert.AlertType.ERROR);
                mostrarMensaje(TITULO_USUVENDEDOR_NO_ACTUALIZADO, HEADER, BODY_USUVENDEDOR_NO_ACTUALIZADO, Alert.AlertType.ERROR);
            }
        } else {
            mostrarMensaje(TITULO_CAMPOS_NO_SELECIONADO, HEADER, BODY_CAMPOS_NO_SELECIONADO, Alert.AlertType.INFORMATION);
        }} else {
            mostrarMensaje(TITULOVENDEDOR_NO_SELECCIONADO, HEADER, BODYVENDEDOR_NO_SELECCIONADO, Alert.AlertType.ERROR);
        }
    }

    private void actualizarVendedorListaObserver(Vendedor vendedor) {
        for (int i = 0; i < listaVendedores.size(); i++) {
            if (listaVendedores.get(i).getId().equals(vendedorSelecionado.getId()) ||
                    listaVendedores.get(i).getUsuarioAsociado().getUsername()
                            .equals(vendedorSelecionado.getUsuarioAsociado().getUsername()) &&
                            !listaVendedores.get(i).getId().isBlank() &&
                            !listaVendedores.get(i).getUsuarioAsociado().getUsername().isBlank()) {
                listaVendedores.set(i, vendedor);
                break;
            }
        }
    }

    private boolean datosValidosVendedor(Vendedor vendedor) {
        return !vendedor.getNombre().isBlank() &&
                !vendedor.getApellido().isBlank() &&
                !vendedor.getId().isBlank() &&
                !vendedor.getEmail().isBlank() &&
                !vendedor.getDireccion().isBlank();
    }


    private boolean datosValidosUsuario(Vendedor vendedor) {
        return !vendedor.getUsuarioAsociado().getUsername().isBlank()
                && !vendedor.getUsuarioAsociado().getPassword().isBlank();
    }

    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {
        Alert aler = new Alert(alertType);
        aler.setTitle(titulo);
        aler.setHeaderText(header);
        aler.setContentText(contenido);
        aler.showAndWait();
    }

    private Vendedor crearVendedor() {
        Vendedor vendedor = new VendedorBuilder()
                .nombre(txtNombreUsuario.getText())
                .apellido(txtApellidoVendedor.getText())
                .email(txtEmailVendedor.getText())
                .id(txtIdVendedor.getText())
                .direccion(txtDireccionVendedor.getText())
                .build();
        Usuario usuario = new UsuarioBuilder()
                .username(txtNombreUsuario.getText())
                .password(txtContrasenaUsuario.getText())
                .build();
        vendedor.setUsuarioAsociado(usuario);
        usuario.setVendedorAsociado(vendedor);
        return vendedor;
    }


    private void initDataBinding() {
        tcNombreVendedor.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tcApellidoVendedor.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApellido()));
        tcEmailVendedor.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmail()));
        tcIdVendedor.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId()));
        tcDireccionvendedor.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDireccion()));
        tcNombreUsuario.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getUsuarioAsociado().getUsername()));
        tcContrasenaUsuario.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getUsuarioAsociado().getPassword()));
    }


    @FXML
    void onActualizar(ActionEvent event) {
        actualizarVendedor();
    }

    @FXML
    void onAgregar(ActionEvent event) {
        agregarVendedor();
    }

    @FXML
    void onEliminar(ActionEvent event) {
        eliminarVendedor();
    }





    private void eliminarVendedor() {
        if (datosValidosVendedor(vendedorSelecionado) && datosValidosUsuario(vendedorSelecionado)) {
            if (vendedoresController.eliminarVendedor(vendedorSelecionado)) {
                eliminarTabVendedor(vendedorSelecionado);
                listaVendedores.remove(vendedorSelecionado);
                limpiarCampos();
                refrescarTabla();

                mostrarMensaje(TITULO_USUVENDEDOR_ELIMINADO, HEADER, BODY_USUVENDEDOR_ELIMINADO, Alert.AlertType.INFORMATION);
            } else {
                mostrarMensaje(TITULO_USUVENDEDOR_NO_ELIMNADO, HEADER, BODY_USUVENDEDOR_NO_ELIMINADO, Alert.AlertType.ERROR);
            }
        } else{
                mostrarMensaje(TITULO_CAMPOS_NO_SELECIONADO, HEADER, BODY_CAMPOS_NO_SELECIONADO, Alert.AlertType.INFORMATION);
            }
    }

    public void eliminarTabVendedor(Vendedor vendedor) {
        Tab tabToRemove = null;
        for (Tab tab : redSocialAppViewController.mainTab.getTabPane().getTabs()) {
            if (vendedor.getUsuarioAsociado().getUsername().equals(tab.getText())) {
                tabToRemove = tab;
                break;
            }
        }

        if (tabToRemove != null) {
            redSocialAppViewController.mainTab.getTabPane().getTabs().remove(tabToRemove);
        }
    }

    private void limpiarCampos() {
        txtNombreVendedor.setText("");
        txtApellidoVendedor.setText("");
        txtEmailVendedor.setText("");
        txtIdVendedor.setText("");
        txtDireccionVendedor.setText("");
        txtNombreUsuario.setText("");
        txtContrasenaUsuario.setText("");
    }

    private void refrescarTabla() {
        tableVendedor.refresh();
        tableVendedor.getSelectionModel().clearSelection();
    }
}