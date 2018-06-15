package ventanas;


import java.util.Date;
import java.util.List;
import java.util.Vector;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import bbdd.Registrado;

public class BD_Registrado {
	public BD_Principal _bD_Principal;
	public Vector<Registrado> _registrados = new Vector<Registrado>();

	public void modificarDatos(String aEmail, String aPass) {
		throw new UnsupportedOperationException();
	}

	public void registrarse(String aEmail, String aNombre, Date aFechaCreacion, Date aFechaUltimoAcceso, String aPass) {
		throw new UnsupportedOperationException();
	}

	public void eliminarUsuario(int aID) {
		throw new UnsupportedOperationException();
	}

	public void crearUsuario(int aID, String aEmail, String aPass, Date aFechaCreacion, Date aFechaUltimoAcceso) {
		throw new UnsupportedOperationException();
	}

	public Usuario listarUsuarios() {
		throw new UnsupportedOperationException();
	}

	public void modificarDatosUserListado(String aEmail, String aPass, String aNombre, boolean aActivo) {
		throw new UnsupportedOperationException();
	}
	
	public List cargarUsuarios() throws PersistentException {
		List usu = null;
		PersistentTransaction t = bbdd.ProyectoHMISPersistentManager.instance().getSession().beginTransaction();
		try {
			usu = bbdd.RegistradoDAO.queryRegistrado(null, null);
		} catch (PersistentException e) {
			t.rollback();
		}
		return usu;
	}
}