package ventanas;

import java.util.List;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import bbdd.*;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;

public class IniciarSesion extends IniciarSesion_ventana {
	public Ingreso_aplicacion _unnamed_Ingreso_aplicacion_;
	iUsuario us = new BD_Principal();
	List<bbdd.Registrado> usuarios = us.cargarUsuarios();

	public IniciarSesion() {
		login.addClickListener(new Button.ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {

				login();
			}
		});
	}

	public void login() {
		String user = usuario___.getValue();
		String pass = password___.getValue();
		boolean loginOk = false;
		for (int i = 0; i <= usuarios.size() - 1; i++) {
			if (user.equals(usuarios.get(i).getNombre()) && pass.equals(usuarios.get(i).getPass()) &&
					user.length() > 0 || pass.length() > 0) {
				if(usuarios.get(i).getRol().equals("Registrado")) {
					UI.getCurrent().getNavigator().navigateTo("Registrado");
				}
				if(usuarios.get(i).getRol().equals("Admin")) {
					UI.getCurrent().getNavigator().navigateTo("Admin");
				}
				loginOk = true;
			}
		}
		if (!loginOk) {
			errorLogin.setValue("El login no es correcto");
			errorLogin.setVisible(true);
		}
	}
}