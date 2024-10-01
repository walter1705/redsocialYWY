package co.edu.uniquoindio.redsocial;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("LoginAuth.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 340);
        stage.setTitle("MarketPlace login");
        Image icon = new Image(Objects.requireNonNull(getClass().getResource("/images/loginicon.png")).toExternalForm());
        stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}