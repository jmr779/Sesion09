package ventanas;

import java.util.List;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import bbdd.*;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;

public class IniciarSesion extends IniciarSesion_ventana{
	public Ingreso_aplicacion _unnamed_Ingreso_aplicacion_;
	iUsuario us = new BD_Principal();
	iUsuario use = new BD_Principal();
	List<bbdd.Registrado> usuarios = us.cargarUsuarios();
	List<bbdd.Administrador> admins = use.cargarAdmins();
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
		for(int i = 0; i<=usuarios.size()-1; i++) {
			if(user.equals(usuarios.get(i).getNombre()) &&
					pass.equals(usuarios.get(i).getPass())){
				loginOk = true;
			}else {
				loginOk = false;
			}
		}
		if(loginOk) {
			UI.getCurrent().getNavigator().navigateTo("Registrado");
		} else {
			for(int i = 0; i<=admins.size()-1; i++) {
				if(user.equals(admins.get(i).getNombre()) &&
						pass.equals(admins.get(i).getPass())){
					loginOk = true;
				}else {
					loginOk = false;
				}
			}
		}
		if(loginOk) {
			Notification.show("asdasd");
		} else {
			errorLogin.setValue("El login no es correcto");
			errorLogin.setVisible(true);
		}
	}
}