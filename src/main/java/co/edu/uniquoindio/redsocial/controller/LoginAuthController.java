package co.edu.uniquoindio.redsocial.controller;

import co.edu.uniquoindio.redsocial.factory.ModelFactory;

public class LoginAuthController {
    ModelFactory modelFactory = ModelFactory.getInstance();

    public boolean login(String username, String password) {
        return modelFactory.login(username, password);
    }
}
