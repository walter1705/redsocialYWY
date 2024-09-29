package co.edu.uniquoindio.redsocial.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquoindio.redsocial.controller.VendedoresController;
import co.edu.uniquoindio.redsocial.mapping.dto.UsuarioDto;
import co.edu.uniquoindio.redsocial.mapping.dto.UsuarioVendedorDto;
import co.edu.uniquoindio.redsocial.mapping.dto.VendedorDto;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class VendedoresViewController {
    VendedoresController vendedoresController;
    ObservableList<UsuarioVendedorDto> listaUsuariosVendedores = FXCollections.observableArrayList();
    UsuarioVendedorDto vendedorSelecionado;


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnActualizarUsuario;

    @FXML
    private Button btnActualizarVendedor;

    @FXML
    private Button btnAgregarUsuario;

    @FXML
    private Button btnAgregarVendedor;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnNuevoUsuario;

    @FXML
    private Button btnNuevoVendedor;

    @FXML
    private TableView<UsuarioVendedorDto> tableVendedor;

    @FXML
    private TableColumn<UsuarioVendedorDto, String> tcApellidoVendedor;

    @FXML
    private TableColumn<UsuarioVendedorDto, String> tcContrasenaUsuario;

    @FXML
    private TableColumn<UsuarioVendedorDto, String> tcEmailVendedor;

    @FXML
    private TableColumn<UsuarioVendedorDto, String> tcNombreUsuario;

    @FXML
    private TableColumn<UsuarioVendedorDto, String> tcNombreVendedor;

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
    void initialize() {
        vendedoresController = new VendedoresController();
        initView();
    }

    private void initView() {
        initDataBinding();
        obtenerVendedores();
        tableVendedor.getItems().clear();
        tableVendedor.setItems(listaUsuariosVendedores);
        listenerSelection();
    }

    private void obtenerVendedores() {
        listaUsuariosVendedores.addAll(vendedoresController.getUsuariosVendedoresDto());
    }

    private void listenerSelection() {
        tableVendedor.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            vendedorSelecionado = newSelection;
            mostrarInformacionVendedor(vendedorSelecionado);
        });
    }

    private void mostrarInformacionVendedor(UsuarioVendedorDto vendedorSelecionado) {
        if (vendedorSelecionado != null) {
            txtNombreVendedor.setText(vendedorSelecionado.nombre());
            txtApellidoVendedor.setText(vendedorSelecionado.apellido());
            txtEmailVendedor.setText(vendedorSelecionado.email());
            txtNombreUsuario.setText(vendedorSelecionado.username());
            txtContrasenaUsuario.setText(vendedorSelecionado.password());
        }
    }

    private void initDataBinding() {
        tcNombreVendedor.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().nombre()));
        tcApellidoVendedor.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().apellido()));
        tcEmailVendedor.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().email()));
        tcNombreUsuario.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().username()));
        tcContrasenaUsuario.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().password()));
    }


    @FXML
    void onActualizarUsuario(ActionEvent event) {

    }

    @FXML
    void onActualizarVendedor(ActionEvent event) {

    }

    @FXML
    void onAgregarUsuario(ActionEvent event) {

    }

    @FXML
    void onAgregarVendedor(ActionEvent event) {

    }

    @FXML
    void onEliminarCliente(ActionEvent event) {

    }

    @FXML
    void onNuevoUsuario(ActionEvent event) {

    }

    @FXML
    void onNuevoVendedor(ActionEvent event) {

    }

 
}
