package ventanas;

import java.util.Date;

public class BD_Principal implements iUsuario {
	public BD_Administrador _bD_Administrador;
	public BD_Registrado _bD_Registrado;

	public void eliminarUsuario(int aID) {
		throw new UnsupportedOperationException();
	}

	public void crearUsuario(int aID, String aEmail, String aPass, Date aFechaCreacion, Date aFechaUltimoAcceso) {
		throw new UnsupportedOperationException();
	}

	public Usuario listarUsuarios() {
		throw new UnsupportedOperationException();
	}

	public void registrarse(String aEmail, String aPass, String aNombre, Date aFechaCreacion, Date aFechaUltimoAcceso) {
		throw new UnsupportedOperationException();
	}

	public void modificarDatos(String aEmail, String aPass) {
		throw new UnsupportedOperationException();
	}

	public void modificarDatosUserListado(String aEmail, String aPass, String aNombre, boolean aActivo) {
		throw new UnsupportedOperationException();
	}
}