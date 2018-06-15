package ventanas;


import java.sql.Date;
import java.util.List;
import java.util.Vector;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;


public class BD_Administrador {
	public BD_Principal _bD_Principal;
	public Vector<Administrador> _administradors = new Vector<Administrador>();

	public void eliminarUsuario(int aID) {
		throw new UnsupportedOperationException();
	}

	public void crearUsuario(int aID, String aEmail, String pass, Date aFechaCreacion, Date aFechaUltimoAcceso) {
		throw new UnsupportedOperationException();
	}

	public Usuario listarUsuarios() {
		throw new UnsupportedOperationException();
	}

	public void modificarDatosUserListado(String aEmail, String aPass, String aNombre, boolean aActivo) {
		throw new UnsupportedOperationException();
	}
	public List cargarAdmins() throws PersistentException {
		List ad = null;
		PersistentTransaction t = bbdd.ProyectoHMISPersistentManager.instance().getSession().beginTransaction();
		try {
			ad = bbdd.AdministradorDAO.queryAdministrador(null, null);
		} catch (PersistentException e) {
			t.rollback();
		}
		return ad;
	}
}