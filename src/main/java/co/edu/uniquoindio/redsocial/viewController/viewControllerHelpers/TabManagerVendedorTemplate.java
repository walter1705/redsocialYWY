package co.edu.uniquoindio.redsocial.viewController.viewControllerHelpers;

import co.edu.uniquoindio.redsocial.model.Vendedor;
import co.edu.uniquoindio.redsocial.viewController.VendedorTemplateViewController;
import javafx.scene.control.Tab;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class TabManagerVendedorTemplate {
    private static TabManagerVendedorTemplate instance;
    private final Map<Vendedor, Tab> tabs = new HashMap<>();

    private TabManagerVendedorTemplate() {}

    public static TabManagerVendedorTemplate getInstance() {
        if (instance == null) {
            instance = new TabManagerVendedorTemplate();
        }
        return instance;
    }

    public void agregarTab(Vendedor vendedor, Tab tab) {
        tabs.put(vendedor, tab);
    }

    public Tab getTab(Vendedor vendedor) {
        return tabs.get(vendedor);
    }

    public Collection<Tab> getTabs() {
        return tabs.values();
    }

    public boolean hasTab(Vendedor vendedor) {
        return tabs.containsKey(vendedor);
    }

    public void actualizarTab(Vendedor vendedorseleccionado, Vendedor vendedor) {
        Tab tab = getTab(vendedorseleccionado);
        if (tab != null) {
            tabs.remove(vendedorseleccionado, tab);
            tabs.put(vendedor, tab);
            tab.setText(vendedor.getUsuarioAsociado().getUsername());
        } else {
            System.out.println("No se puede agregar el tab");
        }
    }
}
