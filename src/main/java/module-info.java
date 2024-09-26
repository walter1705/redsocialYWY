module co.edu.uniquoindio.redsocial.redsocial {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens co.edu.uniquoindio.redsocial.redsocial to javafx.fxml;
    exports co.edu.uniquoindio.redsocial.redsocial;
}