module co.edu.uniquoindio.redsocial.redsocial {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens co.edu.uniquoindio.redsocial to javafx.fxml;
    exports co.edu.uniquoindio.redsocial;
    opens co.edu.uniquoindio.redsocial.viewController;
    exports co.edu.uniquoindio.redsocial.viewController;
    opens co.edu.uniquoindio.redsocial.controller;
    exports co.edu.uniquoindio.redsocial.controller;
    //opens co.edu.uniquoindio.redsocial.redsocial.mapping;
    //exports co.edu.uniquoindio.redsocial.redsocial.mapping;
}