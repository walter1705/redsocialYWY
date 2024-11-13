package co.edu.uniquoindio.redsocial.viewController;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import co.edu.uniquoindio.redsocial.StartRedSocial;
import co.edu.uniquoindio.redsocial.factory.ModelFactory;
import co.edu.uniquoindio.redsocial.model.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginAuthViewController {


    ModelFactory modelFactory;
    public LoginAuthViewController(){
        modelFactory = ModelFactory.getInstance();
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button IngresarButton;

    @FXML
    private PasswordField IntroducirContrasenaTextField;

    @FXML
    private TextField IntroducirUsuarioTextField;

    @FXML
    private Label contrasenaTxt;

    @FXML
    private Text textLabellogin;

    @FXML
    private Label usuarioTxt;

    @FXML
    void OnIngresarAttempt(ActionEvent event) throws IOException {
        if(!IntroducirUsuarioTextField.getText().isBlank() && !IntroducirContrasenaTextField.getText().isBlank()) {
            validateLogin();
        } else if (IntroducirUsuarioTextField.getText().isBlank() && IntroducirContrasenaTextField.getText().isBlank()) {
            textLabellogin.setText("Ingrese usuario y contraseña. ");
        } else if (IntroducirUsuarioTextField.getText().isBlank()) {
            textLabellogin.setText("Ingrese el usuario.");
        } else if (IntroducirContrasenaTextField.getText().isBlank()) {
            textLabellogin.setText("Ingrese la contraseña.");
        }
    }

    private void validateLogin() throws IOException {
        boolean centi = false;
        for(Usuario usuario : modelFactory.getUsuarios()) {
            if (usuario.getUsername().equals(IntroducirUsuarioTextField.getText()) &&
                    usuario.getPassword().equals(IntroducirContrasenaTextField.getText())) {

                centi = true;
                Stage currentStage = (Stage) IngresarButton.getScene().getWindow();
                currentStage.close();

                changeSceneToRedSocialApp(new Stage());
                break;
            }
        }
        if (!centi) {
            textLabellogin.setText("Usuario o contraseña incorrecta.");
        }
    }


    private void changeSceneToRedSocialApp(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(StartRedSocial.class.getResource("RedsocialApp.fxml"));
        Parent root = fxmlLoader.load();

        RedsocialAppViewController redSocialController = fxmlLoader.getController();

        // Llamar a loadViewsAfterLogin desde el controlador de vendedores
        //redSocialController.getVendedoresViewController().loadViewsAfterLogin();

        Scene scene = new Scene(root, 1037, 815);
        stage.setTitle("MarketPlace");

        Image icon = new Image(Objects.requireNonNull(getClass().getResource("/images/redsociallogo.png")).toExternalForm());
        stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void initialize() {
    }

}
