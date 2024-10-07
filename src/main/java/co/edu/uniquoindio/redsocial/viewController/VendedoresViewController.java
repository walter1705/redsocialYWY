package co.edu.uniquoindio.redsocial.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquoindio.redsocial.utils.RedSocialConstants.*;
import co.edu.uniquoindio.redsocial.controller.VendedoresController;
import co.edu.uniquoindio.redsocial.factory.ModelFactory;
import co.edu.uniquoindio.redsocial.mapping.dto.UsuarioDto;
import co.edu.uniquoindio.redsocial.mapping.dto.UsuarioVendedorDto;
import co.edu.uniquoindio.redsocial.mapping.dto.VendedorDto;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import static co.edu.uniquoindio.redsocial.utils.RedSocialConstants.*;

public class VendedoresViewController {
    VendedoresController vendedoresController;
    ObservableList<UsuarioVendedorDto> listaUsuariosVendedores = FXCollections.observableArrayList();
    UsuarioVendedorDto vendedorSelecionado;



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
    private TableView<UsuarioVendedorDto> tableVendedor;

    @FXML
    private TableColumn<UsuarioVendedorDto, String> tcApellidoVendedor;

    @FXML
    private TableColumn<UsuarioVendedorDto, String> tcContrasenaUsuario;

    @FXML
    private TableColumn<UsuarioVendedorDto, String> tcEmailVendedor;

    @FXML
    private TableColumn<UsuarioVendedorDto, String> tcIdVendedor;

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
    private TextField txtIdVendedor;

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
            if (vendedorSelecionado != null) {
                mostrarInformacionVendedor(vendedorSelecionado);
            }
        });
    }
    //partir usuario y vendedor

    private void mostrarInformacionVendedor(UsuarioVendedorDto vendedorSelecionado) {
        if (vendedorSelecionado != null) {
            txtNombreVendedor.setText(vendedorSelecionado.nombre());
            txtApellidoVendedor.setText(vendedorSelecionado.apellido());
            txtEmailVendedor.setText(vendedorSelecionado.email());
            txtIdVendedor.setText(vendedorSelecionado.id());
            txtNombreUsuario.setText(vendedorSelecionado.username());
            txtContrasenaUsuario.setText(vendedorSelecionado.password());
        }
    }

    private void agregarUsuarioVendedor() {
        UsuarioVendedorDto usuarioVendedorDto = crearUsuarioVendedorDto();
        if (datosValidosUsuario(usuarioVendedorDto) && datosValidosVendedor(usuarioVendedorDto)) {
            boolean usuarioAgregado = vendedoresController.agregarUsuarioDto(usuarioVendedorDto);
            boolean vendedorAgregado = vendedoresController.agregarVendedorDto(usuarioVendedorDto);
            if (usuarioAgregado && vendedorAgregado) {
                listaUsuariosVendedores.addAll(usuarioVendedorDto);
                limpiarCampos();
                tableVendedor.refresh();
                mostrarMensaje(TITULO_USUVENDEDOR_AGREGADO, HEADER, BODY_USUVENDEDOR_AGREGADO, Alert.AlertType.INFORMATION);
            } else if (usuarioAgregado) {
                listaUsuariosVendedores.addAll(getUsuarioFromMainDto(usuarioVendedorDto));
                limpiarCampos();
                tableVendedor.refresh();
                mostrarMensaje(TITULO_USUARIO_AGREGADO, HEADER, BODY_USUARIO_AGREGADO, Alert.AlertType.INFORMATION);
            } else if (vendedorAgregado) {
                listaUsuariosVendedores.addAll(getVendedorFromMainDto(usuarioVendedorDto));
                limpiarCampos();
                tableVendedor.refresh();
                mostrarMensaje(TITULO_VENDEDOR_AGREGADO, HEADER, BODY_VENDEDOR_AGREGADO, Alert.AlertType.INFORMATION);
            } else {
                mostrarMensaje(TITULO_USUVENDEDOR_NO_AGREGADO, HEADER, BODY_USUVENDEDOR_NO_AGREGADO, Alert.AlertType.ERROR);
            }
        } else if(datosValidosUsuario(usuarioVendedorDto)) {
            boolean usuarioAgregado = vendedoresController.agregarUsuarioDto(usuarioVendedorDto);
            if (usuarioAgregado) {
                listaUsuariosVendedores.addAll(getUsuarioFromMainDto(usuarioVendedorDto));
                limpiarCampos();
                tableVendedor.refresh();
                mostrarMensaje(TITULO_USUARIO_AGREGADO, HEADER, BODY_USUARIO_AGREGADO, Alert.AlertType.INFORMATION);
            } else {
                mostrarMensaje(TITULO_USUARIO_NO_AGREGADO, HEADER, BODY_USUARIO_NO_AGREGADO, Alert.AlertType.INFORMATION);
            }
        } else if (datosValidosVendedor(usuarioVendedorDto)) {
            boolean vendedorAgregado = vendedoresController.agregarVendedorDto(usuarioVendedorDto);
            if (vendedorAgregado) {
                listaUsuariosVendedores.addAll(getVendedorFromMainDto(usuarioVendedorDto));
                limpiarCampos();
                tableVendedor.refresh();
                mostrarMensaje(TITULO_VENDEDOR_AGREGADO, HEADER, BODY_VENDEDOR_AGREGADO, Alert.AlertType.INFORMATION);
            } else{
                mostrarMensaje(TITULO_VENDEDOR_NO_AGREGADO, HEADER, BODY_VENDEDOR_NO_AGREGADO, Alert.AlertType.INFORMATION);
            }
        } else {
            mostrarMensaje(TITULO_CAMPOS_INCOMPLETOS, HEADER, BODY_CAMPOS_INCOMPLETOS, Alert.AlertType.INFORMATION);
        }
    }


    private UsuarioVendedorDto getVendedorFromMainDto(UsuarioVendedorDto usuarioVendedorDto) {
        return new UsuarioVendedorDto("",
                "",
                usuarioVendedorDto.nombre(),
                usuarioVendedorDto.apellido(),
                usuarioVendedorDto.email(),
                usuarioVendedorDto.id()
        );
    }

    private UsuarioVendedorDto getUsuarioFromMainDto(UsuarioVendedorDto usuarioVendedorDto) {
        return new UsuarioVendedorDto(usuarioVendedorDto.username(),
                usuarioVendedorDto.password(),
                "",
                "",
                "",
                "");
    }

    private boolean datosValidosUsuario(UsuarioVendedorDto usuarioVendedorDto) {
        return !usuarioVendedorDto.nombre().isBlank() &&
                !usuarioVendedorDto.apellido().isBlank() &&
                !usuarioVendedorDto.id().isBlank() &&
                !usuarioVendedorDto.email().isBlank();
    }


    private boolean datosValidosVendedor(UsuarioVendedorDto usuarioVendedorDto) {
        return !usuarioVendedorDto.username().isBlank() && !usuarioVendedorDto.password().isBlank();
    }

    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {
        Alert aler = new Alert(alertType);
        aler.setTitle(titulo);
        aler.setHeaderText(header);
        aler.setContentText(contenido);
        aler.showAndWait();
    }

    private UsuarioVendedorDto crearUsuarioVendedorDto() {
        return new UsuarioVendedorDto(txtNombreUsuario.getText(),
                txtContrasenaUsuario.getText(),
                txtNombreVendedor.getText(),
                txtApellidoVendedor.getText(),
                txtEmailVendedor.getText(),
                txtIdVendedor.getText());
    }


    private void initDataBinding() {
        tcNombreVendedor.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().nombre()));
        tcApellidoVendedor.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().apellido()));
        tcEmailVendedor.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().email()));
        tcIdVendedor.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().id()));
        tcNombreUsuario.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().username()));
        tcContrasenaUsuario.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().password()));
    }


    @FXML
    void onActualizar(ActionEvent event) {
        actualizarUsuarioVendedor();
    }

    @FXML
    void onAgregar(ActionEvent event) {
        agregarUsuarioVendedor();
    }

    @FXML
    void onEliminar(ActionEvent event) {
        eliminarUsuarioVendedor();
    }

    private void actualizarUsuarioVendedor() {
        UsuarioVendedorDto usuarioVendedorDto = crearUsuarioVendedorDto();
        if (datosValidosUsuario(usuarioVendedorDto)) {
            if (vendedoresController.actualizarUsuarioVendedor(vendedorSelecionado.username(), vendedorSelecionado.id(), usuarioVendedorDto)) {
                actualizarUsuarioVendedorListaObserver(usuarioVendedorDto);
                limpiarCampos();
                tableVendedor.refresh();
                mostrarMensaje(TITULO_USUVENDEDOR_ACTUALIZADO, HEADER, BODY_USUVENDEDOR_ACTUALIZADO, Alert.AlertType.INFORMATION);
            } else {
                mostrarMensaje(TITULO_USUVENDEDOR_NO_ACTUALIZADO, HEADER, BODY_USUVENDEDOR_NO_ACTUALIZADO, Alert.AlertType.ERROR);
            }
        } else {
            mostrarMensaje(TITULO_CAMPOS_NO_SELECIONADO, HEADER, BODY_CAMPOS_NO_SELECIONADO, Alert.AlertType.INFORMATION);
        }
    }

    private void actualizarUsuarioVendedorListaObserver(UsuarioVendedorDto usuarioVendedorDto) {
        for (int i = 0; i < listaUsuariosVendedores.size(); i++) {
            if (listaUsuariosVendedores.get(i).id().equals(vendedorSelecionado.id())) {
                listaUsuariosVendedores.set(i, usuarioVendedorDto);
                break;
            }
        }
    }

    private void eliminarUsuarioVendedor() {
        if (datosValidosUsuario(vendedorSelecionado)) //FFFFF{
            if (vendedoresController.eliminarUsuarioVendedor(vendedorSelecionado)) {
                listaUsuariosVendedores.remove(vendedorSelecionado);
                limpiarCampos();
                tableVendedor.refresh();
                mostrarMensaje(TITULO_USUVENDEDOR_ELIMINADO, HEADER, BODY_USUVENDEDOR_ELIMINADO, Alert.AlertType.INFORMATION);
            } else {
                mostrarMensaje(TITULO_USUVENDEDOR_NO_ELIMNADO, HEADER, BODY_USUVENDEDOR_NO_ELIMINADO, Alert.AlertType.ERROR);
            }else {
            mostrarMensaje(TITULO_CAMPOS_NO_SELECIONADO, HEADER, BODY_CAMPOS_NO_SELECIONADO, Alert.AlertType.INFORMATION);
        }
    }

    @FXML
    void onNuevo(ActionEvent event) {

    }

    private void limpiarCampos() {
        txtNombreVendedor.setText("");
        txtApellidoVendedor.setText("");
        txtEmailVendedor.setText("");
        txtIdVendedor.setText("");
        txtNombreUsuario.setText("");
        txtContrasenaUsuario.setText("");
    }
}