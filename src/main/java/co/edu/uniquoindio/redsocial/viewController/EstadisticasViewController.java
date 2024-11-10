package co.edu.uniquoindio.redsocial.viewController;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.control.*;

public class EstadisticasViewController {

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
    private ChoiceBox<?> vendedor1ChoiceBoxMsjEnviados;

    @FXML
    private ChoiceBox<?> vendedor2ChoiceBoxMsjEnviados;

    @FXML
    void OnCantProductosEachVendedor(ActionEvent event) {

    }

    @FXML
    void onCantContactosEachVendedor(ActionEvent event) {

    }

    @FXML
    void onCantMensajesDosVendedores(ActionEvent event) {

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
    }

}

