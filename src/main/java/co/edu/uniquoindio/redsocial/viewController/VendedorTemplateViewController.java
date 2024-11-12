package co.edu.uniquoindio.redsocial.viewController;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;

public class VendedorTemplateViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ToggleButton bttnLike;

    @FXML
    private ImageView imageViewListProductos;

    @FXML
    private Label likeCounter;

    @FXML
    private TableColumn<?, ?> tableViewListaContactos;

    @FXML
    private TableColumn<?, ?> tcProductCategoria;

    @FXML
    private TableColumn<?, ?> tcProductDescripcion;

    @FXML
    private TableColumn<?, ?> tcProductNombre;

    @FXML
    private TableColumn<?, ?> tcProductPrecio;

    @FXML
    void onBttnLike(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert bttnLike != null : "fx:id=\"bttnLike\" was not injected: check your FXML file 'VendedorTemplate.fxml'.";
        assert imageViewListProductos != null : "fx:id=\"imageViewListProductos\" was not injected: check your FXML file 'VendedorTemplate.fxml'.";
        assert likeCounter != null : "fx:id=\"likeCounter\" was not injected: check your FXML file 'VendedorTemplate.fxml'.";
        assert tableViewListaContactos != null : "fx:id=\"tableViewListaContactos\" was not injected: check your FXML file 'VendedorTemplate.fxml'.";
        assert tcProductCategoria != null : "fx:id=\"tcProductCategoria\" was not injected: check your FXML file 'VendedorTemplate.fxml'.";
        assert tcProductDescripcion != null : "fx:id=\"tcProductDescripcion\" was not injected: check your FXML file 'VendedorTemplate.fxml'.";
        assert tcProductNombre != null : "fx:id=\"tcProductNombre\" was not injected: check your FXML file 'VendedorTemplate.fxml'.";
        assert tcProductPrecio != null : "fx:id=\"tcProductPrecio\" was not injected: check your FXML file 'VendedorTemplate.fxml'.";

    }

    public void updateView() {
    }
}
