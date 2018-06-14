package ventanas;

import com.vaadin.navigator.View;

public class Ingreso_aplicacion extends Ingreso_aplicacion_ventana implements View{
	public Usuario _unnamed_Usuario_;
	public Registro _unnamed_Registro_;
	public IniciarSesion ini = new IniciarSesion();
	
	public Ingreso_aplicacion() {
		addComponent(ini);
	}
}