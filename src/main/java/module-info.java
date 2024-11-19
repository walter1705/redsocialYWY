module co.edu.uniquoindio.redsocial.redsocial {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.desktop;
    requires pdfua;
    requires layout;
    requires kernel;
    requires org.bouncycastle.provider;
    requires org.slf4j;

    opens co.edu.uniquoindio.redsocial to javafx.fxml;
    exports co.edu.uniquoindio.redsocial;
    opens co.edu.uniquoindio.redsocial.viewController;
    exports co.edu.uniquoindio.redsocial.viewController;
    opens co.edu.uniquoindio.redsocial.controller;
    exports co.edu.uniquoindio.redsocial.controller;
    opens co.edu.uniquoindio.redsocial.model;
    exports co.edu.uniquoindio.redsocial.model;
    opens co.edu.uniquoindio.redsocial.utils;
    exports co.edu.uniquoindio.redsocial.utils;
    opens co.edu.uniquoindio.redsocial.model.builder;
    exports co.edu.uniquoindio.redsocial.model.builder;
    opens co.edu.uniquoindio.redsocial.service;
    exports co.edu.uniquoindio.redsocial.service;
    exports co.edu.uniquoindio.redsocial.strategy;
    opens co.edu.uniquoindio.redsocial.strategy;
}