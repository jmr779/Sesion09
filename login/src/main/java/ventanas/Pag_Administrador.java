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
import com.vaadin.ui.renderers.ButtonRenderer;

import bbdd.*;

public class Pag_Administrador extends Pag_Administrador_ventana implements View{
	public ListarUsuarios _unnamed_ListarUsuarios_;
	public ModificarDatosUserListado _unnamed_ModificarDatosUserListado_;
	iUsuario us = new BD_Principal();
	List<bbdd.Registrado> usuarios = us.cargarUsuarios2();
	//Grid <bbdd.Registrado> grid = new Grid<>();
	public Pag_Administrador()  {
		Grid <bbdd.Registrado> grid = new Grid<>();
		grid.setVisible(true);
		grid.setWidth("1000px");
		grid.setItems(usuarios);	
		grid.addColumn(bbdd.Registrado::getNombre).setCaption("Usuario");
		grid.addColumn(bbdd.Registrado::getEmail).setCaption("Email");
		grid.addColumn(bbdd.Registrado::getActivo).setCaption("Activo");
		grid.addColumn(bbdd.Registrado::getFechaCreacion).setCaption("Fecha de registro");
		grid.addColumn(bbdd.Registrado::getFechaUltimoAcceso).setCaption("Ultimo acceso");
		grid.addColumn(bbdd.Registrado::getRol).setCaption("Rol");
		grid.addColumn(usuarios -> "Modificar",
			      new ButtonRenderer(clickEvent -> {
			    	  grid.setVisible(false);
			    	  vModificar.setVisible(true);
			    	  String usu = grid.asSingleSelect().getValue().getNombre();
			    	  String email = grid.asSingleSelect().getValue().getEmail();
			    	  String pass = grid.asSingleSelect().getValue().getPass();
			    	  boolean activo = grid.asSingleSelect().getValue().getActivo();
			    	  verDatos(usu, email, pass, activo);
			    }));
		/*grid.addColumn(usuarios -> "Borrar",
			      new ButtonRenderer(clickEvent -> {
			          String a = grid.getId();
			          Notification.show(a);
			    }));*/
		botonGuardar.addClickListener(new ClickListener() {
			
			public void buttonClick(ClickEvent event) {
				int ID_user = grid.asSingleSelect().getValue().getORMID();
				modificar(ID_user);
			}
		});
		bListar.addClickListener(new ClickListener() {
			
			public void buttonClick(ClickEvent event) {
				layoutCrearUsuario.setVisible(false);
				vModificar.setVisible(false);
				layoutGrid.addComponent(grid);
				grid.setVisible(true);
			}
		});
		bCrear.addClickListener(new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				grid.setVisible(false);
				layoutCrearUsuario.setVisible(true);
			}
		});
		botonCrear.addClickListener(new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				crearUsuario();
			}
		});
		bCerrarSesion.addClickListener(new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				UI.getCurrent().getNavigator().navigateTo("");
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
	public void verDatos(String usuario, String email, 
			String pass, boolean activo) {
		tUsername1.setValue(usuario);
		tEmail1.setValue(email);
		tPass1.setValue(pass);
		tRepPass1.setValue(pass);
		cActivo1.setValue(activo);
	}
	public void modificar(int ID_user) {
		registroOk1.setVisible(false);
		errorLogin2.setVisible(false);
		errorLogin3.setVisible(false);
		errorLogin4.setVisible(false);
		int id = ID_user;
		String nombre = tUsername1.getValue();
		String email = tEmail1.getValue();
		String pass = tPass1.getValue();
		String rol = "";
		boolean activo = true;
		boolean modificarOk = true;
		if (pass.length() == 0 || tRepPass1.getValue().length() == 0) {
			errorLogin2.setValue("Necesario campos Contrasena para registrarse");
			errorLogin2.setVisible(true);
			modificarOk = false;
		} else if (!pass.equals(tRepPass1.getValue())) {
			errorLogin3.setValue("No coinciden las contrasenas");
			errorLogin3.setVisible(true);
			modificarOk = false;
		} else {
			modificarOk = true;
		}
		if(rbotones1.isSelected("Option1")) {
			rol = "Admin";
		}else if(rbotones1.isSelected("Option2")) {
			rol = "Registrado";
		} else {
			errorLogin4.setValue("Debe seleccionar un rol");
			errorLogin4.setVisible(true);
			modificarOk = false;
		}
		if(cActivo1.getValue()) {
			activo = true;
		}else {
			activo = false;
		}
		if(modificarOk) {
			registroOk1.setVisible(true);
			us.modificarDatosUserListado(id, email, pass, nombre, activo, rol);
		}
	}
}