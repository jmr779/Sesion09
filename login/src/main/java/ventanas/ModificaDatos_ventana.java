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
public class ModificaDatos_ventana extends VerticalLayout {
	protected Label lUsuario;
	protected TextField tApodo;
	protected Label errorApodo;
	protected TextField tEmail;
	protected Label errorEmail;
	protected HorizontalLayout hPass;
	protected PasswordField tPass;
	protected PasswordField tRepPass;
	protected Label errorPass;
	protected Button botonRegistrarse1;
	protected Button botonRegistrarse;

	public ModificaDatos_ventana() {
		Design.read(this);
	}
}