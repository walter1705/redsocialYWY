package co.edu.uniquoindio.redsocial.proxy;

import co.edu.uniquoindio.redsocial.model.Persona;
import co.edu.uniquoindio.redsocial.service.ILoginService;

public class LoginProxy implements ILoginService {
    private final ILoginService loginService;

    public LoginProxy(ILoginService loginService) {
        this.loginService = loginService;
    }

    @Override
    public boolean login(String user, String password) {
        return loginService.login(user, password);
    }
}