package co.edu.uniquoindio.redsocial.service;

import co.edu.uniquoindio.redsocial.model.Persona;

public interface ILoginService {
    boolean login(String username, String password);
}
