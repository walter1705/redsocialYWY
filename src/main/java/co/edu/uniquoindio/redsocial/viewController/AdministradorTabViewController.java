package co.edu.uniquoindio.redsocial.viewController;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class AdministradorTabViewController {
    RedsocialAppViewController redsocialAppViewController = RedsocialAppViewController.getController();

    @FXML
    private TabPane mainTab;

    @FXML
    private Tab estadisticasTab;

    @FXML
    private Tab vendedoresTab;

    @FXML
    private void initialize() {
        agregarTabs();

    }

    private void agregarTabs() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquoindio/redsocial/Vendedores.fxml"));
            AnchorPane vendedoresContent = loader.load();

            VendedoresViewController vendedoresController = loader.getController();
            vendedoresTab.setContent(vendedoresContent);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al cargar la vista ccccTab.");
        }

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquoindio/redsocial/Estadisticas.fxml"));
            ScrollPane estadisticasContent = loader.load();

            EstadisticasViewController vendedorController = loader.getController();

            estadisticasTab.setContent(estadisticasContent);

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al cargar la vista EstadisyivsdTab.");
        }
    }
}
