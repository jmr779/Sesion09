package ventanas;

import java.util.List;

import org.orm.PersistentException;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Grid;
import com.vaadin.ui.NativeButton;

import bbdd.*;

public class Pag_Administrador  extends Pag_Administrador_ventana{
	public ListarUsuarios _unnamed_ListarUsuarios_;
	public ModificarDatosUserListado _unnamed_ModificarDatosUserListado_;
	public BD_Registrado regis = new BD_Registrado();
	
	public Pag_Administrador() throws PersistentException {
		
		Grid <bbdd.Registrado> grid = new Grid<>();
		List<bbdd.Registrado> lista = regis.cargarUsuarios();
		grid.setItems(lista);
		
		grid.addColumn(bbdd.Registrado::getNombre);
		/////////grid.addColumn(new NativeButton("Boton"));
		
		bListar.addClickListener(new ClickListener() {
			
			public void buttonClick(ClickEvent event) {
				
				
				
			}
		});
	}
}