package ventanas;

import java.util.Date;
import java.util.List;

import org.orm.PersistentException;

public class BD_Principal implements iUsuario {
	public BD_Registrado registrado = new BD_Registrado();


	public void eliminarUsuario(int aID) {
		throw new UnsupportedOperationException();
	}

	public void crearUsuario(String aNombre, String aEmail, String aPass, boolean aActivo, Date aFechaCreacion, Date aFechaUltimoAcceso, String aRol) {
		try {
			registrado.crearUsuario(aNombre, aEmail, aPass, aActivo, aFechaCreacion, aFechaUltimoAcceso, aRol);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Usuario listarUsuarios() {
		throw new UnsupportedOperationException();
	}

	public void registrarse(String aEmail, String aPass, String aNombre, Date aFechaCreacion, Date aFechaUltimoAcceso, String rol) {
		try {
			registrado.registrarse(aEmail, aNombre, aFechaCreacion, aFechaUltimoAcceso, aPass, rol);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void modificarDatos(String aEmail, String aPass) {
		try {
			registrado.modificarDatos(aEmail, aPass);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void modificarDatosUserListado(int aID, String aEmail, String aPass, String aNombre, boolean aActivo, String aRol) {
		try {
			registrado.modificarDatosUserListado(aID, aEmail, aPass, aNombre, aActivo, aRol);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List cargarUsuarios() {
		List user = null;
		try {
			user = this.registrado.cargarUsuarios();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
	public List cargarUsuarios2() {
		List user = null;
		try {
			user = this.registrado.cargarUsuarios2();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
}