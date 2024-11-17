package co.edu.uniquoindio.redsocial.viewController;

import co.edu.uniquoindio.redsocial.StartRedSocial;
import co.edu.uniquoindio.redsocial.controller.RedsocialAppController;
import co.edu.uniquoindio.redsocial.model.EstadoProducto;
import co.edu.uniquoindio.redsocial.model.Producto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TabPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class RedsocialAppViewController {
    RedsocialAppController redsocialAppController = new RedsocialAppController();
    private static RedsocialAppViewController controller;
    private static final ObservableList<Producto> productosPublicados = FXCollections.observableArrayList();

    public static ObservableList<Producto> getProductosPublicados() {
        return productosPublicados;
    }

    public RedsocialAppViewController() {
        controller = this;
        productosPublicados.setAll(redsocialAppController.getProductoPublicados());
    }


    public void actualizarProductosMuro(Producto producto1) {
        if (producto1.getEstadoProducto().equals(EstadoProducto.PUBLICADO)) {
            productosPublicados.add(producto1);
        }
        productosPublicados.forEach(producto -> {
            if (producto.getEstadoProducto() == EstadoProducto.PUBLICADO
                    && !RedsocialAppViewController.getProductosPublicados().contains(producto)) {
                RedsocialAppViewController.getProductosPublicados().add(producto);
            } else if (producto.getEstadoProducto() != EstadoProducto.PUBLICADO) {
                RedsocialAppViewController.getProductosPublicados().remove(producto);
            }
        });
    }

    public static RedsocialAppViewController getController() {
        if (controller == null) {
            controller = new RedsocialAppViewController();
        }
        return controller;
    }
    
    @FXML
    private Button btnCerrarSesion;

    @FXML
    public TabPane TabPane;

    @FXML
    public Tab mainTab;

    @FXML
    void onCerrarSesion(ActionEvent event) throws IOException {
        Stage currentStage = (Stage) btnCerrarSesion.getScene().getWindow();
        currentStage.close();
        changeSceneToLoginAuth(new Stage());
    }

    private void changeSceneToLoginAuth(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(StartRedSocial.class.getResource("LoginAuth.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 340);
        stage.setTitle("MarketPlace login");
        Image icon = new Image(Objects.requireNonNull(getClass().getResource("/images/loginicon.png")).toExternalForm());
        stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void initialize() {
        agregarAdminTab();
    }

    private void agregarAdminTab() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquoindio/redsocial/AdministradorTab.fxml"));
            AnchorPane adminContent = loader.load();

            AdministradorTabViewController vendedorController = loader.getController();
            mainTab.setContent(adminContent);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al cargar la vista AdministradorTab.");
        }
    }
}
