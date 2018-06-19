package ventanas;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.orm.PersistentException;

import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

public class Registro extends Registro_ventana {
	public Ingreso_aplicacion _unnamed_Ingreso_aplicacion_;
	iUsuario us = new BD_Principal();
	List<bbdd.Registrado> usuarios = us.cargarUsuarios2();

	iUsuario user = new BD_Principal();

	public Registro() {

		botonRegistrarse.addClickListener(new ClickListener() {

			public void buttonClick(ClickEvent event) {
				registrarse();
			}
		});

	}

	public void registrarse() {
		String email = tEmail.getValue();
		String pass = tPass.getValue();
		String nombre = tUsername.getValue();
		java.util.Date utilDate = new java.util.Date();
		Date fechaU = null;
		String rol = "Registrado";
		if (nombre.length() == 0 || pass.length() == 0 || tRepPass.getValue().length() == 0) {
			errorLogin.setValue("Necesarios campos Username y Contraseña para registrarse");
			errorLogin.setVisible(true);
		} else if (!pass.equals(tRepPass.getValue())) {
			errorLogin1.setValue("No coinciden las contraseñas");
			errorLogin1.setVisible(true);
		} 
		else {
			/*for (int i = 0; i <= usuarios.size(); i++) {
				if (nombre.equals(usuarios.get(i).getNombre())){
					errorLogin1.setValue("El Username ya esta registrado");
					errorLogin1.setVisible(true);
				}
			}*/
			user.registrarse(email, pass, nombre, utilDate, fechaU, rol);
		}
	}
}