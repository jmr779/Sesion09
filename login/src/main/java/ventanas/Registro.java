package ventanas;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.orm.PersistentException;

import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

public class Registro extends Registro_ventana{
	public Ingreso_aplicacion _unnamed_Ingreso_aplicacion_;
	
	iUsuario user = new BD_Principal();
	
	public Registro() {
	
		botonRegistrarse.addClickListener(new ClickListener() {
			
			public void buttonClick(ClickEvent event) {
					registrarse();
			}
		});

	}
	public void registrarse(){
		String email = tEmail.getValue();
		String pass = tPass.getValue();
		String nombre = tUsername.getValue();
		java.util.Date utilDate = new java.util.Date();
		Date fechaU = null;
		String rol = "Registrado";
		user.registrarse(email, pass, nombre, utilDate, fechaU, rol);
	}
}