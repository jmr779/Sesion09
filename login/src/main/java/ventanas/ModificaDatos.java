package ventanas;

import com.vaadin.ui.Notification;

public class ModificaDatos extends ModificaDatos_ventana{
	iUsuario user = new BD_Principal();
	
	public Pag_Registrado _unnamed_Pag_Registrado_;

	public ModificaDatos() {
		
		tUsername.setVisible(false);
		modificarDatos();
	}
	
	public void modificarDatos() {
		int ID = IniciarSesion.variableGlobal;
		
		String contraseña = tPass.getValue();
		String email = tEmail.getValue();
		//int ID = Sesion.getIdUsuario();
		user.modificarDatos(email, contraseña,ID);
	}
}