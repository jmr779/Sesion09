package ventanas;

import java.util.List;

import org.orm.PersistentException;

import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Grid;
import com.vaadin.ui.NativeButton;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

import bbdd.*;

public class Pag_Administrador  extends Pag_Administrador_ventana implements View{
	public ListarUsuarios _unnamed_ListarUsuarios_;
	public ModificarDatosUserListado _unnamed_ModificarDatosUserListado_;
	public BD_Registrado regis = new BD_Registrado();
	
	public Pag_Administrador() throws PersistentException {
		
		Grid <bbdd.Registrado> grid = new Grid<>();
		List<bbdd.Registrado> lista = regis.cargarUsuarios();
		grid.setItems(lista);
		
		grid.addColumn(bbdd.Registrado::getNombre);
		//grid.addColumn(new Button("Modificar"));
		grid.addColumn(bbdd.Registrado::boton);
		
		bListar.addClickListener(new ClickListener() {
			
			public void buttonClick(ClickEvent event) {
				
				layoutGrid.addComponent(grid);
				
			}
		});
		
		bCrear.addClickListener(new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				Window popup = new Window();
				VerticalLayout subContent = new VerticalLayout();
				popup.setContent(subContent);
				subContent.addComponent(layoutCrearUsuario);
				layoutCrearUsuario.setVisible(true);
				popup.center();
				// Closable elimina el boton de cerrar del popup
				// popup.setClosable(false);
				popup.setModal(true);
				popup.setResizable(false);
				UI.getCurrent().addWindow(popup);
			}
		});
	}
}