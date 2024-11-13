package co.edu.uniquoindio.redsocial.viewController.viewControllerHelpers;

import javafx.scene.control.Alert;

public class ViewControllerUtil {
    public static void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {
        Alert aler = new Alert(alertType);
        aler.setTitle(titulo);
        aler.setHeaderText(header);
        aler.setContentText(contenido);
        aler.showAndWait();
    }
}
