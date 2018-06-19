package ventanas;

import java.rmi.activation.ActivationGroup_Stub;
import java.util.Date;
import java.util.List;

import org.hibernate.cfg.beanvalidation.ActivationContext;
import org.orm.PersistentException;

import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Grid;
import com.vaadin.ui.NativeButton;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

import bbdd.*;

public class Pag_Administrador extends Pag_Administrador_ventana implements View{
	public ListarUsuarios _unnamed_ListarUsuarios_;
	public ModificarDatosUserListado _unnamed_ModificarDatosUserListado_;
	iUsuario us = new BD_Principal();
	List<bbdd.Registrado> usuarios = us.cargarUsuarios2();
	
	public Pag_Administrador()  {
		/*Grid <bbdd.Registrado> grid = new Grid<>();

		grid.setItems(lista);
		
		grid.addColumn(bbdd.Registrado::getNombre);
		//grid.addColumn(new Button("Modificar"));
		grid.addColumn(bbdd.Registrado::boton);
		*/
		bListar.addClickListener(new ClickListener() {
			
			public void buttonClick(ClickEvent event) {
				Notification.show(usuarios.get(1).getNombre());
				
			}
		});
		bCrear.addClickListener(new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				layoutCrearUsuario.setVisible(true);
			}
		});
		botonCrear.addClickListener(new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				crearUsuario();
			}
		});
	}
	public void crearUsuario() {
		String nombre = tUsername.getValue();
		String email = tEmail.getValue();
		String pass = tPass.getValue();
		String rol = "";
		boolean activo = true;
		java.util.Date utilDate = new java.util.Date();
		Date fechaU = null;
		if(rbotones.isSelected("Option1")) {
			rol = "Admin";
		}
		if(rbotones.isSelected("Option2")) {
			rol = "Registrado";
		}
		if(cActivo.getValue()) {
			activo = true;
		}else {
			activo = false;
		}
		us.crearUsuario(nombre, email, pass, activo, utilDate, fechaU, rol);
	}
}