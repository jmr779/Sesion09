package ventanas;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.annotations.DesignRoot;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.declarative.Design;

/** 
 * !! DO NOT EDIT THIS FILE !!
 * 
 * This class is generated by Vaadin Designer and will be overwritten.
 * 
 * Please make a subclass with logic and additional interfaces as needed,
 * e.g class LoginView extends LoginDesign implements View { }
 */
@DesignRoot
@AutoGenerated
@SuppressWarnings("serial")
public class Registro_ventana extends VerticalLayout {
	protected Label lUsuario;
	protected TextField tUsername;
	protected Label luser;
	protected TextField tEmail;
	protected Label lemail;
	protected HorizontalLayout hPass;
	protected PasswordField tPass;
	protected PasswordField tRepPass;
	protected Label lpass;
	protected Label errorLogin;
	protected Label errorLogin1;
	protected Button botonRegistrarse;
	protected Button botonCancelar;
	protected Label registro;

	public Registro_ventana() {
		Design.read(this);
	}
}
