package co.edu.uniquoindio.redsocial.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquoindio.redsocial.model.Vendedor;
import co.edu.uniquoindio.redsocial.viewController.viewControllerHelpers.ViewControllerUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.control.*;
import javafx.util.StringConverter;

import static co.edu.uniquoindio.redsocial.utils.RedSocialConstants.*;

public class EstadisticasViewController {
    VendedoresViewController vendedoresViewController = RedsocialAppViewController.getController().getVendedoresViewController();


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private BarChart<?, ?> barChartContactosVendedores;

    @FXML
    private Button bttnExportar;

    @FXML
    private RadioButton cantContactosEachVendedor;

    @FXML
    private RadioButton cantMensajesDosVendedores;

    @FXML
    private RadioButton cantProductorFecha;

    @FXML
    private RadioButton cantProductosEachVendeor;

    @FXML
    private ChoiceBox<?> choiceBoxFormatoLog;

    @FXML
    private ChoiceBox<?> choiceBoxProductsByVendedor;

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
    private TableView<?> tableViewProductosMostLiked;

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
    void OnCantProductosEachVendedor(ActionEvent event) {

    }

    @FXML
    void onCantContactosEachVendedor(ActionEvent event) {

    }



    @FXML
    void onCantProductorFecha(ActionEvent event) {

    }

    @FXML
    void onExportarLog(ActionEvent event) {

    }

    @FXML
    void onTopDiezMostLike(ActionEvent event) {

    }

    @FXML
    void initialize() {
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        inicializarEstadisticas1();
    }
    //ESTADISTICAS 1 METHODS
    private void inicializarEstadisticas1() {
        // Configura el StringConverter para mostrar solo el nombre de usuario en la ChoiceBox
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
        }
        return true;
    }



    @FXML
    void onCantMensajesDosVendedores(ActionEvent event) {
        if(verificarBotonCantidadMensajes()) {
            //modelFactoryGetMensajesEach(v1, v2)
            //vendedor1ChoiceBoxMsjEnviados.getValue().getMuroAsociado().getListaMensajes().size(); //TODO
        }
    }

    //ESTADISTICAS 2 METHODS
}

