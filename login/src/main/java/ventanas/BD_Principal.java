package ventanas;

import java.util.Date;
import java.util.List;

import org.orm.PersistentException;

public class BD_Principal implements iUsuario {
	public BD_Administrador _bD_Administrador;
	public BD_Registrado registrado = new BD_Registrado();

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
		try {
			registrado.registrarse(aEmail, aNombre, aFechaCreacion, aFechaUltimoAcceso, aPass);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void modificarDatos(String aEmail, String aPass) {
		throw new UnsupportedOperationException();
	}

	public void modificarDatosUserListado(String aEmail, String aPass, String aNombre, boolean aActivo) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List login() {
		List user = null;
		try {
			user = registrado.login();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
}