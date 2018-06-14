package ventanas;

import com.vaadin.navigator.View;

public class Ingreso_aplicacion extends Ingreso_aplicacion_ventana implements View{
	public IniciarSesion ini= new IniciarSesion(); 
	public Registro reg= new Registro();
	
	public Ingreso_aplicacion() {
		horizontalLayout.addComponent(ini);
		horizontalLayout.addComponent(reg);
	
		
	}
	
	//Hacer una clase de registro
	
}