package ventanas;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;

public class IniciarSesion extends IniciarSesion_ventana{
	public Ingreso_aplicacion _unnamed_Ingreso_aplicacion_;
	iUsuario us = new BD_Principal();
	
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
		us.login(user, pass);
	}
}