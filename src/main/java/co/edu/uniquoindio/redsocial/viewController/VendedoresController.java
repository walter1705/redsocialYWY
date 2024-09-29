package co.edu.uniquoindio.redsocial.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquoindio.redsocial.mapping.dto.VendedorDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class VendedoresController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnActualizar1;

    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnAgregar1;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnNuevo;

    @FXML
    private Button btnNuevo1;

    @FXML
    private TableView<VendedorDto> tableVendedor;

    @FXML
    private TableColumn<VendedorDto, String> tcApellido;

    @FXML
    private TableColumn<VendedorDto, String> tcContrasenaUsuario;

    @FXML
    private TableColumn<VendedorDto, String> tcEmail;

    @FXML
    private TableColumn<VendedorDto, String> tcNombre;

    @FXML
    private TableColumn<VendedorDto, String> tcNombreUsuario;

    @FXML
    private TextField txtApellido;

    @FXML
    private TextField txtApellido1;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtNombre1;

    @FXML
    void onActualizarCliente(ActionEvent event) {

    }

    @FXML
    void onAgregarCliente(ActionEvent event) {

    }

    @FXML
    void onEliminarCliente(ActionEvent event) {

    }

    @FXML
    void onNuevoCliente(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert btnActualizar != null : "fx:id=\"btnActualizar\" was not injected: check your FXML file 'Vendedores.fxml'.";
        assert btnActualizar1 != null : "fx:id=\"btnActualizar1\" was not injected: check your FXML file 'Vendedores.fxml'.";
        assert btnAgregar != null : "fx:id=\"btnAgregar\" was not injected: check your FXML file 'Vendedores.fxml'.";
        assert btnAgregar1 != null : "fx:id=\"btnAgregar1\" was not injected: check your FXML file 'Vendedores.fxml'.";
        assert btnEliminar != null : "fx:id=\"btnEliminar\" was not injected: check your FXML file 'Vendedores.fxml'.";
        assert btnNuevo != null : "fx:id=\"btnNuevo\" was not injected: check your FXML file 'Vendedores.fxml'.";
        assert btnNuevo1 != null : "fx:id=\"btnNuevo1\" was not injected: check your FXML file 'Vendedores.fxml'.";
        assert tableVendedor != null : "fx:id=\"tableVendedor\" was not injected: check your FXML file 'Vendedores.fxml'.";
        assert tcApellido != null : "fx:id=\"tcApellido\" was not injected: check your FXML file 'Vendedores.fxml'.";
        assert tcContrasenaUsuario != null : "fx:id=\"tcContrasenaUsuario\" was not injected: check your FXML file 'Vendedores.fxml'.";
        assert tcEmail != null : "fx:id=\"tcEmail\" was not injected: check your FXML file 'Vendedores.fxml'.";
        assert tcNombre != null : "fx:id=\"tcNombre\" was not injected: check your FXML file 'Vendedores.fxml'.";
        assert tcNombreUsuario != null : "fx:id=\"tcNombreUsuario\" was not injected: check your FXML file 'Vendedores.fxml'.";
        assert txtApellido != null : "fx:id=\"txtApellido\" was not injected: check your FXML file 'Vendedores.fxml'.";
        assert txtApellido1 != null : "fx:id=\"txtApellido1\" was not injected: check your FXML file 'Vendedores.fxml'.";
        assert txtEmail != null : "fx:id=\"txtEmail\" was not injected: check your FXML file 'Vendedores.fxml'.";
        assert txtNombre != null : "fx:id=\"txtNombre\" was not injected: check your FXML file 'Vendedores.fxml'.";
        assert txtNombre1 != null : "fx:id=\"txtNombre1\" was not injected: check your FXML file 'Vendedores.fxml'.";

    }

}