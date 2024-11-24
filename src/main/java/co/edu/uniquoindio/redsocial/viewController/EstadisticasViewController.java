package co.edu.uniquoindio.redsocial.viewController;

import java.io.File;
import java.time.LocalDate;
import java.util.List;

import co.edu.uniquoindio.redsocial.controller.EstadisticasController;
import co.edu.uniquoindio.redsocial.model.Persona;
import co.edu.uniquoindio.redsocial.model.Producto;
import co.edu.uniquoindio.redsocial.model.Usuario;
import co.edu.uniquoindio.redsocial.model.Vendedor;
import co.edu.uniquoindio.redsocial.service.ILoggerStrategy;
import co.edu.uniquoindio.redsocial.strategy.PdfLoggerStrategy;
import co.edu.uniquoindio.redsocial.strategy.TxtLoggerStrategy;
import co.edu.uniquoindio.redsocial.viewController.viewControllerHelpers.ViewControllerUtil;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import static co.edu.uniquoindio.redsocial.utils.RedSocialConstants.*;

public class EstadisticasViewController {
    VendedoresViewController vendedoresViewController = VendedoresViewController.getInstance();
    EstadisticasController estadisticasController = new EstadisticasController();
    ObservableList<Producto> listaProductosMostLiked = FXCollections.observableArrayList();
    ObservableList<Producto> listaProductosFecha = FXCollections.observableArrayList();
    String var1, var2, var3, directory;
    ILoggerStrategy logger;

    @FXML
    private Button bttnDirectory;

    @FXML
    private TableColumn<Producto, String> tcCategoriaMeGusta;

    @FXML
    private TableColumn<Producto, String> tcDescripcionMeGusta;

    @FXML
    private TableColumn<Producto, String> tcEstadoMeGusta;

    @FXML
    private TableColumn<Producto, String> tcNombreMeGusta;

    @FXML
    private TableColumn<Producto, String> tcLikesMeGusta;


    @FXML
    private TableColumn<Producto, String> tcPrecioMeGusta;

    @FXML
    private Button bttnExportar;

    @FXML
    private RadioButton cantMensajesDosVendedores;

    @FXML
    private RadioButton cantProductorFecha;

    @FXML
    private RadioButton cantProductosEachVendeor;

    @FXML
    private ChoiceBox<String> choiceBoxFormatoLog;

    @FXML
    private DatePicker datePickerFinalReq;

    @FXML
    private DatePicker datePickerInicialReq;

    @FXML
    private Label labelFechaFinalProductosReq;

    @FXML
    private Label labelFechaInicialProductosReq;

    @FXML
    private Label labelFormatoExportar;

    @FXML
    private Label labelSeleccioneDosVendedores;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private TableView<Producto> tableViewProductosMostLiked;

    @FXML
    private TextArea textAreaFechaDeterminada;

    @FXML
    private TextArea textAreaMsjEnviados;

    @FXML
    private TextArea textAreaProductsByVendedor;

    @FXML
    private RadioButton topDiezMostLike;

    @FXML
    private ChoiceBox<Vendedor> vendedor1ChoiceBoxMsjEnviados;

    @FXML
    private ChoiceBox<Vendedor> vendedor2ChoiceBoxMsjEnviados;


    @FXML
    void onDirectory(ActionEvent event) {
        seleccionarDirectorio(new Stage());
    }

    public void seleccionarDirectorio(Stage stage) {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Seleccionar directorio");


        File selectedDirectory = directoryChooser.showDialog(stage);

        if (selectedDirectory != null) {
            directory = selectedDirectory.getAbsolutePath();
            System.out.println("Directorio seleccionado: " + selectedDirectory.getAbsolutePath());
        } else {
            System.out.println("No se seleccionó ningún directorio.");
        }
    }

    @FXML
    void onExportarLog(ActionEvent event) {
        String log = traerLogsValidos();
        Usuario usuario = estadisticasController.getPersonaOnSession().getUsuarioAsociado();
        if (directory != null) {
            if (logger != null) {
                if (log != null) {
                    estadisticasController.exportarEstadisticas(logger, directory, log, usuario);
                } else {
                    ViewControllerUtil.mostrarMensaje(TITULO_CAMPOS_INCOMPLETOS, HEADER, BODY_TIPONOESPECIFICADO, Alert.AlertType.ERROR);
                }
            } else {
                //mensaje todo
            }
        } else {} //todo

    }//

    private String traerLogsValidos() {
        String log = "";
        if (var1!=null) log+=var1;
        if (var2!=null) log+=var2;
        if (var3!=null) log+=var3;
        return !log.isEmpty() ?  log : null;
    }

    @FXML
    void onTopDiezMostLike(ActionEvent event) {
        top10MostLiked();
    }

    private void top10MostLiked() {
        if (topDiezMostLike.isSelected()) {
            listaProductosMostLiked.setAll(estadisticasController.getTop3MostLikedProducts());
            asignarDatosVar3();
        } else {
            var3 = null;
            listaProductosMostLiked.clear();
        }
    }



    private void inicializarEstadisticas3() {
    }

    @FXML
    void initialize() {
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        dataBinding();
        inicializarEstadisticas1();
        inicializarButtons();
        textAreaFechaDeterminada.setDisable(true);
    }

    private void dataBinding() {
        tcCategoriaMeGusta.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCategoria()));
        tcDescripcionMeGusta.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDescripcion()));
        tcEstadoMeGusta.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEstadoProducto().name()));
        tcNombreMeGusta.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tcPrecioMeGusta.setCellValueFactory(cellData -> new SimpleStringProperty(Double.toString(cellData.getValue().getPrecio())));
        tcLikesMeGusta.setCellValueFactory(cellData ->
                new SimpleStringProperty(Integer.toString(cellData.getValue().getPublicacionAsociado().getLike())));
    }

    private void inicializarButtons() {
        choiceBoxFormatoLog.setItems(FXCollections.observableArrayList("pdf", "txt"));

        choiceBoxFormatoLog.setOnAction(event -> {
            String seleccion = choiceBoxFormatoLog.getValue();
            switch (seleccion) {
                case "txt":
                    logger = new TxtLoggerStrategy();
                    break;
                case "pdf":
                    logger = new PdfLoggerStrategy();
                    break;
                default:
                    System.out.println("Formato desconocido");
                    break;
            }
        });
        tableViewProductosMostLiked.setItems(listaProductosMostLiked);
    }

    //ESTADISTICAS 1 METHODS
    private void inicializarEstadisticas1() {
        StringConverter<Vendedor> vendedorStringConverter = new StringConverter<>() {
            @Override
            public String toString(Vendedor vendedor) {
                return vendedor != null ? vendedor.getUsuarioAsociado().getUsername() : "";
            }

            @Override
            public Vendedor fromString(String s) {
                return null;
            }
        };

        vendedor1ChoiceBoxMsjEnviados.setConverter(vendedorStringConverter);
        vendedor2ChoiceBoxMsjEnviados.setConverter(vendedorStringConverter);
        vendedor1ChoiceBoxMsjEnviados.setItems(vendedoresViewController.listaVendedores);
        vendedor2ChoiceBoxMsjEnviados.setItems(vendedoresViewController.listaVendedores);
        textAreaMsjEnviados.setEditable(false);
    }

    private void limpiarBotonesCantidadMensajes() {
        vendedor1ChoiceBoxMsjEnviados.getSelectionModel().clearSelection();
        vendedor2ChoiceBoxMsjEnviados.getSelectionModel().clearSelection();
    }

    private boolean verificarBotonCantidadMensajes() {
        if (vendedor1ChoiceBoxMsjEnviados.getValue()==null ||
                vendedor2ChoiceBoxMsjEnviados.getValue()==null) {
            ViewControllerUtil.mostrarMensaje(TITULO_NO_SE_SELECCIONA_UNO, HEADER, BODY_NO_SE_SELECCIONA_UNO, Alert.AlertType.INFORMATION);
            cantMensajesDosVendedores.setSelected(false);
            limpiarBotonesCantidadMensajes();
            return false;
        }

        if (cantMensajesDosVendedores.isSelected()) {
            if(vendedor1ChoiceBoxMsjEnviados.getValue().equals(vendedor2ChoiceBoxMsjEnviados.getValue()) ||
                    vendedor2ChoiceBoxMsjEnviados.getValue().equals(vendedor1ChoiceBoxMsjEnviados.getValue())) {
                cantMensajesDosVendedores.setSelected(false);
                ViewControllerUtil.mostrarMensaje(TITULO_NO_SE_SELECCIONA_EL_MISMO, HEADER, BODY_NO_SE_SELECCIONA_EL_MISMO,
                Alert.AlertType.INFORMATION);
                limpiarBotonesCantidadMensajes();
                return false;
            }
        } else {
            var1 = null;
        }
        return true;
    }



    @FXML
    void onCantMensajesDosVendedores(ActionEvent event) {
        if(verificarBotonCantidadMensajes()) {
            //controllerClassGetMensajesEach(v1, v2);
            //vendedor1ChoiceBoxMsjEnviados.getValue().getMuroAsociado().getListaMensajes().size(); //TODO
        }
    }

    //ESTADISTICAS 2 METHODS
    @FXML
    void onCantProductorFecha(ActionEvent event) {
        if (cantProductorFecha.isSelected()) {
            if (verificaronCantProductorFecha()) {
                LocalDate d1 = datePickerInicialReq.getValue();
                LocalDate d2 = datePickerFinalReq.getValue();
                String cantidad = estadisticasController.cantProductosFechas(d1, d2);
                listaProductosFecha.setAll(estadisticasController.getCantProductosFechas(d1, d2));
                asignarDatosVar2();
                textAreaFechaDeterminada.setText(cantidad);
            }
        } else {
            var2 = null;
            textAreaFechaDeterminada.setText("");
        }

    }
    private void asignarDatosVar3() {

        String saltoDeLinea = System.lineSeparator();
        var3 = "Top 3 productos con mas likes: "+ saltoDeLinea;
        listaProductosMostLiked.forEach(producto -> {
            var3 += producto.toString()+saltoDeLinea;
        });
        var3+=saltoDeLinea;
    }

    private void asignarDatosVar2() {
        String saltoDeLinea = System.lineSeparator();
        var2 = "La cantidad de productos publicados entre "+datePickerInicialReq.getValue().toString()
                +" y "+datePickerFinalReq.getValue().toString() +" fueron : "+ saltoDeLinea;

        listaProductosFecha.forEach(producto -> {
            var2 += producto.toString()+saltoDeLinea;
        });
        var2+=saltoDeLinea;

    }

    private void limpiarDatePickerReq() {
        datePickerInicialReq.setValue(null);
        datePickerFinalReq.setValue(null);
    }

    private boolean verificaronCantProductorFecha() {
        if (datePickerInicialReq.getValue()==null ||
                datePickerFinalReq.getValue()==null) {
            ViewControllerUtil.mostrarMensaje(TITULO_NO_SE_SELECCIONA_UNO, HEADER, BODY_NO_SE_SELECCIONA_UNO, Alert.AlertType.INFORMATION);
            cantProductorFecha.setSelected(false);
            limpiarDatePickerReq();
            return false;
        } else if (datePickerInicialReq.getValue().isAfter(datePickerFinalReq.getValue())) {
            ViewControllerUtil.mostrarMensaje(TITULO_NO_SE_SELECCIONA_UNO, HEADER, BODY_NO_DESPUES, Alert.AlertType.WARNING);
            cantProductorFecha.setSelected(false);
            limpiarDatePickerReq();
            return false;
        }
        return true;
    }
}

