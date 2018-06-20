package ventanas;

import com.vaadin.navigator.View;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

import bbdd.Registrado;

import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Notification;

public class Pag_Registrado extends Pag_Registrado_ventana implements View {
	ModificaDatos modificarDatos = new ModificaDatos();
	Window popup = new Window();
	VerticalLayout subContent = new VerticalLayout();
	Registrado reg = new Registrado();


	public Pag_Registrado() {
		
		inicializar();
		//lnombreRegistrado.setValue((String) getSession().getAttribute("user"));
		
		bmodificarDatos.addClickListener(new ClickListener() {

			public void buttonClick(ClickEvent event) {
				popup.setContent(subContent);
				subContent.addComponent(modificarDatos);
				popup.center();
				popup.setWidth("720px");
				popup.setModal(true);
				UI.getCurrent().addWindow(popup);

			}
		});
		bcerrarSesion.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				UI.getCurrent().getNavigator().navigateTo("");
			}
		});
		// Creamos la operacion de modificar datos
		modificarDatos.botonGuardar.addClickListener(new ClickListener() {

			public void buttonClick(ClickEvent event) {
				modificarDatos.modificarDatos();
				popup.close();

			}
		});

		// Cerramos el pop-up
		modificarDatos.botonCancelar.addClickListener(new ClickListener() {

			public void buttonClick(ClickEvent event) {
				popup.close();

			}
		});

	}
	public void inicializar() {
		// No se si funciona del todo el getSession porque no me abre la aplicacion al usarlo
		//String a = (String) getSession().getAttribute("user");
		//String a = reg.getNombre();
		/////////Siempre da 0 de la id porque es el unico que ha iniciado sesion
		int a = reg.getORMID();
		String b = Integer.toString(a);
		lnombreRegistrado.setValue(b);
		//Notification.show(a);
	}
}