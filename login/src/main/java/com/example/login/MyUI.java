package com.example.login;

import javax.servlet.annotation.WebServlet;

import org.orm.PersistentException;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import ventanas.Ingreso_aplicacion;
import ventanas.Pag_Administrador;
import ventanas.Pag_Registrado;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {
	Navigator navigator;
    @Override
    protected void init(VaadinRequest vaadinRequest) {
    	navigator = new Navigator(this, this);
		navigator.addView("", new Ingreso_aplicacion());
    	navigator.addView("Registrado",new Pag_Registrado());
    	navigator.addView("Admin",new Pag_Administrador());
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
