package co.edu.uniquoindio.redsocial.viewController;

import co.edu.uniquoindio.redsocial.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class RedsocialAppViewController {

    @FXML
    private Button btnCerrarSesion;

    @FXML
    void onCerrarSesion(ActionEvent event) throws IOException {
        Stage currentStage = (Stage) btnCerrarSesion.getScene().getWindow();
        currentStage.close();
        changeSceneToLoginAuth(new Stage());
    }

    private void changeSceneToLoginAuth(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("LoginAuth.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 340);
        stage.setTitle("MarketPlace login");
        Image icon = new Image(Objects.requireNonNull(getClass().getResource("/images/loginicon.png")).toExternalForm());
        stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.show();
    }

}
